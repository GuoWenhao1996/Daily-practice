package com.team3.controller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.team3.po.Admin;
import com.team3.po.Goods;
import com.team3.po.Message;
import com.team3.po.Picture;
import com.team3.service.AdminService;
import com.team3.service.GoodsService;
import com.team3.service.PictureService;
import com.team3.service.gutil.BaseController;
import com.team3.util.ToolUtil;
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
		//根据商品的id找到图片的url
		for(Goods g : goods) {
			List<Picture> str_onegoods = pictureService.selectPictureByGoodsId(g.getGnumber());
			if(str_onegoods.size()!=0) {
				g.setUrl(str_onegoods.get(0).getPnumber());
			}
		}
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
		List<Picture> gpictures = pictureService.selectPictureByGoodsId(good.getGnumber());
		model.addAttribute("gpictures", gpictures);
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
			//根据商品的id找到图片的url
			for(Goods g : goods) {
				List<Picture> str_onegoods = pictureService.selectPictureByGoodsId(g.getGnumber());
				if(str_onegoods.size()!=0) {
					g.setUrl(str_onegoods.get(0).getPnumber());
				}
			}
			
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
			
			//根据商品的id找到图片的url
			for(Goods g : pgoods) {
				List<Picture> str_onegoods = pictureService.selectPictureByGoodsId(g.getGnumber());
				if(str_onegoods.size()!=0) {
					g.setUrl(str_onegoods.get(0).getPnumber());
				}
			}
			//返回到对应的页面
			return "backend/product_update";
		}

	/**
	 * 修改商品信息
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("update.do")
	 public String updateGoods(Goods good,Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		//添加图片
		String pic_url = request.getParameter("myurl");
		System.out.println("myurl："+pic_url);
		Picture picture = new Picture();
		picture.setPnumber(pic_url);
		Goods pgoods = new Goods();
		pgoods.setGnumber(good.getGnumber());
		picture.setGoods(pgoods);
		pictureService.addPicture(picture);
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
		goods.setGstatus("已下架");
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
		admin.setAccount(ToolUtil.getCookieaccount(request));
		goods.setAdmin(admin);
		//调用业务层方法添加商品
		goodsService.AddGoods(goods);
		//添加图片
		String pic_url = request.getParameter("myurl");
		Picture picture = new Picture();
		picture.setPnumber(pic_url);
		Goods pgoods = new Goods();
		pgoods.setGnumber(goods.getGnumber());
		picture.setGoods(pgoods);
		pictureService.addPicture(picture);
		
		return AdminList(new Goods(),model, request);//无条件查询
	}
	/**
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("validate.do")
	public @ResponseBody Message validate(Goods goods){
		boolean flag = goodsService.validate(goods);
		if(flag==true){
			//唯一
			Message message=new Message();
			message.setContent("编号可用");
			message.setDate(new Date());
			return message;
		}else{
			//不唯一，账号已存在
			Message message=new Message();
			message.setContent("编号不可用");
			message.setDate(new Date());
			return message;
		}
	}
	/**
	 * 根据商品id添加图片
	 * @file 上传的文件
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("uploadpicture.do")
	public @ResponseBody String addPicture(@RequestParam(required=false) MultipartFile myimgupload, HttpServletRequest request) throws IOException {
		String fileName = String.valueOf(new Date().getTime());
		fileName += new Random().nextLong();
		String url = "/backend/upload/"+fileName+".jpg"; //图片报讯的地址
		String httpurl = "http://127.0.0.1:8080/LXMall" + url;
		url = request.getServletContext().getRealPath(url);
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
	public @ResponseBody void addfile(@RequestParam(required=false) MultipartFile upload, HttpServletRequest request,HttpServletResponse response) throws IOException {
		String fileName = String.valueOf(new Date().getTime());
		fileName += new Random().nextLong();
		String url="/upload/"+fileName+".jpg";
		String httpurl="http://localhost:9000/LXMall_filer"+url;
		//向另一台服务器上的upload文件夹发送文件
		Client client= new Client();//创建一个客户端
		WebResource resourse=client.resource(httpurl);
		resourse.put(String.class,upload.getBytes());//以put方式向后面的httpurlfasongfile
		//响应
		PrintWriter out = response.getWriter();
		//获取路径
		String callback = request.getParameter("CKEditorFuncNum");
		out.print("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+httpurl+"') </script>");
	}
	/**
	 * 加载首页
	 * @param good
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("index.do")
	public String indexList(Goods good, Model model) throws UnsupportedEncodingException {
		//查出需要的商品数据
		List<Goods> goods = goodsService.getGoodsList(good);
		//向model中保存数据
		model.addAttribute("goods", goods);
		//按分类查询出商品
		Goods sgoods = new Goods();
		//新鲜水果的
		sgoods.setGsort("%新鲜水果%");
		List<Goods> goodstype1 = goodsService.getGoodsList(sgoods);
		//向model中保存数据
		model.addAttribute("goodstype1", goodstype1);
		//根据商品的id找到图片的url
		for(Goods g : goodstype1) {
			List<Picture> str_onegoods = pictureService.selectPictureByGoodsId(g.getGnumber());
			if(str_onegoods.size()!=0) {
				g.setUrl(str_onegoods.get(0).getPnumber());
			}
		}
		
		//休闲零食的
		sgoods.setGsort("%休闲零食%");
		List<Goods> goodstype2 = goodsService.getGoodsList(sgoods);
		//向model中保存数据
		model.addAttribute("goodstype2", goodstype2);
		//根据商品的id找到图片的url
		for(Goods g : goodstype2) {
			List<Picture> str_onegoods = pictureService.selectPictureByGoodsId(g.getGnumber());
			if(str_onegoods.size()!=0) {
				g.setUrl(str_onegoods.get(0).getPnumber());
			}
		}
				
		//乳品冲饮的
		sgoods.setGsort("%乳品冲饮%");
		List<Goods> goodstype3 = goodsService.getGoodsList(sgoods);
		//向model中保存数据
		model.addAttribute("goodstype3", goodstype3);
		//根据商品的id找到图片的url
		for(Goods g : goodstype3) {
			List<Picture> str_onegoods = pictureService.selectPictureByGoodsId(g.getGnumber());
			if(str_onegoods.size()!=0) {
				g.setUrl(str_onegoods.get(0).getPnumber());
			}
		}
		  return "frontend/index";
		}
}