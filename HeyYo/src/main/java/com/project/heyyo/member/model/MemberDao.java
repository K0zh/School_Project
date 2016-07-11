package com.project.heyyo.member.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component("myMemberDao")
public class MemberDao {
	private final String namespace = "com.project.heyyo.member.model.Member";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public Member InquiryEmail(String email) {
		Member mb = null;
		System.out.println("µé¾î¿È");
		mb= sqlSessionTemplate.selectOne(namespace+".InquiryEmail", email);
		return mb;
	}

	public int insert(Member member) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".M_insert", member);
		return cnt;
	}
	
	public Member email_test(Member member) {
		Member mb = null;
		mb= sqlSessionTemplate.selectOne(namespace+".email_test", member);
		return mb;
	}
	
	public Member pw_test(Member member) {
		Member mb = null;
		mb= sqlSessionTemplate.selectOne(namespace+".pw_test", member);
		return mb;
	
	}
	public Member selectMemberById(int id) {
		Member mb = sqlSessionTemplate.selectOne(namespace + ".SelectMemberById", id);
		return mb;
	}
	
	public int selectMemberIdByEmail(String email){
		int id = sqlSessionTemplate.selectOne(namespace + ".SelectMemberIdByEmail", email);
		return id;
	}
	
	//Á¤º¸¼öÁ¤
		public void modifyMemberInfo(Member member){
			sqlSessionTemplate.update(namespace + ".UpdateMember", member);
		}
		//È¸¿øÅ»Åð
		public void deleteMember(int id){
			sqlSessionTemplate.delete(namespace+ ".DeleteMember", id);
		}
}