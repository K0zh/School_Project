package com.project.heyyo.content.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myContentDao")
public class ContentDao {
	private final String namespace = "com.project.heyyo.content.model.Content";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Content> getAllContent(Map<String, String> map) {
		

		List<Content> lists = new ArrayList<Content>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetAllContent", map);

		return lists;
	}

	public Content getContentByNum(int num) {
		Content content;
		content = sqlSessionTemplate.selectOne(namespace + ".GetContentByNum",
				num);
		return content;
	}

	public void insertTalentData(Content content) {

		sqlSessionTemplate.insert(namespace + ".InsertTalentData", content);
	}

}
