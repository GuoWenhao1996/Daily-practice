package com.team3.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Consigenee;
import com.team3.service.ConsigeneeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ConsigeneeServiceImpl {
	@Autowired
	private ConsigeneeService consigeneeService;
	
	/**
	 * 测试根据用户的id获得起全部的收获地址
	 */
	@Test
	public void testGetConsigeneeList() {
		List<Consigenee> consigenees = consigeneeService.getConsigeneeList("11");
		for(Consigenee c:consigenees) {
			System.out.println(c.getAddress());
		}
	}
}
