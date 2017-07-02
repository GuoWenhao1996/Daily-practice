package com.team3.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Goods;
import com.team3.po.Order;
import com.team3.po.Pregoods;
import com.team3.service.PregoodsService;
import com.team3.util.UuidUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PregoodsServiceImplTest {

	@Autowired
	private PregoodsService pregoodsService;

	@Test
	public void testGetPregoodsList() {
		Order order = new Order();
		order.setOrderId("dd003");
		List<Pregoods> pregoodses=pregoodsService.getPregoodsList(order);
		for (Pregoods p : pregoodses) {
			System.out.println(p.getBuyid());
			System.out.println(p.getOrder().getOrderId()+"  "+p.getOrder().getOrderTime()+" "+p.getOrder().getOrderMoney()+"  "+p.getOrder().getOrderStatus()+" "+p.getOrder().getConsigenee().getAddress());
			System.out.println(p.getGoods().getGnumber()+" "+p.getGoods().getGname()+" "+p.getGoods().getGprice());
			System.out.println(p.getBuynumber());
			System.out.println(p.getBuyprice());
			System.out.println();
		}
	}
	
	@Test
	public void testAddOrder() {
		Goods goods=new Goods();
		goods.setGnumber("sp001");
		
		Order order=new Order();
		order.setOrderId("dd001");
		
		Pregoods pregoods=new Pregoods();
		pregoods.setBuyid(UuidUtil.uuid());
		pregoods.setGoods(goods);
		pregoods.setOrder(order);
		pregoods.setBuynumber(888);
		pregoods.setBuyprice("88.88");
		
		pregoodsService.addPregoods(pregoods);
		System.out.println("添加成功");
	}
}
