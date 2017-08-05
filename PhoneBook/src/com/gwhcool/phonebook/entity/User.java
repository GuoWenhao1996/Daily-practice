package com.gwhcool.phonebook.entity;

/**
 * 用户类<br>
 * 用于存放用户名、密码
 * 
 * @author gwh
 * @version 1.0
 */
public class User {
	private String username;// 用户名
	private String password;// 密码

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

}
