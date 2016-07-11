package com.project.heyyo.member;

import java.io.File;
import java.io.IOException;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.member.model.Member;
import com.project.heyyo.member.model.MemberDao;
import com.project.heyyo.member.message.Message;
import com.project.heyyo.member.message.MessageDao;

@Controller
public class MemberController {

	@Autowired
	@Qualifier("myMemberDao")
	private MemberDao memberDao;

	@Autowired
	@Qualifier("myMessageDao")
	private MessageDao messageDao;

	@RequestMapping(value = "signup.mb")
	public String viewSignUpForm() {
		return "SignUpForm";
	}

	@RequestMapping(value = "id_test.mb")
	public String viewId_testForm() {
		return "id_Test";
	}

	@RequestMapping(value = "pw_test.mb")
	public String viewPw_testForm() {
		return "pw_Test";
	}

	@RequestMapping(value = "write.mb", method = RequestMethod.POST)
	public ModelAndView insertSignUp(
			@ModelAttribute("Member") @Valid Member member,
			@RequestParam("profile_img") MultipartFile profile_img,
			BindingResult bindingResult) throws IllegalStateException, IOException {

		System.out.println("write.mb �뱾�뼱�샂");
		System.out.println(member.getAddress());
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.InquiryEmail(member.getEmail().trim());
		
		if (mb == null) {
			
			if(profile_img.getOriginalFilename() != "") {
				String fileName = profile_img.getOriginalFilename();
				File file = new File("C:/git_workspace/HeyYo/src/main/webapp/resources/images/profile/" + fileName);
				profile_img.transferTo(file);
				
				member.setImage(fileName);
			} else {
				member.setImage("default_img.png");
			}
			
			int insert = memberDao.insert(member);
			System.out.println(insert);
			
			mav.setViewName("redirect:main.do");
		} else {
			mav.setViewName("SignUpForm");
		}

		return mav;
	}

	@RequestMapping(value = "login.mb", method = RequestMethod.POST)
	public ModelAndView login(Member member, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		Member mb = memberDao.InquiryEmail(member.getEmail().trim());

		if (mb == null) {
			
			mav.setViewName("redirect:main.do");
		} else {
			if (member.getEmail().trim().equals(mb.getEmail())
					&& member.getPw().trim().equals(mb.getPw())) {
				int receiver = memberDao.selectMemberIdByEmail(member.getEmail());
				int cnt = messageDao.getCntNewMessage(receiver);
				
				session.setAttribute("loginfo", mb);
				session.setAttribute("cntNewMessage", cnt);
				mav.setViewName("redirect:main.do");
				

			} else {
				mav.setViewName("redirect:main.do");
			}
		}
		return mav;

	}

	// id 李얍뜝�룞�삕
	@RequestMapping(value = "idInquiry.mb", method = RequestMethod.POST)
	public ModelAndView idInquiry(
			@ModelAttribute("Member") @Valid Member member,
			BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		Member mb = memberDao.email_test(member);
		if (mb == null) {
			// mav.setViewName("");
		} else {
			// mav.setViewName("test");
		}
		return mav;
	}

	// pw 李얍뜝�룞�삕
	@RequestMapping(value = "pwInquiry.mb", method = RequestMethod.POST)
	public ModelAndView pwInquiry(
			@ModelAttribute("Member") @Valid Member member,
			BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		Member mb = memberDao.pw_test(member);
		if (mb == null) {
			// mav.setViewName("");
		} else {
			mav.addObject("mb", mb);
			// mav.setViewName("test");
			mav.setViewName("test");//�뜝�룞�삕�뜝�룞�삕�뜝�뙏�빞�벝�삕
		}
		return mav;
	}
	
	@RequestMapping(value="user_detail.mb")
	public String viewUser() {
		return "UserDetailView";
	}
	
	
	@RequestMapping(value="logout.mb")
	public String doActionlogout(HttpSession session) {
		session.removeAttribute("loginfo");
		return "forward:main.do";
	}
}