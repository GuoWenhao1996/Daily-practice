package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Consigenee;
import com.team3.po.Order;
import com.team3.po.User;
import com.team3.util.ThisSystemUtil;
import com.team3.util.UuidUtil;

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
	public void testAddOrder() {
		User user = new User();
		user.setId("U001");
		Consigenee consigenee = new Consigenee();
		consigenee.setCnumber("shr001");
		for (int i = 0; i < 100; i++) {
			Order order = new Order();
			order.setOrderId(UuidUtil.uuid());
			order.setUser(user);
			order.setConsigenee(consigenee);
			order.setOrderTime(ThisSystemUtil.getSystemTime());
			order.setOrderStatus("1");
			order.setOrderMoney(i+"00");
			orderDao.addOrder(order);
			System.out.println(i + ":添加成功！");
		}
	}
	
	@Test
	public void testGetCount(){
		User user = new User();
		user.setId("U001");
		Order order = new Order();
		order.setUser(user);
		long l=orderDao.getCount(order);
		System.out.println(l);
	}
}
