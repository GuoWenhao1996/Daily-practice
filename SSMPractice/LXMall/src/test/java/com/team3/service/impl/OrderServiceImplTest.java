package com.team3.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Order;
import com.team3.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderServiceImplTest {

	@Autowired
	private OrderService orderService;

	@Test
	public void testGetOrderList() {
		Order order = new Order();
		List<Order> orders=orderService.getOrderList(order);
		for (Order o : orders) {
			System.out.println(o.getOrderId());
			System.out.println(o.getUser().getNickname());
			System.out.println(o.getConsigenee().getCname());
			System.out.println(o.getOrderTime());
			System.out.println(o.getOrderStatus());
			System.out.println();
		}
	}
	
	@Test
	public void testAddOrder() {
		Order order = new Order();
		order.setOrderId("添加测试2");
		order.setOrderTime("2017-7-1 14:40:39");
		order.setOrderStatus("1");
		orderService.addOrder(order);
		System.out.println("添加成功");
	}

}
