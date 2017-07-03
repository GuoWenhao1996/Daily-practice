package com.team3.dao;

import java.util.List;

import com.team3.po.Picture;

/**
 *
 * 购物车数据信息访问接口
 * @author 莫天金
 *
 */
public interface PictureDao {
	
	/**
	 * 根据商品的id添加相应图片
	 * @param picture
	 */
	public void addPicture(Picture picture);
	
	/**
	 * 根据商品id找到相应的图片
	 * @param goods
	 */
	public List<Picture> selectPictureByGoodsId(String goodsId);
}
