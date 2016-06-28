package com.project.heyyo.content.matching;

import java.security.Timestamp;

public class Matching {
	private int m_num;
	private int m_id;
	private Timestamp m_date;
	private String introduce;
	private String accept;

	public Matching() {
		super();
	}

	public Matching(int m_num, int m_id, Timestamp m_date, String introduce,
			String accept) {
		super();
		this.m_num = m_num;
		this.m_id = m_id;
		this.m_date = m_date;
		this.introduce = introduce;
		this.accept = accept;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public Timestamp getM_date() {
		return m_date;
	}

	public void setM_date(Timestamp m_date) {
		this.m_date = m_date;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

}
