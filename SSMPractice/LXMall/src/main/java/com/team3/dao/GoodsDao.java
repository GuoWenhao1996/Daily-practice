package com.team3.dao;

import java.util.List;

import com.team3.po.Goods;
/**
 * 商品的dao层
 * @author 刘宇内
 *
 */
public interface GoodsDao  {	
	/**
	 * 根据条件查询所有满足条件的商品信息 
	 * @param goods
	 * @return
	 */
	public List<Goods> getGoodsList(Goods goods);
	/**
	 * 根据条件查询所有满足条件的商品的数量
	 * @param goods
	 * @return
	 */
	public Long getCount(Goods goods);
	/**
	 * 根据商品id/类型查询
	 * @param goods
	 * @return
	 */
	public List<Goods> getGoodsByid(Goods goods);
	/**
	 * 根据商品id查询精确地商品记录 
	 * @param goods
	 * @return
	 */
	public Goods getGoodsById(String goodsId);
	/**
	 * 根据id修改商品信息
	 * @param goods
 	 */
	public void updateGoods(Goods goods);
	/**
	 * 根据商品的ID删除商品的记录
	 * @param goods
	 */
	public void deleteGoods(Goods goods);
	/**
	 * 添加商品信息
	 * @param goods
	 */
	public void AddGoods(Goods goods);
	  
}
