package com.team3.service.impl;

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
public class TestGoodsServiceimpl {
	@Autowired
	private GoodsServiceImpl goodsService;
	@Test
	public void testGoodsServiceimpl() {
		Goods goods = new Goods();
		goods.setGname("苹果");
		List<Goods> good= goodsService.getGoodsList(goods);
		for(Goods s:good){
			System.out.println("商品名："+s.getGname());
			System.out.println("商品详情:"+s.getGdetail());
			System.out.println("商品id"+s.getGnumber());
			System.out.println("goods.getGname="+goods.getGname());
			
		}
		System.out.println("goods.getGnumber="+goods.getGnumber());
	}
		@Test
		public void testdeletegoodsservice(){
			 Goods goods=new Goods();
			 goods.setGnumber("10");
			 goodsService.deleteGoods(goods);
			
		}
		@Test
		public void testupdateservice(){
			 Goods doo=new Goods();
			 doo.setGnumber("110");
			 doo.setGname("测试修改姓名");
			 doo.setGdetail("测试详情修改");
			 doo.setGprice(999);
			 doo.setGsort("测试类型修改");
			 goodsService.updateGoods(doo);
			
		}
		@Test
		public void testaddgoods(){
			Goods doo=new Goods();
			Admin admin =new Admin();
			 doo.setGnumber("000");
			 doo.setGname("测试修改姓名");
			 doo.setGdetail("测试详情修改");
			 doo.setGstatus("测试商品状态");
			 doo.setGprice(999);
			 doo.setGsort("测试类型修改");
			 doo.setGvolume(100);
			 doo.setGstock(6000);
			 admin.setAccount("1");
			 doo.setAdmin(admin);
			 goodsService.AddGoods(doo);
		}
}
