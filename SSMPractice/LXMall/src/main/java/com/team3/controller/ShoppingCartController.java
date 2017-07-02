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
import com.team3.po.ShoppingCart;
import com.team3.po.User;
import com.team3.service.ConsigeneeService;
import com.team3.service.ShoppingCartService;
import com.team3.util.ToolUtil;
import com.team3.util.UuidUtil;

/**
 * 购物车管理的控制器
 * 
 * @author 莫天金
 *
 */
@Controller
@RequestMapping("/shoppingcart/")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private ConsigeneeService consigeneeService;

	/**
	 * 添加新的收获地址
	 * 
	 * @param consigenee
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("addconsigenee.do")
	public String addConsigenee(Consigenee consigenee, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		User user = new User();
		user.setId(ToolUtil.getCookieno(request));
		consigenee.setCnumber(UuidUtil.uuid());
		consigenee.setuser(user);
		consigenee.getuser().getId();
		consigeneeService.addConsigenee(consigenee);
		return getShoppingCartGoods(new Consigenee(), model, request);
	}

	/**
	 * 根据收货地址id删除收货地址
	 * 
	 * @param consigeneeId
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("deleteconsigenee.do")
	public String deleteConsigenee(Consigenee consigenee, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		consigeneeService.deleteConsigenee(consigenee);
		return getShoppingCartGoods(new Consigenee(), model, request);
	}

	/**
	 * 根据收货地址的id找到对应的信息
	 * 
	 * @param consigenee
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("getconsigenee.do")
	public String getConsigeneeById(Consigenee consigenee, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		consigeneeService.getConsigeneeById(consigenee);
		model.addAttribute("getconsigenee", consigenee);
		return getShoppingCartGoods(new Consigenee(), model, request);
	}

	/**
	 * 向购物车添加信息
	 * 
	 * @param shoppingCart
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("addshoppingcartgoods.do")
	public String addShoppingCartGoogs(ShoppingCart shoppingCart, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		shoppingCartService.addShoppingCartGoogs(shoppingCart);
		return getShoppingCartGoods(new Consigenee(), model, request);
	}

	/**
	 * 购物车是否存在该商品，存在就提示已加入，不然就加入
	 * 
	 * @param shoppingCart
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("isaddshoppingcartgoods.do")
	public @ResponseBody Message isAddShoppingCartGoogs(ShoppingCart shoppingCart, Goods goods,
			HttpServletRequest request) throws UnsupportedEncodingException {
		if (ToolUtil.getCookieno(request) == null) {
			Message message = new Message();
			message.setDate(new Date());
			message.setContent("请先登录！");
			return message;
		} else {
			boolean flag = shoppingCartService.isAddShoppingCartGoogs(ToolUtil.getCookieno(request), goods);
			if (flag) {
				User user = new User();
				user.setId(ToolUtil.getCookieno(request));
				shoppingCart.setUser(user);
				shoppingCart.setNumber(1);
				shoppingCart.setGoods(goods);
				shoppingCartService.addShoppingCartGoogs(shoppingCart);
				Message message = new Message();
				message.setDate(new Date());
				message.setContent("成功添加到购物车！");
				return message;
			} else {
				Message message = new Message();
				message.setDate(new Date());
				message.setContent("购物车已存在该商品！");
				return message;
			}
		}
	}

	/**
	 * 删除购物车信息
	 * 
	 * @param shoppingCart
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("deleteshoppingcartgoods.do")
	public String deleteShoppingCartGoods(ShoppingCart shoppingCart, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		User user = new User();
		user.setId(ToolUtil.getCookieno(request));
		shoppingCart.setUser(user);
		shoppingCartService.deleteShoppingCartGoods(shoppingCart);
		return getShoppingCartGoods(new Consigenee(), model, request);
	}

	/**
	 * 获得购物车信息,并跳转
	 * 
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("usercartlist.do")
	public String getShoppingCartGoods(Consigenee consigenee, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		if (ToolUtil.getCookieno(request) == null) {
			return "frontend/login";
		} else {
			// 购物车信息
			List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartGoods(ToolUtil.getCookieno(request));
			model.addAttribute("shoppingcartgoods", shoppingCarts);
			// 收获地址信息
			List<Consigenee> consigeneelist = consigeneeService.getConsigeneeList(ToolUtil.getCookieno(request));
			model.addAttribute("consigeneelist", consigeneelist);

			return "frontend/cart";
		}
	}

	/**
	 * 获得购物车信息,不跳转
	 * 
	 * @param model
	 * @return
	 */
	/*@RequestMapping("showusergoods.do")
	public @ResponseBody List<ShoppingCart> showUserGoods(User user) {
		// 购物车信息
		System.out.println(user.getId());
		List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartGoods("11");
		return shoppingCarts;
	}*/

}
