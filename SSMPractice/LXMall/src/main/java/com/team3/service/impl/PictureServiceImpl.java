package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.PictureDao;
import com.team3.po.Picture;
import com.team3.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureDao pictureDao;
	
	public void addPicture(Picture picture) {
		pictureDao.addPicture(picture);
	}

	public List<Picture> selectPictureByGoodsId(String goodsId) {
		return pictureDao.selectPictureByGoodsId(goodsId);
	}

	public void deleteByGoodsId(String goodsId) {
		pictureDao.deleteByGoodsId(goodsId);
	}
	
}
