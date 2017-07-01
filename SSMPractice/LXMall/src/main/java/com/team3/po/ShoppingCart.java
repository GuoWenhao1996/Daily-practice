package com.team3.po;

/**
 * 实体类，对应数据库中t_shoopingcart表
 * @author 莫天金
 *
 */
public class ShoppingCart {
	//包含商品
	private Goods goods;
	//所属用户
	private User User;
	//数量
	private int number;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
