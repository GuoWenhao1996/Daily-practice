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
	 * 按条件查询所有学生信息
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping("list.do")
	public String list(Goods good, Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		//处理乱码
		if(good.getGname() != null && !good.getGname().equals("")) {
			good.setGname(URLDecoder.decode(good.getGname(), "UTF-8"));
		}
		//在model中设置查询的条件，条件是商品名称，或者订单编号
		if(good.getGname() != null && !good.getGname().equals("")) {
			model.addAttribute("goodsnamequery", URLEncoder.encode(good.getGname(), "UTF-8"));
		}
		if(good.getGnumber() != null) {
			model.addAttribute("goodsnumberquery", good.getGnumber());
			}
		//初始化分页信息
		this.initPage(request);
		good.setStart(getStart());; //设置起始记录数
		//按条件查询所有满足条件的商品记录
		//按条件查询商品记录总数
		Long total = goodsService.getCount(good);
		
		System.out.println();
		System.out.println("进入controller，total="+total);
		model.addAttribute("total", total);//名字不能改，页面上是total
		//查出需要的商品数据
		List<Goods> goods = goodsService.getGoodsList(good);
		//向model中保存数据
		model.addAttribute("goods", goods);
		//查询出管理员
//		Admin admin = new Admin();
//		admin.getAccount();
//		model.addAttribute("admin",admin);
		  return "frontend/product";
	}	
	
}