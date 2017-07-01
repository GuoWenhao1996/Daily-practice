package com.team3.service;

import java.util.List;

import com.team3.po.Order;

/**
 * 2017-6-30 19:58:56<br>
 * 订单业务接口
 * 
 * @author 郭文浩
 * @version 1.0
 */
public interface OrderService {
	/**
	 * 根据订单条件查询所有订单
	 * 
	 * @param order
	 * @return
	 */
	public List<Order> getOrderList(Order order);

	/**
	 * 添加订单
	 * @param order
	 */
	public void addOrder(Order order);

	/**
	 * 获取订单数量
	 * @param student
	 * @return 订单数
	 */
	public Long getCount(Order order);

}
