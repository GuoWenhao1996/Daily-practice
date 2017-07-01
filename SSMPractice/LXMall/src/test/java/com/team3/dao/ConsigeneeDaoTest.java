package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Consigenee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ConsigeneeDaoTest {
	
	@Autowired
	private ConsigeneeDao consigeneeDao;
	
	@Test
	public void testGetConsigeneeList() {
		List<Consigenee> consigenees = consigeneeDao.getConsigeneeList("11");
		for(Consigenee c:consigenees) {
			System.out.println(c.getAddress());
		}
	}
}
