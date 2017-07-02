package com.team3.service;

import java.util.List;

import com.team3.po.Order;
import com.team3.po.Pregoods;
/**
 * 2017-7-2 10:58:29<br>
 * 已购商品业务层
 * @author 郭文浩
 * @version 1.0
 *
 */
public interface PregoodsService {
	/**
	 * 获取某个订单的已购商品列表
	 * @param order
	 * @return
	 */
	public List<Pregoods> getPregoodsList(Order order);
	
	/**
	 * 添加已购商品单
	 * @param pregoods 
	 */
	public void addPregoods(Pregoods pregoods);
}
