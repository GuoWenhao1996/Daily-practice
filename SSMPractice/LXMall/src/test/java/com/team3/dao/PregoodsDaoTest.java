package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Consigenee;
import com.team3.po.Goods;
import com.team3.po.Order;
import com.team3.po.Pregoods;
import com.team3.po.User;
import com.team3.util.ThisSystemUtil;
import com.team3.util.UuidUtil;

/**
 * 2017-7-2 10:13:53<br>
 * 操作数据库已购商品表测试类
 * 
 * @author 郭文浩
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PregoodsDaoTest {

	@Autowired
	private PregoodsDao pregoodsDao;

	/**
	 * 拿到所有的商品列表测试
	 */
	@Test
	public void testGetPregoodsList() {
		Order order = new Order();
		// order.setOrderId("dd001");
		// order.setOrderId("dd002");
		// order.setOrderId("dd003");
		List<Pregoods> pregoodses = pregoodsDao.getPregoodsList(order);
		for (Pregoods p : pregoodses) {
			System.out.println(p.getBuyid());
		}
	}

	/**
	 * 添加订单dao层测试
	 */
	@Test
	public void testAddPregoods() {
		Goods goods=new Goods();
		goods.setGnumber("sp001");
		
		Order order=new Order();
		order.setOrderId("dd001");
		
		Pregoods pregoods=new Pregoods();
		pregoods.setBuyid(UuidUtil.uuid());
		pregoods.setGoods(goods);
		pregoods.setOrder(order);
		pregoods.setBuynumber(999);
		pregoods.setBuyprice("99.99");

		pregoodsDao.addPregoods(pregoods);
		System.out.println("添加成功！");
	}
}
