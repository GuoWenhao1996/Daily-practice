package com.team3.po;

import com.team3.service.gutil.BaseBean;

/**
 * 2017-7-2 09:54:16<br>
 * 已购商品实体类，对应数据库中t_PREgoods表
 * 
 * @author 郭文浩
 * @version 2.0
 *
 */
public class Pregoods extends BaseBean{
	// 购买数量
	private int buynumber;
	// 编号
	private String buyid;
	// 所属订单
	private Order order;
	// 商品
	private Goods goods;
	// 购买时单价
	private String buyprice;

	public int getBuynumber() {
		return buynumber;
	}

	public void setBuynumber(int buynumber) {
		this.buynumber = buynumber;
	}

	public String getBuyid() {
		return buyid;
	}

	public void setBuyid(String buyid) {
		this.buyid = buyid;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(String buyprice) {
		this.buyprice = buyprice;
	}
}
