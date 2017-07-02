package com.team3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team3.dao.UserDao;
import com.team3.po.User;
import com.team3.service.UserService;
/**
 * 用户业务接口的实现类
 * @author renzhonghao
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user){		
		userDao.addUser(user);		
	}

	public User getUser(User user) {
		return userDao.getUser(user);
	}
	
	public User updateUser(User user){
		return userDao.updateUser(user);
	}

	public void updatePassword(User user) {
		userDao.updatePassword(user);
		
	}



}
