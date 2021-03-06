package com.StockApp.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String username;
	String password;
	String email;
	String mobile;
	Integer confirm;
	String forgottoken;
	
	
	public String getForgottoken() {
		return forgottoken;
	}
	public void setForgottoken(String forgottoken) {
		this.forgottoken = forgottoken;
	}
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String email, String mobile, Integer confirm) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.confirm = confirm;
		//this.forgottoken= forgottoken;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getConfirm() {
		return confirm;
	}
	public void setConfirm(Integer confirm) {
		this.confirm = confirm;
	}
	
	
}
