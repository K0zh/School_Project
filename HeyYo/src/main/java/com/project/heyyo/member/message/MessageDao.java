package com.project.heyyo.member.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.heyyo.content.model.Content;



@Component("myMessageDao")
public class MessageDao {
	private final String namespace = "com.project.heyyo.member.message.Message";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//쪽지 쓰기
	public void sendingMessage(Message message) {
		sqlSessionTemplate.insert(namespace+".SendingMessage", message);
	}

	public List<Message> getAllMessage(Map<String, String> map) {
		

		List<Message> lists = new ArrayList<Message>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetAllMessage", map);

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