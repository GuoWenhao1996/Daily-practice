package com.team3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.PictureDao;
import com.team3.po.Goods;
import com.team3.po.Picture;
import com.team3.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureDao pictureDao;
	
	public void addPicture(Picture picture) {
		pictureDao.addPicture(picture);
	}

	public void selectPictureByGoodsId(Goods goods) {
		pictureDao.selectPictureByGoodsId(goods);
	}
	
}
