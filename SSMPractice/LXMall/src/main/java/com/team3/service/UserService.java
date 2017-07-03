package com.team3.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.team3.po.User;

public interface UserService {
	
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 获取一定条件下的用户
	 * @param user
	 * @return
	 */
	public User getUser(User user);
	
	/**
	 * 更改特定用户的用户信息
	 * @param user
	 * @return
	 */
	public User updateUser(User user);
	
	/**
	 * 更改特定用户的密码
	 * @param user
	 */
	public void updatePassword(User user);

}
