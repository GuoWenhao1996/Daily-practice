package com.team3.po;

import com.team3.service.gutil.BaseBean;

/**
 * 2017-6-30 11:51:09<br>
 * 实体类，对应数据库中t_order表
 * 
 * @author 莫天金、郭文浩
 * @version 2.0
 *
 */
public class Order extends BaseBean {
	// 订单编号
	private String orderId;
	// 购买用户账号
	private User user;
	// 收货人
	private Consigenee consigenee;
	// 创建时间
	private String orderTime;
	// 订单状态 0、待付款 1、配货中 2、已出货 3、已签收 4、待评价 5、已完成 9、已取消
	private String orderStatus;
	// 订单金额
	private String orderMoney;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Consigenee getConsigenee() {
		return consigenee;
	}

	public void setConsigenee(Consigenee consigenee) {
		this.consigenee = consigenee;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	
	
}
