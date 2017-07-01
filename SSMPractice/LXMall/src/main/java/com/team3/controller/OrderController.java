package com.team3.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.po.Order;
import com.team3.po.User;
import com.team3.service.OrderService;
import com.team3.service.gutil.BaseController;

/**
 * 2017-7-1 10:02:38<br>
 * 订单 控制器
 * 
 * @author 郭文浩
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/order/")
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("list.do")
	public String list(Order order, Model model, HttpServletRequest request) {

		if (order.getOrderStatus() != null && !order.getOrderStatus().equals("")) {
			model.addAttribute("orderStatusquery", order.getOrderStatus());
		}
		if (order.getOrderId() != null && !order.getOrderId().equals("")) {
			model.addAttribute("orderIdquery", order.getOrderId());
		}
		if (order.getUser() != null) {
			model.addAttribute("useridquery", order.getUser().getId());
		}

		this.initPage(request);
		order.setStart(getStart());
		order.setLength(10);
		
		List<Order> orders = orderService.getOrderList(order);
		model.addAttribute("orders", orders);

		Long total = orderService.getCount(order);
		model.addAttribute("total", total);

		return "backend/order_list";
	}

	@RequestMapping("oneuserlist.do")
	public String oneuserlist(Order order, Model model, HttpServletRequest request) {

		if (order.getOrderStatus() != null && !order.getOrderStatus().equals("")) {
			model.addAttribute("orderStatusquery", order.getOrderStatus());
		}
//		if (order.getOrderId() != null && !order.getOrderId().equals("")) {
//			model.addAttribute("orderIdquery", order.getOrderId());
//		}
//		if (order.getUser() != null) {
//			model.addAttribute("useridquery", order.getUser().getId());
//		}

		this.initPage(request);
		order.setStart(getStart());
		order.setLength(10);
		
		User user=new User();
		user.setId("u001");
		order.setUser(user);
		
		List<Order> orders = orderService.getOrderList(order);
		model.addAttribute("orders", orders);
		
		Long total = orderService.getCount(order);
		model.addAttribute("total", total);

		return "frontend/user_orderlist";
	}

	
	@RequestMapping("add.do")
	public String add(Order order, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		orderService.addOrder(order);
		return list(new Order(), model, request);
	}
}
