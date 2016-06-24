package com.project.heyyo.content.model;

public class Content {
	private int id;
	private int num;
	private String subject;
	private String need;
	private String c_date;

	private String address;

	private String location;
	private int personnel;
	private String gender;
	private String content;

	public Content() {
		super();
	}

	public Content(int id, int num, String subject, String need, String c_date,
			String address, String location, int personnel, String gender,
			String content) {
		super();
		this.id = id;
		this.num = num;
		this.subject = subject;
		this.need = need;
		this.c_date = c_date;
		this.address = address;
		this.location = location;
		this.personnel = personnel;
		this.gender = gender;
		this.content = content;
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

	public String getNeed() {
		return need;
	}

	public void setNeed(String need) {
		this.need = need;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
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

}
