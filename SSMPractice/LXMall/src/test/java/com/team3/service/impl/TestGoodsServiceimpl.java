package com.team3.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Goods;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestGoodsServiceimpl {
	@Autowired
	private GoodsServiceImpl goodsService;
	@Test
	public void testAddStudent() {
		Goods goods = new Goods();
		goods.setGname("12");
		goodsService.getGoodsList(goods);
	}	
}
