package com.team3.po;
/**
 * 实体类，对应数据库中t_consigenee表，即收货人信息表
 * @author 莫天金
 *
 */
public class Consigenee {
	//收货人编号
	private String cnumber;
	//收货地址
	private String address;
	//收货人姓名
	private String cname;
	//收货人电话
	private String ctelephone;
	//所属用户
	private User user;
	
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtelephone() {
		return ctelephone;
	}
	public void setCtelephone(String ctelephone) {
		this.ctelephone = ctelephone;
	}
	public User getuser() {
		return user;
	}
	public void setuser(User user) {
		this.user = user;
	}
}
