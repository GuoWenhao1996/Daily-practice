package com.team3.controller;
/**
 * 商品的核心控制器
 * @author 刘宇内
 *
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.po.Goods;
import com.team3.service.GoodsService;
import com.team3.service.gutil.BaseController;
@Controller
@RequestMapping("/goods/")
public class GoodsController extends BaseController{
	/**
	 * 商品服务类的接口对象
	 */
	@Autowired   
	private  GoodsService goodsService;
	/**
	 * 根据条件条件查询所有学生信息
	 * @param good
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("list.do")
public String list(Goods good, Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		//处理乱码
		if(good.getGname() != null && !good.getGname().equals("")) {
			good.setGname(URLDecoder.decode(good.getGname(), "UTF-8"));
		}
		if(good.getGsort() != null && !good.getGsort().equals("")) {
			good.setGsort(URLDecoder.decode(good.getGsort(), "UTF-8"));
		}
		//整理模糊查询的数据
		if (good.getGname() != null && !good.getGname().equals("")) {
			good.setGname("%" + good.getGname() + "%");
		}	
		if (good.getGsort() != null && !good.getGsort().equals("")) {
			good.setGname("%" + good.getGsort() + "%");
		}
		//在model中设置查询的条件，条件是商品名称，或者订单编号
		if(good.getGname() != null && !good.getGname().equals("")) {
			model.addAttribute("goodsnamequery", URLEncoder.encode(good.getGname(), "UTF-8"));
		}
		if(good.getGsort() != null && !good.getGsort().equals("")) {
			model.addAttribute("goodstypequery", URLEncoder.encode(good.getGsort(), "UTF-8"));
		}
		System.out.println("goodscontroller list.do打印：type="+good.getGsort()+"name="+good.getGname()+"id="+good.getGnumber());
		//初始化分页信息
		this.initPage(request);
		good.setStart(getStart());; //设置起始记录数
		//按条件查询所有满足条件的商品记录
		//按条件查询商品记录总数
		Long total = goodsService.getCount(good);
		model.addAttribute("total", total);//名字不能改，页面上是total
		//查出需要的商品数据
		List<Goods> goods = goodsService.getGoodsList(good);
		System.out.println("list.do  good="+good);
		System.out.println("list.do  goods="+goods);
		//向model中保存数据
		model.addAttribute("goods", goods);
		  return "frontend/product";
	}	
@RequestMapping("idlist.do")
public String IdNmaelist(Goods good, Model model){
		
		//按条件查询所有满足条件的商品记录,查出需要的商品数据
		List<Goods> goods = goodsService.getGoodsByid(good);
		System.out.println("  dlist.do goods="+goods);
		//向model中保存数据
		model.addAttribute("goods", goods);
		System.out.println("goodscontroller idlist.do打印：id="+good.getGnumber());
		  return "frontend/single";
	}	

}