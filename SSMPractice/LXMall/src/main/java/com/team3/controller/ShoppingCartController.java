package com.team3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.po.Consigenee;
import com.team3.po.ShoppingCart;
import com.team3.po.User;
import com.team3.service.ConsigeneeService;
import com.team3.service.ShoppingCartService;
import com.team3.util.UuidUtil;

/**
 * 购物车管理的控制器
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
	 * @param consigenee
	 * @return
	 */
	@RequestMapping("addconsigenee.do")
	public String addConsigenee(Consigenee consigenee, Model model) {
		User user = new User();
		user.setId("11");
		consigenee.setCnumber(UuidUtil.uuid());
		consigenee.setuser(user);
		consigenee.getuser().getId();
		consigeneeService.addConsigenee(consigenee);
		return getShoppingCartGoods(new Consigenee(), model);
	}
	
	/**
	 * 根据收货地址id删除收货地址
	 * @param consigeneeId
	 */
	@RequestMapping("deleteconsigenee.do")
	public String deleteConsigenee(Consigenee consigenee, Model model) {
		System.out.println("11111111");
		consigeneeService.deleteConsigenee(consigenee);
		return getShoppingCartGoods(new Consigenee(), model);
	}
	
	/**
	 * 根据收货地址的id找到对应的信息
	 * @param consigenee
	 * @param model
	 * @return
	 */
	@RequestMapping("getconsigenee.do")
	public String getConsigeneeById(Consigenee consigenee, Model model) {
		consigeneeService.getConsigeneeById(consigenee);
		model.addAttribute("getconsigenee", consigenee);
		return getShoppingCartGoods(new Consigenee(), model);
	}
	
	/**
	 * 向购物车添加信息
	 * @param shoppingCart
	 * @param model
	 * @return
	 */
	@RequestMapping("addshoppingcartgoods.do")
	public String addShoppingCartGoogs(ShoppingCart shoppingCart, Model model) {
		shoppingCartService.addShoppingCartGoogs(shoppingCart);
		return getShoppingCartGoods(new Consigenee(), model);
	}
	
	/**
	 * 删除购物车信息
	 * @param shoppingCart
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteshoppingcartgoods.do")
	public String deleteShoppingCartGoods(ShoppingCart shoppingCart, Model model) {
		shoppingCartService.deleteShoppingCartGoods(shoppingCart);
		return getShoppingCartGoods(new Consigenee(), model);
	}
	
	/**
	 * 获得购物车信息
	 * @param model
	 * @return
	 */
	@RequestMapping("usercartlist.do")
	public String getShoppingCartGoods(Consigenee consigenee, Model model) {
		//购物车信息
		List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartGoods("11");
		model.addAttribute("shoppingcartgoods", shoppingCarts);
		//收获地址信息
		List<Consigenee> consigeneelist = consigeneeService.getConsigeneeList("11");
		model.addAttribute("consigeneelist", consigeneelist);
		
		return "frontend/cart";
	}
}
