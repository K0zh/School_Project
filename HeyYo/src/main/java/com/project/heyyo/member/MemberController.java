package com.project.heyyo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="user_detail.mb", method=RequestMethod.GET)
	public String viewUser(@RequestParam("id") int id) {
		
		System.out.println(id);
		return "test";
	}
}
