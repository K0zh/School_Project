package com.project.heyyo.member.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.heyyo.member.message.Message;



@Component("myMessageDao")
public class MessageDao {
	private final String namespace = "com.project.heyyo.member.message.Message";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	//쪽지 쓰기
	public void sendingMessage(Message message) {
		sqlSessionTemplate.insert(namespace+".SendingMessage", message);
	}

	//안읽은 메세지 개수
	public int getCntNewMessage(int receiver){
		System.out.println(receiver);
		int cnt = sqlSessionTemplate.selectOne(namespace + ".GetCntNewMessage", receiver);
		System.out.println(cnt);
		return cnt;
	}
	
	//받은 메세지 리스트
	public List<Message> getReceiveMessage(int receiver) {
		List<Message> lists = new ArrayList<Message>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetReceiveMessage", receiver);

		return lists;
	}
	
	//보낸 메세지 리스트

	public List<Message> getSendMessage(Map<String, String> map) {
		List<Message> lists = new ArrayList<Message>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetSendMessage", map);

		return lists;
	}
}