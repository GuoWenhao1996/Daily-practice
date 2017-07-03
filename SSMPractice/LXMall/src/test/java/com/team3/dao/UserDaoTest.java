package com.team3.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team3.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	
	@Test
    public void testaddUser()
    {
    	User user=new User();
    	user.setId("666");
    	user.setPassword("123");
    	user.setNickname("郭大爷");
    	user.setSex("男");
    	user.setMail("338895045@163.com");
    	user.setUtelephone("374638");
    	user.setStatus("未付款");
    	userDao.addUser(user);
    }
	
    @Test
	public void testgetUser()
	{
		User u=new User();
		u.setId("666");
		
		User user=userDao.getUser(u);
		System.out.println("编号是："+user.getId());
		System.out.println("姓名是："+user.getNickname());
		System.out.println("性别是："+user.getSex());
	}
	
	@Test
	public void testupdateUser()
	{
		User user=new User();
		user.setId("6");
		user.setNickname("笑笑");
		user.setPassword("456");
		user.setSex("女");
		userDao.updateUser(user);
	}
	
	@Test
	public void testupdatePassword()
	{
		User user=new User();
		user.setId("u001");
		user.setPassword("345");
		userDao.updatePassword(user);
	}
	

}
