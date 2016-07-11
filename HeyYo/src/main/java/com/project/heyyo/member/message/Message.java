package com.project.heyyo.member.message;

public class Message {
	private int msnum;
	private int sender;
	private int receiver;
	private String mscontent;
	private String msdate;
	private String msstate;
	private String mssenderdelete;
	private String msreceiverdelete;
	
	public Message() {
		super();
	}
	
	public Message(int msnum, int sender, int receiver, String mscontent,
			String msdate, String msstate, String mssenderdelete,
			String msreceiverdelete) {
		super();
		this.msnum = msnum;
		this.sender = sender;
		this.receiver = receiver;
		this.mscontent = mscontent;
		this.msdate = msdate;
		this.msstate = msstate;
		this.mssenderdelete = mssenderdelete;
		this.msreceiverdelete = msreceiverdelete;
	}

	public int getMsnum() {
		return msnum;
	}

	public void setMsnum(int msnum) {
		this.msnum = msnum;
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

	public String getMscontent() {
		return mscontent;
	}

	public void setMscontent(String mscontent) {
		this.mscontent = mscontent;
	}

	public String getMsdate() {
		return msdate;
	}

	public void setMsdate(String msdate) {
		this.msdate = msdate;
	}

	public String getMsstate() {
		return msstate;
	}

	public void setMsstate(String msstate) {
		this.msstate = msstate;
	}

	public String getMssender_delete() {
		return mssenderdelete;
	}

	public void setMssender_delete(String mssenderdelete) {
		this.mssenderdelete = mssenderdelete;
	}

	public String getMsreceiver_delete() {
		return msreceiverdelete;
	}

	public void setMsreceiver_delete(String msreceiverdelete) {
		this.msreceiverdelete = msreceiverdelete;
	}
	
}