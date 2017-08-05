package com.gwhcool.phonebook.entity;

/**
 * 朋友类<br>
 * 用于存放姓名、电话号码、地址、用户
 * 
 * @author gwh
 * @version 1.0
 */
public class Friend {
	private String name;// 姓名
	private String phoneNumber;// 电话号码
	private String address;// 地址
	private String username;// 用户名

	public Friend(String name, String phoneNumber, String address, String username) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.username = username;
	}

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return name + "\t\t" + phoneNumber + "\t\t" + address;
	}

}
