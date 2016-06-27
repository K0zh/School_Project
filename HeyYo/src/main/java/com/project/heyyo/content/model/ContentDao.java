package com.project.heyyo.content.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myContentDao")
public class ContentDao {
	private final String namespace = "com.project.att.content.model.Content";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Content> getAllContent() {
		
		List<Content> lists = new ArrayList<Content>();
		lists = sqlSessionTemplate.selectList(namespace + ".GetAllContent");
		
		return lists; 
	}

	public Content getContentById(int id) {
		 Content content;
		 content = sqlSessionTemplate.selectOne(namespace + ".GetContentById", id);
		 return content;
		
	}

	public void insertNeedData(Content content) {
		String address = content.getAddress();
		String location = content.getLocation();
		
		//바뀐 날짜 형식과 위치 정보를 재설정
		content.setLocation(address);
		
		sqlSessionTemplate.insert(namespace + ".InsertNeedData", content);
			
	}
}

