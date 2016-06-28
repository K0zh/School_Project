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

	public void insertRequestMatching(Matching matching) {
		sqlSessionTemplate.insert(namespace + ".InsertRequestMatching",
				matching);

	}

	public List<Matching> selectMatchingByNum(Map<String, Object> num) {
		List<Matching> lists = new ArrayList<Matching>();
		lists = sqlSessionTemplate.selectList(namespace + ".SelectMatchingByNum", num);
	
		return lists;

	}

	public void deleteRequest(int id) {
		
		sqlSessionTemplate.delete(namespace + ".DeleteRequest", id);
		
	}
	
}