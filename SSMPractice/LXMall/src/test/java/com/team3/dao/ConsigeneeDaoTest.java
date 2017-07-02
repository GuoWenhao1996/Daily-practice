package com.team3.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.Consigenee;
import com.team3.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ConsigeneeDaoTest {
	
	@Autowired
	private ConsigeneeDao consigeneeDao;
	
	@Test
	public void testGetConsigeneeList() {
		List<Consigenee> consigenees = consigeneeDao.getConsigeneeList("u001");
		for(Consigenee c:consigenees) {
			System.out.println(c.getAddress());
		}
	}
	
	@Test
	public void testAddConsigenee() {
		User user=new User();
		user.setId("u001");
		Consigenee consigenee = new Consigenee();
		consigenee.setuser(user);
		consigenee.setCnumber("shr004");
		consigenee.setCname("收货人004");
		consigenee.setAddress("山西省");
		consigenee.setCtelephone("03492284556");
		consigeneeDao.addConsigenee(consigenee);
		System.out.println(consigenee);
	}
	@Test
	public void testDeleteConsigenee() {
		Consigenee consigenee = new Consigenee();
		consigenee.setCnumber("shr004");
		consigeneeDao.deleteConsigenee(consigenee);
	}
	
	@Test
	public void testGetConsigeneeById() {
		Consigenee consigenee = new Consigenee();
		consigenee.setCnumber("shr001");
		System.out.println(consigeneeDao.getConsigeneeById(consigenee).getCname());
		System.out.println(consigeneeDao.getConsigeneeById(consigenee).getAddress());
		System.out.println(consigeneeDao.getConsigeneeById(consigenee).getCtelephone());
	}
}
