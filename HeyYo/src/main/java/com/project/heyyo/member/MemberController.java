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
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.member.model.Member;
import com.project.heyyo.member.model.MemberDao;
//github.com/mee88nu/School_Project.git
import org.springframework.web.multipart.MultipartFile;

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

	
	@RequestMapping(value="write.mb",method=RequestMethod.POST)
	public ModelAndView insertSignUp(
			@ModelAttribute("Member") @Valid Member member,
			@RequestParam("profile_img") MultipartFile profile_img,
			BindingResult bindingResult) throws IllegalStateException, IOException {

		System.out.println("write.mb ����");
		System.out.println(member.getAddress());
		
		System.out.println(member.getBirthday());
		ModelAndView mav = new ModelAndView();
		System.out.println("���� �̸���:"+member.getEmail());
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
			System.out.println("�̸��� ��������:"+mb);
		}
		
		if(mb==null){
			System.out.println("�̸��� ���� ����");
			System.out.println("�̹���:"+member.getImage());
			int insert = -1; 
			insert = memberDao.insert(member);
			System.out.println("��� ����:"+insert);
			if(insert!=-1){
				mav.setViewName("");//����
			}else{
				mav.setViewName("SignUpForm");
			}
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
		
		ModelAndView mav = new ModelAndView();
		
		Member mb = memberDao.InquiryEmail(member.getEmail().trim());
		
		if(mb==null){
			mav.setViewName("redirect:main.do");
		}else{
			if(member.getEmail().trim().equals(mb.getEmail())&&
					member.getPw().trim().equals(mb.getPw())){
				
				session.setAttribute("loginfo", mb); 
				mav.setViewName("redirect:main.do");
				
			}else{
				mav.setViewName("redirect:main.do");
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
			//mav.setViewName("");
		}else{
			System.out.println("ã�� �̸�:"+mb.getEmail());
			mav.addObject("mb", mb);
			mav.setViewName("TEST");
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
			//mav.setViewName("");
		}else{
			System.out.println("ã�� ���:"+mb.getPw());
			mav.addObject("mb", mb);
			//mav.setViewName("test");
		}
		return mav;
	}
}
