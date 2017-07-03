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
		public void testGetStudentList(){
			Goods good=new Goods();
			good.setGsort("逼哥类型");
			List<Goods> goods =goodsDao.getGoodsList(good);
			 for(Goods s: goods){ 
				 System.out.println(s.getGname()); 
				 System.out.println(s.getGprice());
				 System.out.println(s.getAdmin().getAccount()); 
				 System.out.println(s.getGdetail()); 
				 System.out.println(s.getGsort()); 
				 System.out.println(s.getGstatus()); 
				 System.out.println(s.getGvolume()); 
			 }	 
		}
		/**
		 * 测试获取单个学生的信息,测试成功
		 */
		@Test
		public  void testgetGoodsById(){
			Goods goods=new Goods();
			goodsDao.getGoodsByid(goods);			
		}
		/**
		 * 测试更新学生信息
		 */
		@Test
		public void testupdateGoods(){
			Goods goods=new Goods();
			 goods.setGnumber("110");
			 goods.setGname("莫水果110");
			 goods.setGdetail("详情莫水果110");
			 goods.setGprice(110.5);
			 goods.setGstock(110);
			 goods.setGstatus("110");
			 goods.setGsort("110");
			 
			goodsDao.updateGoods(goods);
		}
		/**
		 * 根据商品的id删除商品的信息
		 */
		@Test
		public void Testdeletegoods(){
			 Goods goods=new Goods();
			 goods.setGnumber("1");
			 goodsDao.deleteGoods(goods);
			 
		}
		/**
		 * 测试商品信息添加的方法
		 */
		@Test
		public void testAddGoods(){
			Goods goods=new Goods();
			Admin admin=new Admin();
			 goods.setGnumber("655666");
			 goods.setGname("新疆水果");
			 goods.setGdetail("莫比比在新疆的产业");
			 goods.setGprice(100.8);
			 goods.setGstock(20000);
			 goods.setGstatus("待上架");
			 goods.setGsort("逼哥类型");
			 admin.setAccount("1");
			 goods.setAdmin(admin);
			 goodsDao.AddGoods(goods);
		} 
}