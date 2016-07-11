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

@Controller
public class MemberController {

	@Autowired
	@Qualifier("myMemberDao")
	private MemberDao memberDao;

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

		System.out.println("write.mb µé¾î¿È");
		System.out.println(member.getAddress());
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.InquiryEmail(member.getEmail().trim());
		
		if (mb == null) {
			
			if(profile_img.getOriginalFilename() != "") {
				String fileName = profile_img.getOriginalFilename();
				File file = new File("D:/Spring_workspace/HeyYo/src/main/webapp/resources/images/profile/" + fileName);
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
				

				session.setAttribute("loginfo", mb);
				mav.setViewName("redirect:main.do");

			} else {
				mav.setViewName("redirect:main.do");
			}
		}
		return mav;

	}

	// id Ã£ï¿½ï¿½
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

	// pw Ã£ï¿½ï¿½
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
			mav.setViewName("test");//ï¿½ï¿½ï¿½ï¿½ï¿½Ø¾ßµï¿½
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