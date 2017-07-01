package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Order;


/**
 * 2017-6-30 19:41:09<br>
 * 操作数据库订单表测试类
 * 
 * @author 郭文浩
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderDaoTest {

	@Autowired
	private OrderDao orderDao;

	/**
	 * 拿到所有的商品列表测试
	 */
	@Test
	public void testGetOrderList() {
		Order order = new Order();
		List<Order> orders = orderDao.getOrderList(order);
		for (Order o : orders) {
			System.out.println(o.getOrderId());
		}
	}
	
	/**
	 * 添加订单dao层测试
	 */
	@Test
	public void testAddOrder(){
		Order order = new Order();
		order.setOrderId("添加测试1");
		order.setOrderTime("2017-7-1 14:27:26");
		order.setOrderStatus("1");
		orderDao.addOrder(order);
		System.out.println("添加成功！");
	}
}
