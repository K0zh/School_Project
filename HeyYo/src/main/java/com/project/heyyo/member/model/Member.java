package com.project.heyyo.member.model;

public class Member {

	private int id;
	private String email;
	private String password;
	private String name;
	private String gender;
	private String hp;
	private String address;
	private String talentDt;
	private String talentGet;
	private String image;
	private int like;
	private String r_date;

	public Member() {
		super();
	}

	public Member(int id, String email, String password, String name,
			String gender, String hp, String address, String talentDt,
			String talentGet, String image, int like, String r_date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.hp = hp;
		this.address = address;
		this.talentDt = talentDt;
		this.talentGet = talentGet;
		this.image = image;
		this.like = like;
		this.r_date = r_date;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

}
