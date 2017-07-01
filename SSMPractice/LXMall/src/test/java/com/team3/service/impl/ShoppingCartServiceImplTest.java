package com.team3.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.ShoppingCart;
import com.team3.service.ShoppingCartService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ShoppingCartServiceImplTest {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Test
	public void testGetShoppingCartGoods() {
		List<ShoppingCart> shoppingCarts =  shoppingCartService.getShoppingCartGoods("11");
		for(ShoppingCart s:shoppingCarts) {
			System.out.println(s.getGoods().getGname());
		}
	}
}
