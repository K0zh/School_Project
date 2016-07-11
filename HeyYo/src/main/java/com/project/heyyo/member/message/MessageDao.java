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

	//���� ����
	public void sendingMessage(Message message) {
		sqlSessionTemplate.insert(namespace+".SendingMessage", message);
	}

	//������ �޼��� ����
	public int getCntNewMessage(int receiver){
		System.out.println(receiver);
		int cnt = sqlSessionTemplate.selectOne(namespace + ".GetCntNewMessage", receiver);
		System.out.println(cnt);
		return cnt;
	}
	
	//���� �޼��� ����Ʈ
	public List<Message> getReceiveMessage(int receiver) {
		List<Message> lists = new ArrayList<Message>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetReceiveMessage", receiver);

		return lists;
	}
	
	//���� �޼��� ����Ʈ

	public List<Message> getSendMessage(int sender) {
		List<Message> lists = new ArrayList<Message>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetSendMessage", sender);

		return lists;
	}
	
	//���� ���� ����
	public void deleteSendMessage(int ms_num){
		sqlSessionTemplate.update(namespace+".DeleteSendMessage", ms_num);
	}
	
	//���� ���� ����
	public void deleteReceiveMessage(int ms_num){
		sqlSessionTemplate.update(namespace+".DeleteReceiveMessage", ms_num);
	}
	
	//���� �б�
	public Message selectMessageByNum(int ms_num){
		System.out.println("test" + ms_num);
		Message message = new Message();
		message= sqlSessionTemplate.selectOne(namespace+".SelectMessageByNum", ms_num);
		System.out.println(message.getMs_content());
		System.out.println(message.getMs_date());
		System.out.println(message.getMs_num());
		System.out.println(message.getMs_state());
		System.out.println(message.getSender());
		System.out.println("��");
		return message;
	}
	public void readingMessage(int ms_num){
		sqlSessionTemplate.update(namespace+".ReadingMessage",ms_num);
	}
}