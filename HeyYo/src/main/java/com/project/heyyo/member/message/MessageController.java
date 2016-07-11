package com.project.heyyo.member.message;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.member.message.Message;
import com.project.heyyo.member.message.MessageDao;

@Controller
public class MessageController {

	@Autowired
	@Qualifier("myMessageDao")
	private MessageDao messageDao;

	// 받은 쪽지 리스트
	@RequestMapping(value = "receiveList.ms", method = RequestMethod.GET)
	public ModelAndView viewReceiveMessageList(
			@RequestParam(value="receiver", required = false) int receiver,
			HttpSession session
			) {
		ModelAndView mav = new ModelAndView();

		List<Message> messageLists = messageDao.getReceiveMessage(receiver);

		mav.addObject("messageLists", messageLists);
		mav.setViewName("ReceiveMessageList");

		return mav;
	}

	// 보낸 쪽지 리스트
	@RequestMapping(value = "sendList.ms", method = RequestMethod.GET)
	public ModelAndView viewSendMessageList(
			@RequestParam(value="sender", required = false) int sender,
			HttpSession session
			) {
		ModelAndView mav = new ModelAndView();

		List<Message> messageLists = messageDao.getSendMessage(sender);

		mav.addObject("messageLists", messageLists);
		mav.setViewName("SendMessageList");

		return mav;
	}

	// 쪽지 form
	@RequestMapping(value = "write.ms", method = RequestMethod.GET)
	public ModelAndView viewMesseageWriteForm(
			@RequestParam(value="id", required = false) int id,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id",id);
		mav.setViewName("MessageWriteForm");
		return mav;
	}

	// 쪽지 쓰기
	@RequestMapping(value = "sending.ms", method = RequestMethod.POST)
	public String doActionWrite(
			@ModelAttribute("Message") @Valid Message message,
			BindingResult bindingResult) {
		
		System.out.println("쪽지번호" + message.getMs_num());
		System.out.println("보내는 사람" + message.getSender());
		System.out.println("받는 사람" + message.getReceiver());
		System.out.println("쪽지 내용" + message.getMs_content());

		messageDao.sendingMessage(message);

		return "redirect:main.do";
	}

	//쪽지 상세보기
	@RequestMapping(value="detailMessage.ms", method = RequestMethod.GET)
	public ModelAndView viewDetail(
			@RequestParam(value="ms_num") int ms_num,
			@RequestParam(value="messageType") String messageType,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println(messageType);
		
		if(messageType.equals("receive")){
			System.out.println(ms_num+"번 쪽지 읽음");
			messageDao.readingMessage(ms_num);
		}
		Message message = new Message();
		message = messageDao.selectMessageByNum(ms_num);
		System.out.println(message.getMs_content());
		System.out.println(message.getMs_date());
		System.out.println(message.getMs_num());
		System.out.println(message.getMs_state());
		System.out.println(message.getSender());
		//System.out.println("쪽지 상세 보기" + message.getMs_num() +"번 쪽지" );
		mav.addObject("message",message);
		mav.addObject("messageType",messageType);
		mav.setViewName("DetailMessageForm");

		return mav;
	}


	//쪽지 삭제
	@RequestMapping(value= "delete.ms")
	public ModelAndView deleteMessage (
			@RequestParam(value="messageType", required = false) String messageType,
			@RequestParam(value="ms_num", required = false) int ms_num,
			@RequestParam(value="sender", required = false) int sender,
			@RequestParam(value="receiver", required = false) int receiver,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		System.out.println("삭제하려는 메세지 타입 : "+messageType);
		System.out.println(ms_num+"번 쪽지");
		if(messageType.equals("send")){
			System.out.println("보낸 쪽지 삭제 : "+ms_num+"번 쪽지");
			messageDao.deleteSendMessage(ms_num);
			List<Message> messageLists = messageDao.getSendMessage(sender);

			mav.addObject("messageLists", messageLists);
			mav.setViewName("SendMessageList");
			return mav;
		}else if(messageType.equals("receive")){
			System.out.println("받은 쪽지 삭제 : "+ms_num+"번 쪽지");
			messageDao.deleteReceiveMessage(ms_num);

			List<Message> messageLists = messageDao.getReceiveMessage(receiver);

			mav.addObject("messageLists", messageLists);
			mav.setViewName("ReceiveMessageList");
			return mav;
		}
		else{
			System.out.println("쪽지 삭제 에러");
			List<Message> messageLists = messageDao.getReceiveMessage(receiver);

			mav.addObject("messageLists", messageLists);
			mav.setViewName("ReceiveMessageList");
			return mav;
		}

	}
}
