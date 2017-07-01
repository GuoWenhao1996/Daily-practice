package com.team3.dao;

import java.util.List;

import com.team3.po.Goods;
/**
 * 商品的dao层
 * @author 刘宇内
 *
 */
public interface GoodsDao {
	
	/**
	 * 根据条件查询所有满足条件的商品信息 
	 * @param goods
	 * @return
	 */
	public List<Goods> getGoodsList(Goods goods);
	
	/**
	 * 根据条件查询所有商品的数量
	 * @param goods
	 * @return
	 */
	public Long getCount(Goods goods);
	/**
	 * 根据商品id查询记录
	 * @param goods
	 * @return
	 */
	public Goods getGoodsById(String goodsId);

}
