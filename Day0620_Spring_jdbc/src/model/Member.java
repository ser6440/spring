package model;

import java.util.Date;

public class Member {
//	num: number(10) 기본키 , 회원번호
//	id: varchar2(30) null허용X, 중복허용 X , 아이디
//	pw: varchar2(50) null허용X   비밀번호
//	name: varchar2(20) null허용X 이름
//	email: varchar2(30) null 허용X, 중복허용 X 이메일
//	regDate: date    기본값 sysdate    회원가입일
	private int num;
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date regDate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", regDate="
				+ regDate + "]";
	}
}
