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


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;







import com.project.heyyo.member.model.Member;
import com.project.heyyo.member.model.MemberDao;

@Controller
public class MemberController {

	@Autowired
	@Qualifier("myMemberDao")
	private MemberDao memberDao;

	
	@RequestMapping(value="signup.mb")
	public String viewSignUpForm() {
		return "SignUpForm";
	}
	
	@RequestMapping(value="id_test.mb")
	public String viewId_testForm(){
		return "id_Test";
	}
	@RequestMapping(value="pw_test.mb")
	public String viewPw_testForm(){
		return "pw_Test";
	}
	@RequestMapping(value="test.mb")
	public String testForm(){
		return "TEST";
	}
	//쪽지함 테스트
	@RequestMapping(value="test1.mb")
	public String test1Form(){
		return "test1";
	}
	//쪽지쓰기
	@RequestMapping(value="test11.mb")
	public String test11Form(){
		return "test1-1";
	}
	//보낸 쪽지함
	@RequestMapping(value="test2.mb")
	public String test2Form(){
		return "test2";
	}
	
	//상세 쪽지함 임시 Detail_message.mb
	@RequestMapping(value="Detail_message.mb")
	public String Detail_message(){
		return "Detail_message";
	}
	
	//회원가입 부분
	@RequestMapping(value="write.mb",method=RequestMethod.POST)
	public ModelAndView insertSignUp(
			@ModelAttribute("Member") @Valid Member member, 
			BindingResult bindingResult){
		
		System.out.println(member.getBirthday());
		ModelAndView mav = new ModelAndView();
		
		System.out.println("들어온 이메일:"+member.getEmail());
		Member mb = memberDao.InquiryEmail(member.getEmail().trim());
		System.out.println("이메일 증복여부:"+mb);
		
		if(mb==null){
			System.out.println("이메일 증복 없음");
			System.out.println("이미지:"+member.getImage());
			int insert = -1; 
			insert = memberDao.insert(member);
			System.out.println("등록 여부:"+insert);
			if(insert!=-1){
				mav.setViewName("");//메인
			}else{
				mav.setViewName("SignUpForm");
			}
		}else{
			System.out.println("이메일 증복됨");
			mav.setViewName("SignUpForm");
		}
		return mav;
	}
	
	//로그인 부분
	@RequestMapping(value="login.mb",method=RequestMethod.POST)
	public ModelAndView login(Member member,HttpSession session
			){
		System.out.println("로그인 이메일:"+member.getEmail());
		System.out.println("로그인 비번:"+member.getPw());
		
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.InquiryEmail(member.getEmail().trim());
		System.out.println("이메일 증복여부:"+mb);
		
		if(mb==null){
			System.out.println("아이디가 없습니다.");
			//mav.setViewName("");
		}else{
			if(member.getEmail().trim().equals(mb.getEmail())&&
					member.getPw().trim().equals(mb.getPw())){
				System.out.println("이메일 비번 맞음.");
				
				session.setAttribute("loginfo", mb); 
				//mav.setViewName("");
				
			}else{
				System.out.println("비밀번호가 틀렸습니다");
				//mav.setViewName("");
			}
		}
		return mav;
		
	}
	//id 찾기
	@RequestMapping(value="idInquiry.mb",method=RequestMethod.POST)
	public ModelAndView idInquiry(
			@ModelAttribute("Member") @Valid Member member, 
			BindingResult bindingResult){
		System.out.println("이름:"+member.getName());
		System.out.println("전화번호:"+member.getHp());
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.email_test(member);
		if(mb==null){
			System.out.println("일치하는 이메일이 없습니다.");
			//mav.setViewName("");
		}else{
			System.out.println("찾은 이름:"+mb.getEmail());
			mav.addObject("mb", mb);
			mav.setViewName("TEST");
		}
		return mav;
	}
	
	//pw 찾기
	@RequestMapping(value="pwInquiry.mb",method=RequestMethod.POST)
	public ModelAndView pwInquiry(
			@ModelAttribute("Member") @Valid Member member, 
			BindingResult bindingResult){
		System.out.println("이메일:"+member.getEmail());
		System.out.println("이름:"+member.getName());
		System.out.println("전화번호:"+member.getHp());
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.pw_test(member);
		if(mb==null){
			System.out.println("일치하는 이메일이 없습니다.");
			//mav.setViewName("");
		}else{
			System.out.println("찾은 비번:"+mb.getPw());
			mav.addObject("mb", mb);
			//mav.setViewName("test");
		}
		return mav;
	}
}
