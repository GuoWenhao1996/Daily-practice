package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.GoodsDao;
import com.team3.dao.ShoppingCartDao;
import com.team3.po.Goods;
import com.team3.po.ShoppingCart;
import com.team3.service.ShoppingCartService;

/**
 * 购物车业务接口的实现类
 * @author 莫天金
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 向购物车添加商品
	 */
	public void addShoppingCartGoogs(ShoppingCart shoppingCart) {
		shoppingCartDao.addShoppingCartGoogs(shoppingCart);
	}
	
	/**
	 * 点击添加到购物车按钮
	 */
	public boolean isAddShoppingCartGoogs(String userId, Goods goods) {
		List<ShoppingCart> shoppingCarts = shoppingCartDao.getShoppingCartGoods(userId);
		//对应的商品id查询出商品
		for(ShoppingCart sc : shoppingCarts) {
			if(goods.getGnumber().equals(sc.getGoods().getGnumber())) {
				return false;  //说明存在购物车中，不可以添加
			}
		}
		return true;
	}
	
	/**
	 * 根据用户id查询出购物车的商品
	 */
	public List<ShoppingCart> getShoppingCartGoods(String userId) {
		List<ShoppingCart> shoppingCarts = shoppingCartDao.getShoppingCartGoods(userId);
		//对应的商品id查询出商品
		for(ShoppingCart sc : shoppingCarts) {
			String goodsid = sc.getGoods().getGnumber();
			Goods goods = goodsDao.getGoodsById(goodsid);
			sc.setGoods(goods);
		}
		return shoppingCarts;
	}

	/**
	 * 删除购物车商品
	 */
	public void deleteShoppingCartGoods(ShoppingCart shoppingCart) {
		shoppingCartDao.deleteShoppingCartGoods(shoppingCart);
	}

	public List<ShoppingCart> showUserGoods(String userId) {
		List<ShoppingCart> shoppingCarts = shoppingCartDao.getShoppingCartGoods(userId);
		//对应的商品id查询出商品
		for(ShoppingCart sc : shoppingCarts) {
			String goodsid = sc.getGoods().getGnumber();
			Goods goods = goodsDao.getGoodsById(goodsid);
			sc.setGoods(goods);
		}
		return shoppingCarts;
	}

	public void deleteAllShoppingCartGoods(ShoppingCart shoppingCart) {
		shoppingCartDao.deleteAllShoppingCartGoods(shoppingCart);
	}
	
}
