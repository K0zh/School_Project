package com.project.heyyo.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	
	//ȸ������ �κ�
	@RequestMapping(value="write.mb",method=RequestMethod.POST)
	public ModelAndView insertSignUp(
			@ModelAttribute("Member") @Valid Member member, 
			BindingResult bindingResult){
		
		System.out.println(member.getBirthday());
		ModelAndView mav = new ModelAndView();
		
		System.out.println("���� �̸���:"+member.getEmail());
		Member mb = memberDao.InquiryEmail(member.getEmail().trim());
		System.out.println("�̸��� ��������:"+mb);
		

		if(mb==null){
			System.out.println("�̸��� ���� ����");
			int insert = memberDao.insert(member);
			System.out.println("��� ����:"+insert);
			mav.setViewName("");
		}else{
			System.out.println("�̸��� ������");
			mav.setViewName("SignUpForm");
		}
		
		
		return mav;
	}
	
	//�α��� �κ�
	@RequestMapping(value="login.mb",method=RequestMethod.POST)
	public ModelAndView login(Member member,HttpSession session
			){
		System.out.println("�α��� �̸���:"+member.getEmail());
		System.out.println("�α��� ���:"+member.getPw());
		
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.InquiryEmail(member.getEmail().trim());
		System.out.println("�̸��� ��������:"+mb);
		
		if(mb==null){
			System.out.println("���̵� �����ϴ�.");
			mav.setViewName("SignUpForm");
		}else{
			if(member.getEmail().trim().equals(mb.getEmail())&&
					member.getPw().trim().equals(mb.getPw())){
				System.out.println("�̸��� ��� ����.");
				
				session.setAttribute("loginfo", mb); 
				mav.setViewName("main");
				
			}else{
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
				mav.setViewName("SignUpForm");
			}
		}
		
		
		return mav;
		
	}
	//id ã��
	@RequestMapping(value="idInquiry.mb",method=RequestMethod.POST)
	public ModelAndView idInquiry(
			@ModelAttribute("Member") @Valid Member member, 
			BindingResult bindingResult){
		System.out.println("�̸�:"+member.getName());
		System.out.println("��ȭ��ȣ:"+member.getHp());
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.email_test(member);
		if(mb==null){
			System.out.println("��ġ�ϴ� �̸����� �����ϴ�.");
			mav.setViewName("id_Test");
		}else{
			System.out.println("ã�� �̸�:"+mb.getEmail());
			mav.addObject("mb", mb);
			mav.setViewName("test");//�����ؾߵ�
		}
		return mav;
	}
	
	//pw ã��
	@RequestMapping(value="pwInquiry.mb",method=RequestMethod.POST)
	public ModelAndView pwInquiry(
			@ModelAttribute("Member") @Valid Member member, 
			BindingResult bindingResult){
		System.out.println("�̸���:"+member.getEmail());
		System.out.println("�̸�:"+member.getName());
		System.out.println("��ȭ��ȣ:"+member.getHp());
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.pw_test(member);
		if(mb==null){
			System.out.println("��ġ�ϴ� �̸����� �����ϴ�.");
			mav.setViewName("pw_Test");
		}else{
			System.out.println("ã�� ���:"+mb.getPw());
			mav.addObject("mb", mb);
			mav.setViewName("test");//�����ؾߵ�
		}
		return mav;
	}
}
