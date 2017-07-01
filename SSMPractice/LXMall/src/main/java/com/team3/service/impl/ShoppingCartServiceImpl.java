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
	
}
