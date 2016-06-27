package com.project.heyyo.content.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myContentDao")
public class ContentDao {
	private final String namespace = "com.project.heyyo.content.model.Content";

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

	public void insertTalentData(Content content) {

		//얻어온 좌표 가공
		String location = content.getLocation();
		location = location.replace("(", "").replace(")", "");
		
		//가공한 좌표 재설정
		content.setLocation(location);
		
		sqlSessionTemplate.insert(namespace + ".InsertTalentData", content);
	}

}

