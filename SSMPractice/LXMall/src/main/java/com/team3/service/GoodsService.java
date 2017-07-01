package com.team3.service;

import java.util.List;

import com.team3.po.Goods;

/**
 * 商品业务接口
 * @author 刘宇内
 *
 */
public interface GoodsService {
	 /**
	  * 查询所有的商品记录
	  * @param goods
	  * @return
	  */
	public List<Goods> getGoodsList(Goods goods);
	
	/**
	 * 删除商品信息
	 * @param goods
	 */
    public void deleteGoods( Goods goods);
    
    /**
     * 根据条件查询单个出商品总数信息，用于修改商品信息（价格，描述等内容）
     * @param goods
     * @return
     */
    public Goods getGoods(Goods goods);
   /**
    * 根据条件查询出所有商品的数量总数
    * @param goods
    * @return
    */
    public Long getCount(Goods goods);
    /**
     * 更新商品记录
     * @param goods
     */
    public void updateGoods( Goods goods);
    /**
     * 验证商品名唯一性的方法
     * @param goods
     * @return
     */
    public boolean validate(Goods goods);
	 
}
