package com.team3.po;

public class Picture  {
	//图片编号
	private String pnumber;
	//所属商品
	private Goods goods;

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
