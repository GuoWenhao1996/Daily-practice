package com.team3.dao;

import com.team3.po.User;

/**
 * 用户信息的信息访问接口
 * @author renzhonghao
 *
 */
public interface UserDao {
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(User user);
	
	public User getUser(User user);

}
