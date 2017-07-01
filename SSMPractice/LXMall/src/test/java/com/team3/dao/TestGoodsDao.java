package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Goods;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestGoodsDao {

		@Autowired
		private GoodsDao goodsDao;
		
		/**
		 * 测试无条件获取商品列表记录方法
		 */
		@Test
		public void testGetStudentList(){
			Goods good=new Goods();
//			good.setGname("");
			List<Goods> goods =goodsDao.getGoodsList(good);
			 for(Goods s: goods){ 
				 System.out.println(s.getGname()); 
				 System.out.println(s.getGprice());
				 System.out.println(s.getAdmin()); 
				 System.out.println(s.getGdetail()); 
				 System.out.println(s.getGsort()); 
				 System.out.println(s.getGstatus()); 
				 System.out.println(s.getGvolume()); 
				
			 }
			 }

}