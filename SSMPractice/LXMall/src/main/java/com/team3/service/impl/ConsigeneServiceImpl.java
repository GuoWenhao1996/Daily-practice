package com.team3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.ConsigeneeDao;
import com.team3.po.Consigenee;
import com.team3.service.ConsigeneeService;
/**
 * 收获地址业务接口的实现类
 * @author 莫天金
 *
 */
@Service
public class ConsigeneServiceImpl implements ConsigeneeService{

	@Autowired
	private ConsigeneeDao consigeneeDao;
	
	/**
	 * 添加新的收获地址
	 */
	public void addConsigenee(Consigenee consigenee) {
		consigeneeDao.addConsigenee(consigenee);
	}
	
	/**
	 * 根据用户id得到收获地址
	 */
	public List<Consigenee> getConsigeneeList(String userId) {
		List<Consigenee> consigenees = consigeneeDao.getConsigeneeList(userId);
		return consigenees;
	}

	/**
	 * 根据收获的id删除对应收获地址
	 */
	public void deleteConsigenee(Consigenee consigenee) {
		consigeneeDao.deleteConsigenee(consigenee);
	}

	/**
	 * 根据收货地址的id查询到该收货地址信息
	 */
	public Consigenee getConsigeneeById(Consigenee consigenee) {
		consigeneeDao.getConsigeneeById(consigenee);
		return consigenee;
	}

}
