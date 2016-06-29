package com.project.heyyo.member.model;

public class Member {
	// 테이블 목록
	private int id;
	private String email;
	private String pw;
	private String name;
	private String gender;
	private String hp;
	private String hpopen;
	private String birthday;
	private String address;
	private String talentDt;
	private String talentGet;
	private String image;
	private int grade;
	private int credibility;
	private String R_date;

	public Member() {
		super();
	}

	public Member(int id, String email, String pw, String name, String gender,
			String hp, String hpopen, String birthday, String address,
			String talentDt, String talentGet, String image, int grade,
			int credibility, String r_date) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.hp = hp;
		this.hpopen = hpopen;
		this.birthday = birthday;
		this.address = address;
		this.talentDt = talentDt;
		this.talentGet = talentGet;
		this.image = image;
		this.grade = grade;
		this.credibility = credibility;
		R_date = r_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getHpopen() {
		return hpopen;
	}

	public void setHpopen(String hpopen) {
		this.hpopen = hpopen;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTalentDt() {
		return talentDt;
	}

	public void setTalentDt(String talentDt) {
		this.talentDt = talentDt;
	}

	public String getTalentGet() {
		return talentGet;
	}

	public void setTalentGet(String talentGet) {
		this.talentGet = talentGet;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getCredibility() {
		return credibility;
	}

	public void setCredibility(int credibility) {
		this.credibility = credibility;
	}

	public String getR_date() {
		return R_date;
	}

	public void setR_date(String r_date) {
		R_date = r_date;
	}

}
