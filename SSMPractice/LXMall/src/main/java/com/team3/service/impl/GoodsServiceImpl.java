package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 获取所有商品的信息
     */
	public List<Goods> getGoodsList(Goods goods) {
			if (goods.getGname() != null && !goods.getGname().equals("")) {
				goods.setGname("%" + goods.getGname() + "%");
			}
			List<Goods>  good =goodsDao.getGoodsList(goods);
//			 根据商品编号为每天一个商品goods添加图片
//			for (Goods g : goods) {
//				int id = g.getClazz().getId();
//				Goods clazz = clazzDao.getClazzById(id);
//				s.setClazz(clazz);
//			}
			return  good;
	}
	/**
     * 删除对应商品信息
     */
	public void deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		
	}
      /**
       * 根据查询出满足条件的商品信息
       */
	public Goods getGoods(Goods goods) {
		// TODO Auto-generated method stub
		return null;
	}
     /**
      * 更新商品信息 
      */
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		
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
		List<Goods>  good =goodsDao.getGoodsByid(goods);
		return good;
	}
	public Goods getGoodsById(String goodId) {
		// TODO Auto-generated method stub
		return null;
	}
}