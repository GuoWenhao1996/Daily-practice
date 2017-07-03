package com.team3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.po.Order;
import com.team3.po.Picture;
import com.team3.po.Pregoods;
import com.team3.service.PictureService;
import com.team3.service.PregoodsService;
import com.team3.service.gutil.BaseController;

/**
 * 2017-7-2 11:49:14<br>
 * 已购商品单 控制器
 * 
 * @author 郭文浩
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/pregoods/")
public class PregoodsController extends BaseController {
	@Autowired
	private PregoodsService pregoodsService;
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("list.do")
	public String list(Order order, Model model, HttpServletRequest request) {
		// this.initPage(request);
		// pregoods.setStart(getStart());
		// pregoods.setLength(10);
		List<Pregoods> pregoodses = pregoodsService.getPregoodsList(order);
		if (pregoodses.size() != 0) {
			Order theOrder = pregoodses.get(0).getOrder();
			model.addAttribute("theOrder", theOrder);
			for(Pregoods p:pregoodses){
				List<Picture> pics=pictureService.selectPictureByGoodsId(p.getGoods().getGnumber());
				if(pics.size()==0){
					p.setBuyid("http://localhost:8080/LXMall/frontend/images/default.png");
				}else{
					p.setBuyid(pics.get(0).getPnumber());//将订单号拿来存储照片地址
				}
			}
		}else{
			Order theOrder = new Order();
			theOrder.setOrderId("这是一张空订单！");
			model.addAttribute("theOrder", theOrder);
		}
		model.addAttribute("pregoodses", pregoodses);
		// Long total = orderService.getCount(order);
		// model.addAttribute("total", total);
		return "backend/order_detail";
	}
	
	@RequestMapping("oneuserlist.do")
	public String oneuserlist(Order order, Model model, HttpServletRequest request) {
		List<Pregoods> pregoodses = pregoodsService.getPregoodsList(order);
		if (pregoodses.size() != 0) {
			Order theOrder = pregoodses.get(0).getOrder();
			model.addAttribute("theOrder", theOrder);
			for(Pregoods p:pregoodses){
				List<Picture> pics=pictureService.selectPictureByGoodsId(p.getGoods().getGnumber());
				if(pics.size()==0){
					p.setBuyid("http://localhost:8080/LXMall/frontend/images/default.png");
				}else{
					p.setBuyid(pics.get(0).getPnumber());//将订单号拿来存储照片地址
				}			}
		}else{
			Order theOrder = new Order();
			theOrder.setOrderId("这是一张空订单！");
			model.addAttribute("theOrder", theOrder);
		}
		model.addAttribute("pregoodses", pregoodses);
		return "frontend/user_orderdetail";
	}
	
}
