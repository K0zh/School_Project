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
	public void deleteSendMessage(int msnum){
		sqlSessionTemplate.update(namespace+".DeleteSendMessage", msnum);
	}
	
	//���� ���� ����
	public void deleteReceiveMessage(int msnum){
		sqlSessionTemplate.update(namespace+".DeleteReceiveMessage", msnum);
	}
	
	//���� �б�
	public Message selectMessage(int msnum){
		Message message = sqlSessionTemplate.selectOne(namespace+".SelectMessage", msnum);
		return message;
	}
	
	public String selectMsContent(int msnum){
		String mscontent= sqlSessionTemplate.selectOne(namespace+".SelectMsContent", msnum);
		return mscontent;
	}
	public void readingMessage(int msnum){
		sqlSessionTemplate.update(namespace+".ReadingMessage",msnum);
	}
}