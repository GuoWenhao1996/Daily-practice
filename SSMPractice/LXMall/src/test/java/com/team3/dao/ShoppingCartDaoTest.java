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
	/**
	 * 测试添加购物车商品
	 */
	public void testAddShoppingCartGoods() {
		ShoppingCart shoppingCart = new ShoppingCart();
		User user=new User();
		user.setId("1");
		shoppingCart.setUser(user);
		Goods goods=new Goods();
		goods.setGnumber("1");
		shoppingCart.setGoods(goods);
		shoppingCart.setNumber(7);
		shoppingCartDao.addShoppingCartGoogs(shoppingCart);
	}
	
	/**
	 * 根据用户id查询到商品的测试
	 */
	@Test
	public void testGetShoppingCartGoods() {
		ShoppingCart shoppingCart=new ShoppingCart();
		User user=new User();
		user.setId("1");
		shoppingCart.setUser(user);
		List<ShoppingCart> shoppingCarts =  shoppingCartDao.getShoppingCartGoods("11");
		for(ShoppingCart s:shoppingCarts) {
			System.out.println(s.getNumber());
			
		}
	}
	/**
	 * 测试删除购物车商品
	 */
	public void testdeleteShoppingCartGoods(){
		ShoppingCart shoppingCart=new ShoppingCart();
		User user=new User();
		user.setId("1");
		shoppingCart.setUser(user);
		Goods goods=new Goods();
		goods.setGnumber("1");
		shoppingCart.setGoods(goods);
		shoppingCartDao.deleteShoppingCartGoods(shoppingCart);
	}
	
	/**
	 * 测试清空购物车
	 */
	public void testdeleteAllShoppingCartGoods(){
		ShoppingCart shoppingCart=new ShoppingCart();
		User user=new User();
		user.setId("1");
		shoppingCartDao.deleteAllShoppingCartGoods(shoppingCart);
	}
}
