package com.project.heyyo.content.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myMatchingDao")
public class MatchingDao {

	private final String namespace = "com.project.heyyo.content.matching.Matching";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public MatchingDao() {
		System.out.println("mcDAo");
	}

	// 매칭 신청 하기
	public void insertRequestMatching(Matching matching) {
		sqlSessionTemplate.insert(namespace + ".InsertRequestMatching",
				matching);
	}
	
	// 매칭 신청 리스트
	public List<Matching> selectMatchingByNum(Map<String, Object> num) {
		List<Matching> lists = new ArrayList<Matching>();
		lists = sqlSessionTemplate.selectList(namespace + ".SelectMatchingByNum", num);
	
		return lists;

	}
	
	// 매칭 거절, 취소 
	public void deleteRequest(int id) {
		sqlSessionTemplate.delete(namespace + ".DeleteRequest", id);
	}
	
}