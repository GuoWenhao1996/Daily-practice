package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Goods;
import com.team3.po.Picture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class PictureDaoTest {
	
	@Autowired
	private PictureDao pictureDao;
    
	@Test
	public void testaddPicture()
	{
		Picture picture=new Picture();
	    picture.setPnumber("111");
	    Goods good=new Goods();
	    good.setGnumber("6666");
	    picture.setGoods(good);
	    pictureDao.addPicture(picture);
	}
	
	@Test
	public void testselectPictureByGoodsId()
	{
		List<Picture> pictures=pictureDao.selectPictureByGoodsId("6666");
		for(Picture p:pictures)
		{
			System.out.println(""+p.getPnumber());
		}
	}
}
