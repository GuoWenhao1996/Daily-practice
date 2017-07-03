package com.team3.controller;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 商品的核心控制器
 * @author 刘宇内
 *
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team3.po.Admin;
import com.team3.po.Goods;
import com.team3.po.Picture;
import com.team3.service.AdminService;
import com.team3.service.GoodsService;
import com.team3.service.PictureService;
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
	 * 管理员信息获取实体对象
	 */
	@Autowired
	private AdminService adminService;
	
	//图片
	@Autowired
	private PictureService pictureService;
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
			good.setGsort("%" + good.getGsort() + "%");
		}
		//在model中设置查询的条件，条件是商品名称，或者订单编号
		if(good.getGname() != null && !good.getGname().equals("")) {
			model.addAttribute("goodsnamequery", URLEncoder.encode(good.getGname(), "UTF-8"));
		}
		if(good.getGsort() != null && !good.getGsort().equals("")) {
			model.addAttribute("goodstypequery", URLEncoder.encode(good.getGsort(), "UTF-8"));
		}
		//初始化分页信息
		this.initPage(request);
		good.setStart(getStart());; //设置起始记录数
		//按条件查询商品记录总数
        Long total = goodsService.getCount(good);
		model.addAttribute("total", total);//名字不能改，页面上是total
		//查出需要的商品数据
		List<Goods> goods = goodsService.getGoodsList(good);
		//向model中保存数据
		model.addAttribute("goods", goods);
		  return "frontend/product";
		}	
	 /**
	 * 根据商品id显示出单个商品的详细信息
	 * @param good
	 * @param model
	 * @return
	 */
	@RequestMapping("idlist.do")
	public String IdNmaelist(Goods good, Model model){
		//按条件查询所有满足条件的商品记录,查出需要的商品数据
		List<Goods> goods = goodsService.getGoodsByid(good);
		//向model中保存数据
		model.addAttribute("goods", goods);
		  return "frontend/single";
		}
	/**
 	* 管理员根据商品名或类型或id查询商品信息
 	* @param good
 	* @param model
 	* @param request
 	* @return
 	* @throws UnsupportedEncodingException
 	*/
	@RequestMapping("Adminlist.do")
	public String AdminList(Goods good, Model model,HttpServletRequest request)throws UnsupportedEncodingException{
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
				 good.setGsort("%" + good.getGsort() + "%");
			}
			//在model中设置查询的条件，条件是商品名称，或者订单编号
			if(good.getGname() != null && !good.getGname().equals("")) {
				model.addAttribute("goodsnamequery", URLEncoder.encode(good.getGname(), "UTF-8"));
				
			}
			if(good.getGsort() != null && !good.getGsort().equals("")) {
				model.addAttribute("goodstypequery", URLEncoder.encode(good.getGsort(), "UTF-8"));
			
			}
			if(good.getGnumber() != null ) {
				model.addAttribute("goodsnumberquery", URLEncoder.encode(good.getGnumber(), "UTF-8"));
			}
			//初始化分页信息
			this.initPage(request);
			good.setStart(getStart());; //设置起始记录数
			//按条件查询商品记录总数
			Long total = goodsService.getCount(good);
			model.addAttribute("total", total);//名字不能改，页面上是total
			//查出需要的商品数据
			List<Goods> goods = goodsService.getGoodsList(good);
			//向model中保存数据
			model.addAttribute("goods", goods);
			  return "backend/product_list";
			}
	/**
	* 加载预修改商品信息
	* @param good
	* @param model
	* @return
	*/
	@RequestMapping("loadupdate.do")
	public String loadupdate(Goods good,Model model){
		List<Goods> pgoods=goodsService.getGoodsByid(good);
			//封装数据进入model里面
			model.addAttribute("pgoods",pgoods);
			//返回到对应的页面
			return "backend/product_update";
		}

	/**
	 * 修改商品信息
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("update.do")
	 public String updateGoods(Goods good,Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		goodsService.updateGoods(good);
		return AdminList(new Goods(),model,request);
	}
	/**
	 * 根据id删除商品信息
	 * @param goods
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("delete.do")
	public String delete(Goods goods,Model model ,HttpServletRequest request) throws UnsupportedEncodingException{
		goodsService.deleteGoods(goods);
		return AdminList(new Goods(),model, request);
	}
	
	/**
	 * 添加商品信息
	 * @param goods
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("add.do")
  	public String addgoods(Goods goods,Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		goods.setGvolume(0);//新添加商品的时候默认的销量是0
		Admin admin=new Admin();
		admin.getAccount();
		goods.setAdmin(admin);
		//调用业务层方法添加商品
		goodsService.AddGoods(goods);
		//添加图片
		String pic_url = request.getParameter("myurl");
		System.out.println("myurl："+pic_url);
		Picture picture = new Picture();
		picture.setPnumber(pic_url);
		Goods pgoods = new Goods();
		pgoods.setGnumber(goods.getGnumber());
		picture.setGoods(pgoods);
		pictureService.addPicture(picture);

		return AdminList(new Goods(),model, request);//无条件查询
	}
	
	/**
	 * 根据商品id添加图片
	 * @file 上传的文件
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("uploadpicture.do")
	public @ResponseBody String addPicture(@RequestParam(required=false) MultipartFile myimgupload, HttpServletRequest request) throws IOException {
		System.out.println(myimgupload);
		String fileName = String.valueOf(new Date().getTime());
		fileName += new Random().nextLong();
		String url = "/backend/upload/"+fileName+".jpg"; //图片报讯的地址
		String httpurl = "http://127.0.0.1:8080/LXMall" + url;
		url = request.getServletContext().getRealPath(url);
		System.out.println(url);
		FileOutputStream fos = new FileOutputStream(url);
		fos.write(myimgupload.getBytes()); //图片存到硬盘上
		fos.close();
		return httpurl;
	}
	
	/**
	 * 处理ckeditor文件上传的方法
	 * @param myimgupload
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("uploadfile.do")
	public @ResponseBody String addfile(@RequestParam(required=false) MultipartFile upload, HttpServletRequest request) throws IOException {
		System.out.println("upload ="+upload);
		
		String fileName = String.valueOf(new Date().getTime());
		fileName += new Random().nextLong();
		String url = "/backend/upload/"+fileName+".jpg"; //图片报讯的地址
		String httpurl = "http://127.0.0.1:8080/LXMall" + url;
		url = request.getServletContext().getRealPath(url);
		System.out.println(url);
		FileOutputStream fos = new FileOutputStream(url);
		fos.write(upload.getBytes()); //图片存到硬盘上
		fos.close();
		return httpurl;
	}
}