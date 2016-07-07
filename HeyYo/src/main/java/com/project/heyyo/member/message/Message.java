package com.project.heyyo.member.message;

public class Message {
	private int ms_num;
	private int sender;
	private int receiver;
	private String ms_content;
	private String ms_date;
	private String ms_state;
	public Message() {
		super();
	}
	
	public Message(int ms_num, int sender, int receiver,
			String ms_content, String ms_date, String ms_state) {
		super();
		this.ms_num = ms_num;
		this.sender = sender;
		this.receiver = receiver;
		this.ms_content = ms_content;
		this.ms_date = ms_date;
		this.ms_state = ms_state;
	}

	public int getMs_num() {
		return ms_num;
	}
	public void setMs_num(int ms_num) {
		this.ms_num = ms_num;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public String getMs_date() {
		return ms_date;
	}
	public void setMs_date(String ms_date) {
		this.ms_date = ms_date;
	}
	public String getMs_state() {
		return ms_state;
	}
	public void setMs_state(String ms_state) {
		this.ms_state = ms_state;
	}

	public String getMs_content() {
		return ms_content;
	}

	public void setMs_content(String ms_content) {
		this.ms_content = ms_content;
	}
}
