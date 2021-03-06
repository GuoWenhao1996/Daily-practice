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
	 * 根据商品id查询单个记录
	 * @param goodsId
	 * @return
	 */
    public List<Goods> getGoodsByid(Goods goods);
	
	/**
	 * 根据商品id查询单个记录，返回string 类型的
	 * @param goodsId
	 * @return
	 */
	public Goods getGoodsById(String goodId);
	
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
     * 添加商品信息
     * @param goods
     */
    public void AddGoods(Goods goods);
    /**
     * 判断商品编号是否重复
     * @param goods
     * @return
     */
    public boolean validate(Goods goods);
    /**
	 * 根据销售情况更改销售数量和库存量
	 * @param goods
	 */
	public void setgsockandgvolume(Goods goods);
}
