package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Admin;
import com.team3.po.Goods;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestGoodsDao {

		@Autowired
		private GoodsDao goodsDao;
		@Autowired
		private AdminDao adminDao;
		
		/**
		 * 测试无条件获取商品列表记录方法
		 */
		@Test
		public void testGetGoodsList(){
			Goods good=new Goods();
			   List<Goods> goods =goodsDao.getGoodsList(good);
			    for(Goods s: goods){ 
			      System.out.println("商品名："+s.getGname()+" 价格："+s.getGprice()+" 商品类别： "+s.getGsort());  
			    }	 
		}
		
		@Test
		public  void testGetGoodsById(){
			Goods goods = goodsDao.getGoodsById("sp001");
		      System.out.println(goods.getGname());			
		}
		
		@Test
		public  void testGetGoodsByid(){
			Goods goods=new Goods();
		    goods.setGnumber("312");
		   List<Goods> good=goodsDao.getGoodsByid(goods);
		     for(Goods s:good)
		     {
		     System.out.println(s.getGprice());
		     
		     System.out.println(s.getGdetail()); 
		     System.out.println(s.getGsort()); 
		     System.out.println(s.getGstatus()); 
		     System.out.println(s.getGvolume());
		    // System.out.println(s.getAdmin().getAccount());
		     }			
		}
		/**
		 * 测试更新商品信息
		 */
		@Test
		public void testUpdategoods(){
			Goods goods=new Goods();   
		    goods.setGnumber("312");
		    goods.setGname("苹果");
		    goods.setGdetail("新鲜的水果");  
		    goods.setGstatus("已经上架");
		    goods.setGsort("进口");
		   goodsDao.updateGoods(goods);
		}
	
		/**
		 * 测试商品信息添加的方法
		 */
		@Test
		public void testAddGoods(){
			Goods goods=new Goods();
			  // Admin admin=new Admin();
			    goods.setGnumber("32");
			    goods.setGname("新疆水果");
			    goods.setGdetail("来自新疆的新产业");
			    goods.setGprice(100.8);
			    goods.setGstock(20000);
			    goods.setGstatus("待上架");
			    goods.setGvolume(0);
			    goods.setGsort("新产类型");
			   
			    goodsDao.AddGoods(goods);
		} 
		
		@Test
		public void testDeletegoods(){
			Goods goods=new Goods();
		    goods.setGnumber("332");
		    goodsDao.deleteGoods(goods);
		}
		
		@Test
		public void testGetCount(){
			Goods goods=new Goods();
			   //goods.setGname("新疆水果"); 
			   //goods.setGnumber("sp007");
			   goods.setGsort("1");    
			   System.out.println(goodsDao.getCount(goods));
		}
		
}