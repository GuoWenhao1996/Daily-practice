package com.gwhcool.phonebook.service;

import com.gwhcool.phonebook.db.DBUtil;
import com.gwhcool.phonebook.entity.User;

/**
 * 用户服务实现类
 * 
 * @author gwh
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

	@Override
	public boolean login(String name, String pwd) {
		DBUtil db = DBUtil.getInstance();
		User[] users = db.getUsers();
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null && users[i].getUsername().equals(name) && users[i].getPassword().equals(pwd)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean resister(String name, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
