package com.project.heyyo.member.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
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

import com.project.heyyo.content.model.Content;

@Controller
public class MessageController {

	@Autowired
	@Qualifier("myMessageDao")
	private MessageDao messageDao;

	// ���� ����Ʈ
	@RequestMapping(value = "list.ms", method = RequestMethod.GET)
	public ModelAndView viewMain(
			@RequestParam(value="receiver", required = false) String receiver,
			HttpSession session
			) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("receiver", receiver);
		
		List<Message> messageLists = messageDao.getAllMessage(map);

		mav.addObject("messageLists", messageLists);
		mav.setViewName("MessagePage");

		return mav;
	}
	
	// ���� form
	@RequestMapping(value = "write.ms", method = RequestMethod.GET)
	public String viewMesseageWriteForm(HttpSession session) {
		if(session.getAttribute("id") == "" || session.getAttribute("id") == null) {
			System.out.println("�α����� �ʿ��� ���� �Դϴ�.");
			return "redirect:main.do";
		}
		return "MessageWriteForm";
	}

	// ���� ����
	@RequestMapping(value = "sending.ms", method = RequestMethod.POST)
	public String doActionWrite(
			@ModelAttribute("Message") @Valid Message message,
			BindingResult bindingResult) {
		
		System.out.println("������ ���" + message.getSender());
		System.out.println("�޴� ���" + message.getReceiver());
		
		messageDao.sendingMessage(message);
		
		return "redirect:main.do";
	}
	
	

}
