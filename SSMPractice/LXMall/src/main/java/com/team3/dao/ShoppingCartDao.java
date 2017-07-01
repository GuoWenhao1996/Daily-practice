package com.team3.dao;

import java.util.List;

import com.team3.po.ShoppingCart;

/**
 * 购物车数据信息访问接口
 * @author 莫天金
 *
 */
public interface ShoppingCartDao {
	
	/**
	 * 添加购物车商品
	 * @param shoppingCart
	 */
	public void addShoppingCartGoogs(ShoppingCart shoppingCart);
	
	/**
	 * 根据用户id查询出购物车所有商品
	 * @param shoppingCart
	 * @return
	 */
	public List<ShoppingCart> getShoppingCartGoods(String userId);
}
