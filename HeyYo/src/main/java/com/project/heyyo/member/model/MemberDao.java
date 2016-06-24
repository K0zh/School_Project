package com.project.heyyo.member.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myMemberDao")
public class MemberDao {
	private final String namespace = "com.project.att.content.model.Member";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
}

