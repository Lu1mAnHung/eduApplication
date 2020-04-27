package com.edu.model;

public class User {

	private Integer id;

	private String u_loginid;

	private String u_no;

	private String u_name;

	private String u_password;

	private String u_birthday;

	private String u_email;

	private String u_phone;

	private Integer u_states;

	private Integer u_role_fk;

	private String class_fk;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getU_loginid() {
		return u_loginid;
	}

	public void setU_loginid(String u_loginid) {
		this.u_loginid = u_loginid;
	}

	public String getU_no() {
		return u_no;
	}

	public void setU_no(String u_no) {
		this.u_no = u_no;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_birthday() {
		return u_birthday;
	}

	public void setU_birthday(String u_birthday) {
		this.u_birthday = u_birthday;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public Integer getU_states() {
		return u_states;
	}

	public void setU_states(Integer u_states) {
		this.u_states = u_states;
	}

	public Integer getU_role_fk() {
		return u_role_fk;
	}

	public void setU_role_fk(Integer u_role_fk) {
		this.u_role_fk = u_role_fk;
	}

	public String getClass_fk() {
		return class_fk;
	}

	public void setClass_fk(String class_fk) {
		this.class_fk = class_fk;
	}

}


