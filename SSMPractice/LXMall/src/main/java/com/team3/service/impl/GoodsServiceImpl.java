package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.AdminDao;
import com.team3.dao.GoodsDao;
import com.team3.po.Goods;
import com.team3.service.GoodsService;

/**
 * 商品业务接口实现类
 * @author 刘宇内
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	/**
	 * 商品dao的对象实体
	 */
	@Autowired
	private GoodsDao goodsDao;
	/**
	 * 管理员对象实体
	 */
	@Autowired
	private AdminDao adminDao;
    /**
     * 获取所有商品的信息
     */
	public List<Goods> getGoodsList(Goods goods) {
			if (goods.getGname() != null && !goods.getGname().equals(" ")) {
				goods.setGname("%" + goods.getGname() + "%");
			}
			if (goods.getGsort() != null && !goods.getGsort().equals(" ")) {
				goods.setGsort("%" + goods.getGsort() + "%");
			}
//			 根据商品编号为每天一个商品goods添加图片
//			for (Goods g : goods) {
//				int id = g.getClazz().getId();
//				Goods clazz = clazzDao.getClazzById(id);
//				s.setClazz(clazz);
//			}
			return  goodsDao.getGoodsList(goods);
	}
	
	/**
     * 根据id删除对应商品信息
     */
	public void deleteGoods(Goods goods) {
       goodsDao.deleteGoods(goods);	
	}
      /**
       * 根据查询出满足条件的商品信息
       */
	public Goods getGoods(Goods goods) {
		// TODO Auto-generated method stub
		return null;
	}
     /**
      * 更新修改商品信息 
      */
	public void updateGoods(Goods goods) {
		goodsDao.updateGoods(goods);
	}
      /**
       * 判断商品名是否唯一
       */
	public boolean validate(Goods goods) {
		// TODO Auto-generated method stub
		return false;
	}
/**
 * 获取所有商品记录的总条数
 */
	public Long getCount(Goods goods) {
		if (goods.getGname() != null && !goods.getGname().equals("")) {
			goods.setGname("%" + goods.getGname() + "%");
		}
		return goodsDao.getCount(goods);
	}
	/**
	 * 根据商品id查询商品的具体信息记录
	 */
	public List<Goods> getGoodsByid(Goods goods) {

		return goodsDao.getGoodsByid(goods);
	}
	
	public Goods getGoodsById(String goodsId) {
		return goodsDao.getGoodsById(goodsId);
	}
      /**
       * 添加商品信息
       */
	public void AddGoods(Goods goods) {
		goodsDao.AddGoods(goods);
	}
}