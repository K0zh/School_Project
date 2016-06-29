package com.project.heyyo.member.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component("myMemberDao")
public class MemberDao {
	private final String namespace = "com.project.att.content.model.Member";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//�����̸��ϰ˻�
	public Member InquiryEmail(String email) {
		Member mb = null;
		System.out.println("����");
		mb= sqlSessionTemplate.selectOne(namespace+".InquiryEmail", email);
		System.out.println("�α�");
		return mb;
	}
	//ȸ������
	public int insert(Member member) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".M_insert", member);
		return cnt;
	}
	//�̸���ã��
	public Member email_test(Member member) {
		Member mb = null;
		mb= sqlSessionTemplate.selectOne(namespace+".email_test", member);
		return mb;
	}
	//�н�����ã��
	public Member pw_test(Member member) {
		Member mb = null;
		mb= sqlSessionTemplate.selectOne(namespace+".pw_test", member);
		return mb;
	
	}
}

