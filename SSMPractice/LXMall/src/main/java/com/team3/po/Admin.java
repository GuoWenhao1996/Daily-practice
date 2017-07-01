package com.team3.po;

/**
 * 实体类，对应数据库中t_admin表
 * @author 莫天金
 *
 */
public class Admin {
	//管理员账号
	private String account;
	//管理员密码
	private String apassword;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
}
