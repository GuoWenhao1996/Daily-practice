package com.team3.po;

/**
 * 实体类，对应数据库中t_user表
 * @author 莫天金
 */
public class User {
	//用户账号
	private String id;
	//用户密码
	private String password;
	//用户昵称
	private String nickname;
	//用户状态
	private String status;
	//用户性别
	private String sex;
	//邮箱地址
	private String mail;
	//电话号码
	private String utelephone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
}
