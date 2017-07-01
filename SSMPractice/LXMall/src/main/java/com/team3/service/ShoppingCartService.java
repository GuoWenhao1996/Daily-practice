package com.team3.service;

import java.util.List;

import com.team3.po.ShoppingCart;

/**
 * 购物车信息的核心管理业务接口
 * @author 莫天金
 *
 */
public interface ShoppingCartService {
	
	/**
	 * 向购物车添加商品
	 * @param shoppingCart
	 */
	public void addShoppingCartGoogs(ShoppingCart shoppingCart);
	
	/**
	 * 删除购物车商品
	 * @param shoppingCart
	 */
	public void deleteShoppingCartGoods(ShoppingCart shoppingCart);
	
	/**
	 * 根据用户的id查询出购物车中所有的商品
	 * @param shoppingCart
	 */
	public List<ShoppingCart> getShoppingCartGoods(String userId);
}
