package com.gwhcool.phonebook.service;

import com.gwhcool.phonebook.db.DBUtil;
import com.gwhcool.phonebook.entity.Friend;

/**
 * 通讯录联系人实现类
 * 
 * @author gwh
 * @version 1.0
 */
public class FriendServiceImpl implements FriendService {

	DBUtil db = DBUtil.getInstance();
	Friend[] friends = db.getFriends();

	@Override
	public void showAllFriends(String username) {
		System.out.println(">>>=====================================================");
		System.out.println(">  姓名\t\t电话号码\t\t\t地址");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				continue;
			}
			if (friends[i].getUsername().equals(username)) {
				System.out.println(">  " + friends[i].toString());
			}
		}
		System.out.println(">>>=====================================================");
	}

	/**
	 * 根据联系人姓名查找联系人
	 * 
	 * @param username
	 *            用户名
	 * @param name
	 *            联系人姓名
	 * @return 联系人下标，-1表示不存在
	 */
	public int findByName(String username, String name) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name) && friends[i].getUsername().equals(username)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void findFriendByName(String username, String name) {
		int index = findByName(username, name);
		findByIndex(index, name);
	}

	/**
	 * 根据下标输出联系人信息
	 * 
	 * @param index
	 *            下标
	 * @param str
	 *            预查找联系人姓名
	 */
	public void findByIndex(int index, String str) {
		if (index == -1) {
			System.out.println(">>>您要查找的【" + str + "】不存在！");
		} else {
			System.out.println(">>>姓        名：" + friends[index].getName());
			System.out.println(">>>电话号码：" + friends[index].getPhoneNumber());
			System.out.println(">>>地        址：" + friends[index].getAddress());
		}
	}

	/**
	 * 根据联系人电话号码查找联系人
	 * 
	 * @param username
	 *            用户名
	 * @param name
	 *            联系人姓名
	 * @return 联系人下标，-1表示不存在
	 */
	public int findByPhoneNumber(String username, String phoneNumber) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getPhoneNumber().equals(phoneNumber)
					&& friends[i].getUsername().equals(username)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void findFriendByPhoneNumber(String username, String phoneNumber) {
		int index = findByPhoneNumber(username, phoneNumber);
		findByIndex(index, phoneNumber);
	}

	@Override
	public void deleteFriendByName(String username, String name) {
		int index = findByName(username, name);
		if (index == -1) {
			System.out.println(">>>联系人【" + name + "】不存在！");
		} else {
			friends[index] = null;
			System.out.println(">>>联系人【" + name + "】删除成功！");
		}
	}

	@Override
	public void addFriend(Friend friend) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				System.out.println(">>>联系人【" + friend.getName() + "】添加成功！");
				return;
			}
		}
		System.out.println(">>>内存已满，联系人【" + friend.getName() + "】添加失败");
	}
}
