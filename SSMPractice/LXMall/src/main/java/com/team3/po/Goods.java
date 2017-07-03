package com.team3.po;

import com.team3.service.gutil.BaseBean;

/**
 * 实体类，对应数据库中t_goods表
 * @author 莫天金
 *
 */
public class Goods extends BaseBean {
	//商品编号
	private String gnumber;
	//商品名称
	private String gname;
	//商品库存量
	private int gstock;
	//商品销量
	private int gvolume;
	//商品详情
	private String gdetail;
	//商品价格
	private double gprice;
	//商品状态
	private String gstatus;
	//商品类别
	private String gsort;
	//暂存图片的url
	private String url;
	//管理员实体
	private Admin admin;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGnumber() {
		return gnumber;
	}
	public void setGnumber(String gnumber) {
		this.gnumber = gnumber;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGstock() {
		return gstock;
	}
	public void setGstock(int gstock) {
		this.gstock = gstock;
	}
	public int getGvolume() {
		return gvolume;
	}
	public void setGvolume(int gvolume) {
		this.gvolume = gvolume;
	}
	public String getGdetail() {
		return gdetail;
	}
	public void setGdetail(String gdetail) {
		this.gdetail = gdetail;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public String getGstatus() {
		return gstatus;
	}
	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}
	public String getGsort() {
		return gsort;
	}
	public void setGsort(String gsort) {
		this.gsort = gsort;
	}
}
