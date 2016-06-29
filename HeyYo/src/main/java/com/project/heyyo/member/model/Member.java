package com.project.heyyo.member.model;

public class Member {
		//테이블 목록
		private int num;
		private String email;
		private String pw;
		private String name;
		private String gender;
		private int hp;
		private String address;
		private String talentDt;
		private String talentGet;
		private String image;
		private int M_like;
		private String R_date;
		private String hpopen;
		
		private String birthday;
		
		
			public Member() {
				super();
			}
			public Member(int num, String email, String pw, String name, String gender, int hp,
					String address, String talentDt, String talentGet, String image, int M_like, String R_date, String hpopen, String birthday){
				this.num=num;
				this.email=email;
				this.pw=pw;
				this.name=name;
				this.gender=gender;
				this.hp=hp;
				this.address=address;
				this.talentDt=talentDt;
				this.talentGet=talentGet;
				this.image=image;
				this.M_like=M_like;
				this.R_date=R_date;
				this.hpopen=hpopen;
				this.birthday=birthday;
			}
			
			
		
		public String getBirthday() {
				return birthday;
			}
			public void setBirthday(String birthday) {
				this.birthday = birthday;
			}
		public String getHpopen() {
				return hpopen;
			}
			public void setHpopen(String hpopen) {
				this.hpopen = hpopen;
			}
		
			
			
			
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
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
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
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
		public int getM_like() {
			return M_like;
		}
		public void setM_like(int m_like) {
			M_like = m_like;
		}
		public String getR_date() {
			return R_date;
		}
		public void setR_date(String r_date) {
			R_date = r_date;
		}
	

	
}
