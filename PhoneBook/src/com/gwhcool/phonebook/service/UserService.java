package com.gwhcool.phonebook.service;

/**
 * 用户服务接口
 * 
 * @author gwh
 * @version 1.0
 */
public interface UserService {
	/**
	 * 登录
	 * 
	 * @param name
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return
	 */
	abstract boolean login(String name, String pwd);

	/**
	 * 注册
	 * 
	 * @param name
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return 是否注册成功
	 */
	abstract boolean resister(String name, String pwd);
}
