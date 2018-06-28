package model;

public class Student {
	private int s_Num;
	private String sname;
	private int sgrade;
	
	public int getS_Num() {
		return s_Num;
	}
	public void getS_Num(int snum) {
		this.s_Num = snum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSgrade() {
		return sgrade;
	}
	public void setSgrade(int sgrade) {
		this.sgrade = sgrade;
	}
	@Override
	public String toString() {
		return "Student [snum=" + s_Num + ", sname=" + sname + ", sgrade=" + sgrade + "]";
	}
}
