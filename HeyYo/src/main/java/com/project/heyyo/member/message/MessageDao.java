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

	public List<Message> getSendMessage(int sender) {
		List<Message> lists = new ArrayList<Message>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetSendMessage", sender);

		return lists;
	}
	
	//보낸 쪽지 삭제
	public void deleteSendMessage(int ms_num){
		sqlSessionTemplate.update(namespace+".DeleteSendMessage", ms_num);
	}
	
	//받은 쪽지 삭제
	public void deleteReceiveMessage(int ms_num){
		sqlSessionTemplate.update(namespace+".DeleteReceiveMessage", ms_num);
	}
	
	//쪽지 읽기
	public Message selectMessageByNum(int ms_num){
		System.out.println("test" + ms_num);
		Message message = new Message();
		message= sqlSessionTemplate.selectOne(namespace+".SelectMessageByNum", ms_num);
		System.out.println(message.getMs_content());
		System.out.println(message.getMs_date());
		System.out.println(message.getMs_num());
		System.out.println(message.getMs_state());
		System.out.println(message.getSender());
		System.out.println("끝");
		return message;
	}
	public void readingMessage(int ms_num){
		sqlSessionTemplate.update(namespace+".ReadingMessage",ms_num);
	}
}