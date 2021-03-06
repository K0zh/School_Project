package com.project.heyyo.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@RequestMapping(value="myPage.mb")
	public ModelAndView viewUser(@RequestParam(value="id", required = false) int id,
				HttpSession session
				) {
			ModelAndView mav = new ModelAndView();
 
 
			Member mem = memberDao.selectMemberById(id);
 
			mav.addObject("mem", mem);
			mav.setViewName("UserDetailView");
 
			return mav;
		}

	
	@RequestMapping(value = "idInquiry.mb", method = RequestMethod.POST)
	public ModelAndView idInquiry(
			@ModelAttribute("Member") @Valid Member member,
			BindingResult bindingResult,ModelMap model) {
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.email_test(member);
		System.out.println(mb);
		if (mb == null) {
			model.addAttribute("msg", "찾는 아이디가 없습니다.");
			model.addAttribute("url", "main.do");
			mav.setViewName("redirect");
		} else {
			model.addAttribute("msg", "찾으시는 이메일은 "+mb.getEmail()+" 입니다.");
			model.addAttribute("url", "main.do");
			mav.setViewName("redirect");
		}
		return mav;
	}

	@RequestMapping(value = "pwInquiry.mb", method = RequestMethod.POST)
	public ModelAndView pwInquiry(
			@ModelAttribute("Member") @Valid Member member,
			BindingResult bindingResult,ModelMap model) {
		ModelAndView mav = new ModelAndView();
		System.out.println(member.getName());
		System.out.println(member.getHp());

		Member mb = memberDao.pw_test(member);
		System.out.println(mb);
		
		if (mb == null) {
			model.addAttribute("msg", "찾는 비밀번호가 없습니다.");
			model.addAttribute("url", "main.do");
			mav.setViewName("redirect");
		} else {
			mav.addObject("mb", mb);
			model.addAttribute("msg", "찾으시는 비밀번호는 "+mb.getPw()+" 입니다.");
			model.addAttribute("url", "main.do");
			mav.setViewName("redirect");
		}
		return mav;
	}
	
	@RequestMapping(value="updateForm.mb")
	public ModelAndView updateInfo(@RequestParam(value="id", required = false) int id,
				HttpSession session
				) {
			ModelAndView mav = new ModelAndView();
 
			Member mem = memberDao.selectMemberById(id);
 
			mav.addObject("mem", mem);
			mav.setViewName("UserUpdateForm");
 
			return mav;
		}
	@RequestMapping(value = "updateMember.mb", method = RequestMethod.POST)
	public ModelAndView updateMember(
			@ModelAttribute("Member") @Valid Member member,
			BindingResult bindingResult) {

		memberDao.modifyMemberInfo(member);

		ModelAndView mav = new ModelAndView();
		 
		mav.addObject("mem", member);
		mav.setViewName("UserDetailView");
		
		return mav;
	}
	
	@RequestMapping(value="deleteForm.mb")
	public ModelAndView deleteForm(@RequestParam(value="id", required = false) int id,
				HttpSession session
				) {
			ModelAndView mav = new ModelAndView();
 
			Member mem = memberDao.selectMemberById(id);
 
			mav.addObject("mem", mem);
			mav.setViewName("UserDeleteForm");
 
			return mav;
		}
	@RequestMapping(value="deleteMember.mb")
	public ModelAndView deleteMember(@RequestParam(value="id", required = false) int id,
				HttpSession session
				) {
			memberDao.deleteMember(id);
			System.out.println(id+" 멤버 탈퇴 성공");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:main.do");
			return mav;
		}
	
	
	@RequestMapping(value="logout.mb")
	public String doActionlogout(HttpSession session) {
		session.removeAttribute("loginfo");
		return "forward:main.do";
	}
}