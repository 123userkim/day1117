package com.sist.vo;

import java.util.Date;


public class InputNameAndMonVO {

	private int eno;
	private String ename;
	private Date hirdate;
	private int sal;
	private String jumin;
	private String id;
	public InputNameAndMonVO(int eno, String ename, Date hirdate, int sal, String jumin, String id) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.hirdate = hirdate;
		this.sal = sal;
		this.jumin = jumin;
		this.id = id;
	}
	public InputNameAndMonVO() {
		super();
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHirdate() {
		return hirdate;
	}
	public void setHirdate(Date hirdate) {
		this.hirdate = hirdate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
