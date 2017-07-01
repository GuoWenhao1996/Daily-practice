package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.ConsigeneeDao;
import com.team3.dao.OrderDao;
import com.team3.po.Consigenee;
import com.team3.po.Order;
import com.team3.service.OrderService;

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

			// 订单状态 0、待付款 1、配货中 2、已出货 3、已签收 4、待评价 5、已完成 9、已取消
			switch (Integer.parseInt(o.getOrderStatus())) {
			case 0:
				o.setOrderStatus("待付款");
				break;
			case 1:
				o.setOrderStatus("配货中");
				break;
			case 2:
				o.setOrderStatus("已出货");
				break;
			case 3:
				o.setOrderStatus("已签收");
				break;
			case 4:
				o.setOrderStatus("待评价");
				break;
			case 5:
				o.setOrderStatus("已完成");
				break;
			case 9:
				o.setOrderStatus("已取消");
				break;
			default:
				break;
			}
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
