package com.team3.service;

import java.util.List;

import com.team3.po.Picture;

/**
 * 图片信息的核心管理业务接口
 * @author 莫天金
 *
 */
public interface PictureService {
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
