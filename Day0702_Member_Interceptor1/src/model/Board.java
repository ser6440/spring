package model;

import java.util.Date;

public class Board {
	private int num;
	private String title;
	private String name;
	private String pass;
	private String email;
	private String content;
	private int resdCount;
	private Date writeDate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getResdCount() {
		return resdCount;
	}
	public void setResdCount(int resdCount) {
		this.resdCount = resdCount;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", name=" + name + ", pass=" + pass + ", email=" + email
				+ ", content=" + content + ", resdCount=" + resdCount + ", writeDate=" + writeDate + "]";
	}
	
	
}
