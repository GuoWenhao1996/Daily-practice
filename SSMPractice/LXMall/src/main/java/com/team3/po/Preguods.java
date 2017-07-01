package com.team3.po;

/**
 * 实体类，对应数据库中t_PREgoods表
 * @author 莫天金
 *
 */
public class Preguods {
	//购买数量
	private int buynumber;
	//编号
	private String buyid;
	//所属订单
	private Order order;
	//商品
	private Goods goods;
	
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
}
