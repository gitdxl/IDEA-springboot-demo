package com.jdrx.springboot.demo.beans.entity;

import org.springframework.stereotype.Component;

//@Component
public class UserPO {
	Integer user_id;
	String user_name;
	String user_sex;
	String user_phone;
	String user_pw;
	String user_type;

	public UserPO(Integer user_id, String user_name, String user_sex, String user_phone, String user_pw, String user_type) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_phone = user_phone;
		this.user_pw = user_pw;
		this.user_type = user_type;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "UserPO [user_id=" + user_id + ", user_name=" + user_name + ", user_sex=" + user_sex + ", user_phone="
				+ user_phone + ", user_pw=" + user_pw + ", user_type=" + user_type + "]";
	}
	
}
