package com.gwhcool.phonebook.service;

import com.gwhcool.phonebook.entity.Friend;

/**
 * 通讯录联系人接口
 * 
 * @author gwh
 * @version 1.0
 */
public interface FriendService {
	/**
	 * 展示该用户的所有联系人
	 * 
	 * @param username
	 *            用户名
	 */
	abstract void showAllFriends(String username);

	/**
	 * 通过姓名查找联系人
	 * 
	 * @param username
	 *            用户名
	 * @param name
	 *            联系人姓名
	 */
	abstract void findFriendByName(String username, String name);

	/**
	 * 通过电话号码查找联系人
	 * 
	 * @param username
	 *            用户名
	 * @param phoneNumber
	 *            联系人电话号码
	 */
	abstract void findFriendByPhoneNumber(String username, String phoneNumber);

	/**
	 * 通过姓名删除联系人
	 * 
	 * @param username
	 *            用户名
	 * @param name
	 *            联系人姓名
	 */
	abstract void deleteFriendByName(String username, String name);

	/**
	 * 通过姓名修改联系人信息
	 * 
	 * @param username
	 *            用户名
	 * @param name
	 *            联系人姓名
	 */
	abstract void updateFriendByName(String username, String name);

	
	/**
	 * 添加联系人
	 * 
	 * @param friend
	 *            联系人对象
	 */
	abstract void addFriend(Friend friend);

}
