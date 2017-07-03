package com.team3.dao;

import java.util.List;

import com.team3.po.Order;

/**
 * 2017-6-30 19:14:27<br>
 * 数据库订单表接口
 * 
 * @author 郭文浩
 * @version 1.0
 */
public interface OrderDao {
	/**
	 * 根据订单条件查询所有订单
	 * 
	 * @param order
	 * @return
	 */
	public List<Order> getOrderList(Order order);

	/**
	 * 添加订单
	 * 
	 * @param order
	 */
	public void addOrder(Order order);
	
	/**
	 * 按指定条件查询订单总数
	 * @param order
	 * @return 订单数量
	 */
	public Long getCount(Order order);
	
	/**
	 * 修改订单状态
	 * 
	 * @param order
	 */
	public void updateOrderStatus(Order order);
		

}
