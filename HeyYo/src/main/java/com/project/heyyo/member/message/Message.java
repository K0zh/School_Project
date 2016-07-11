package com.project.heyyo.member.message;

public class Message {
	private int ms_num;
	private int sender;
	private int receiver;
	private String ms_content;
	private String ms_date;
	private String ms_state;
	private String ms_sender_delete;
	private String ms_receiver_delete;
	
	public Message() {
		super();
	}
	public Message(int ms_num, int sender, int receiver, String ms_content,
			String ms_date, String ms_state, String ms_sender_delete,
			String ms_receiver_delete) {
		super();
		this.ms_num = ms_num;
		this.sender = sender;
		this.receiver = receiver;
		this.ms_content = ms_content;
		this.ms_date = ms_date;
		this.ms_state = ms_state;
		this.ms_sender_delete = ms_sender_delete;
		this.ms_receiver_delete = ms_receiver_delete;
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
	public String getMs_content() {
		return ms_content;
	}
	public void setMs_content(String ms_content) {
		this.ms_content = ms_content;
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
	public String getMs_sender_delete() {
		return ms_sender_delete;
	}
	public void setMs_sender_delete(String ms_sender_delete) {
		this.ms_sender_delete = ms_sender_delete;
	}
	public String getMs_receiver_delete() {
		return ms_receiver_delete;
	}
	public void setMs_receiver_delete(String ms_receiver_delete) {
		this.ms_receiver_delete = ms_receiver_delete;
	}
	@Override
	public String toString() {
		return "Message [ms_num=" + ms_num + ", sender=" + sender
				+ ", receiver=" + receiver + ", ms_content=" + ms_content
				+ ", ms_date=" + ms_date + ", ms_state=" + ms_state
				+ ", ms_sender_delete=" + ms_sender_delete
				+ ", ms_receiver_delete=" + ms_receiver_delete + "]";
	}
	
}
