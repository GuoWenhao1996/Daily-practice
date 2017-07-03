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
