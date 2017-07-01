package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Goods;
import com.team3.po.ShoppingCart;
import com.team3.po.User;

/**
 * 对ShoppingCartDao进行单元测试
 * @author 莫天金
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ShoppingCartDaoTest {
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Test
	public void testAddShoppingCartGoogs() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setNumber(00);
	}
	
	/**
	 * 根据用户id查询到商品的测试
	 */
	@Test
	public void testGetShoppingCartGoods() {
		//ShoppingCart shoppingCart = new ShoppingCart();
		List<ShoppingCart> shoppingCarts =  shoppingCartDao.getShoppingCartGoods("11");
		for(ShoppingCart s:shoppingCarts) {
			System.out.println(s.getNumber());
		}
	}
}
