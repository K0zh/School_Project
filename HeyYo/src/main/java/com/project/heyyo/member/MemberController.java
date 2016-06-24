package com.project.heyyo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
