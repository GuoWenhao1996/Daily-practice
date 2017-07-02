package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.ConsigeneeDao;
import com.team3.dao.GoodsDao;
import com.team3.dao.OrderDao;
import com.team3.dao.PregoodsDao;
import com.team3.po.Consigenee;
import com.team3.po.Goods;
import com.team3.po.Order;
import com.team3.po.Pregoods;
import com.team3.service.PregoodsService;
import com.team3.util.ThisSystemUtil;
/**
 * 2017-7-2 11:16:54<br>
 * 已购商品业务层实现类
 * @author 郭文浩
 * @version 1.0
 *
 */
@Service
public class PregoodsServiceImpl implements PregoodsService {

	@Autowired
	private PregoodsDao pregoodsDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private GoodsDao goodsDao;	
	@Autowired
	private ConsigeneeDao consigeneeDao;
	public List<Pregoods> getPregoodsList(Order order) {
		List<Pregoods> pregoodses=pregoodsDao.getPregoodsList(order);
		for(Pregoods p:pregoodses){
			Goods goods=goodsDao.getGoodsById(p.getGoods().getGnumber());
			p.setGoods(goods);
			
			List<Order> orders = orderDao.getOrderList(order);
			for (Order o : orders) {
				Consigenee consigenee = consigeneeDao.getConsigeneeById(o.getConsigenee());
				o.setConsigenee(consigenee);
				o.setOrderStatus(ThisSystemUtil.orderStatus(o.getOrderStatus()));
				o.setOrderTime(o.getOrderTime().substring(0, 19));
				p.setOrder(o);
			}
		}
		return pregoodses;
	}
	public void addPregoods(Pregoods pregoods) {
		pregoodsDao.addPregoods(pregoods);		
	}

}
