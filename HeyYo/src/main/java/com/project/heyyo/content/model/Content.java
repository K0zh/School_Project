package com.project.heyyo.content.model;

import java.security.Timestamp;

public class Content {
	private int id; // ����� ���� ���̵�
	private int num; // �Խñ� ����
	private String subject; // �Խñ� ����
	private String talent; // �ʿ� �Ǵ� ��û ���
	private Timestamp c_date; // ���ۼ���
	private Timestamp s_day; // ��û��
	private String address; // �ּ�
	private String location; // ��ǥ
	private int personnel; // �ʿ��ο�
	private String gender; // ����
	private String content; // ���� ����
	private String closed; // ���� ����
	private String type; // �Խñ� ����

	public Content() {
		super();
	}

	public Content(int id, int num, String subject, String talent,
			Timestamp c_date, Timestamp s_day, String address, String location,
			int personnel, String gender, String content, String closed,
			String type) {
		super();
		this.id = id;
		this.num = num;
		this.subject = subject;
		this.talent = talent;
		this.c_date = c_date;
		this.s_day = s_day;
		this.address = address;
		this.location = location;
		this.personnel = personnel;
		this.gender = gender;
		this.content = content;
		this.closed = closed;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTalent() {
		return talent;
	}

	public void setTalent(String talent) {
		this.talent = talent;
	}

	public Timestamp getC_date() {
		return c_date;
	}

	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}

	public Timestamp getS_day() {
		return s_day;
	}

	public void setS_day(Timestamp s_day) {
		this.s_day = s_day;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
