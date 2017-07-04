package com.team3.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.po.Consigenee;
import com.team3.po.Goods;
import com.team3.po.Message;
import com.team3.po.Order;
import com.team3.po.Pregoods;
import com.team3.po.ShoppingCart;
import com.team3.po.User;
import com.team3.service.GoodsService;
import com.team3.service.OrderService;
import com.team3.service.PregoodsService;
import com.team3.service.ShoppingCartService;
import com.team3.service.gutil.BaseController;
import com.team3.util.ThisSystemUtil;
import com.team3.util.ToolUtil;
import com.team3.util.UuidUtil;

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

	@Autowired
	private PregoodsService pregoodsService; // 生成订单详情

	@Autowired
	private ShoppingCartService shoppingCartService; // 用于付钱后清空购物车
	
	@Autowired
	private GoodsService goodsService;

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
	public String oneuserlist(Order order, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		if (ToolUtil.getCookieno(request) == null) {
			return "frontend/login";
		} else {
			if (order.getOrderStatus() != null && !order.getOrderStatus().equals("")) {
				model.addAttribute("orderStatusquery", order.getOrderStatus());
			}
			// if (order.getOrderId() != null && !order.getOrderId().equals(""))
			// {
			// model.addAttribute("orderIdquery", order.getOrderId());
			// }
			// if (order.getUser() != null) {
			// model.addAttribute("useridquery", order.getUser().getId());
			// }

			this.initPage(request);
			order.setStart(getStart());
			order.setLength(10);

			User user = new User();
			user.setId(ToolUtil.getCookieno(request));
			order.setUser(user);

			List<Order> orders = orderService.getOrderList(order);
			model.addAttribute("orders", orders);

			Long total = orderService.getCount(order);
			model.addAttribute("total", total);

			return "frontend/user_orderlist";
		}
	}

	/**
	 * 添加订单，并生成订单和刷新商品信息
	 * 
	 * @param order
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("add.do")
	public String add(Order order, Model model, HttpServletRequest request) throws UnsupportedEncodingException {

		String str_orderId = UuidUtil.uuid(); // 后面订单详情有用

		order.setOrderId(str_orderId);
		User user = new User();
		user.setId(ToolUtil.getCookieno(request));
		order.setUser(user);

		Consigenee con = new Consigenee();
		con.setCnumber(str_consigeneenumber);
		order.setConsigenee(con);

		order.setOrderTime(ThisSystemUtil.getSystemTime());
		order.setOrderStatus("1");

		// 已购商品
		System.out.println("购买单号");
		System.out.println("订单编号：" + order.getOrderId());
		String[] gnumbers = request.getParameterValues("gnumber");
		String[] gprices = request.getParameterValues("gprice");
		String[] numbers = request.getParameterValues("number");
		for (int i = 0; i < gnumbers.length; i++) {
			System.out.println("商品编号：" + gnumbers[i]);
			System.out.println("购买单价：" + gprices[i]);
			System.out.println("购买数量：" + numbers[i]);
		}
		// 生成订单
		orderService.addOrder(order);
		// 生成订单详情
		Goods goods = new Goods();
		ShoppingCart shoppingCart = new ShoppingCart();
		for (int i = 0; i < gnumbers.length; i++) {
			Pregoods pregoods = new Pregoods();
			pregoods.setBuyid(UuidUtil.uuid()); // 编号
			order.setOrderId(str_orderId);
			pregoods.setOrder(order); // 订单号
			goods.setGnumber(gnumbers[i]); // 商品编号
			pregoods.setGoods(goods);
			pregoods.setBuyprice(gprices[i]); // 购买时价格
			pregoods.setBuynumber(Integer.parseInt(numbers[i]));
			pregoodsService.addPregoods(pregoods);
		}
		// 删除购物车
		shoppingCart.setUser(user);
		shoppingCartService.deleteAllShoppingCartGoods(shoppingCart);
		// 返回订单界面
		return oneuserlist(new Order(), model, request);
	}

	/**
	 * 仅拿来存个收货地址的编号
	 * 
	 * @param goods
	 */
	public static String str_consigeneenumber = null;

	@RequestMapping("csavenumber.do")
	public @ResponseBody String savaConsigeneeNumber(Consigenee consigenee) {
		str_consigeneenumber = consigenee.getCnumber();
		System.out.println("收货人编号：" + str_consigeneenumber);
		return null;
	}

	/**
	 * 用来验证提交时是否选择了收货地址
	 * 
	 * @return
	 */
	@RequestMapping("isselect.do")
	public @ResponseBody Message isSelectAddress(Goods goods, HttpServletRequest request) {
		String str_gnumber = goods.getGnumber();
		System.out.println(str_gnumber);
		if (str_consigeneenumber == null) { // 没选收货地址
			Message message = new Message();
			message.setDate(new Date());
			message.setContent("您还没有选择收获地址~");
			return message;
		} else {
			if (str_gnumber == null) {
				Message message = new Message();
				message.setDate(new Date());
				message.setContent("购物车还没有宝贝商品！");
				return message; // 购物车没商品
			} else {
				String[] gnumbers = request.getParameterValues("gnumber");
				String[] numbers = request.getParameterValues("number");
				for(int i=0;i<gnumbers.length;i++) {
					Goods g = goodsService.getGoodsById(gnumbers[i]);
					if(Integer.parseInt(numbers[i])>g.getGstock()) {
						Message message = new Message();
						message.setDate(new Date());
						message.setContent(g.getGname()+"库存不够！");
						return message;
					}
				}
				Message message = new Message();
				message.setDate(new Date());
				message.setContent(null);
				return message;
			}
		}
	}

	@RequestMapping("update.do")
	public String update(Order order, Model model, HttpServletRequest request) {
		orderService.updateOrderStatus(order);
		return list(order, model, request);
	}

	@RequestMapping("oneuserupdate.do")
	public String oneuserupdate(Order order, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		orderService.updateOrderStatus(order);
		return oneuserlist(order, model, request);
	}
}
