package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.ConsigeneeDao;
import com.team3.dao.OrderDao;
import com.team3.po.Consigenee;
import com.team3.po.Order;
import com.team3.service.OrderService;
import com.team3.util.ThisSystemUtil;

/**
 * 2017-6-30 20:01:35<br>
 * 订单业务实现类
 * 
 * @author 郭文浩
 * @version 1.0
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ConsigeneeDao consigeneeDao;

	public List<Order> getOrderList(Order order) {
		// if (student.getName() != null && !student.getName().equals("")) {
		// student.setName("%" + student.getName() + "%");
		// }
		List<Order> orders = orderDao.getOrderList(order);
		for (Order o : orders) {
			
			Consigenee consigenee = consigeneeDao.getConsigeneeById(o.getConsigenee());
			consigenee.setAddress(consigenee.getAddress().substring(0, 6) + "...");
			o.setConsigenee(consigenee);
			
			o.setOrderStatus(ThisSystemUtil.orderStatus(o.getOrderStatus()));
			o.setOrderTime(o.getOrderTime().substring(0, 10));
		}
		return orders;
	}

	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}

	public Long getCount(Order order) {
		return orderDao.getCount(order);
	}

}
