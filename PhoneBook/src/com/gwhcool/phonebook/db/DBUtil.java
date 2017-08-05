package com.gwhcool.phonebook.db;

import com.gwhcool.phonebook.entity.Friend;
import com.gwhcool.phonebook.entity.User;

/**
 * 数据库工具类<br>
 * 利用数组模拟数据库<br>
 * 采用单例模式获取唯一的数据库对象<br>
 * 在创建数据库对象时初始化数据
 * 
 * @author gwh
 * @version 1.0
 */
public class DBUtil {

	private static String username = null;

	private User[] users = new User[20];
	private Friend[] friends = new Friend[200];

	private DBUtil() {
		users[0] = new User("郭文浩", "111");
		users[1] = new User("刘诗诗", "222");
		friends[0] = new Friend("张三", "13311111111", "重庆", "郭文浩");
		friends[1] = new Friend("陈奕迅", "18511111111", "香港", "刘诗诗");
		friends[2] = new Friend("李四", "13311112222", "重庆", "郭文浩");
		friends[3] = new Friend("郭德纲", "18511112222", "北京", "刘诗诗");
		friends[4] = new Friend("王五", "13311113333", "重庆", "郭文浩");
		friends[5] = new Friend("薛之谦", "18511113333", "上海", "刘诗诗");
		friends[6] = new Friend("赵六", "13311114444", "重庆", "郭文浩");
		friends[7] = new Friend("汪涵", "18511114444", "湖南", "刘诗诗");
		friends[8] = new Friend("周七", "13311115555", "重庆", "郭文浩");
		friends[9] = new Friend("钱枫", "18511115555", "上海", "刘诗诗");
		friends[10] = new Friend("吴八", "13311116666", "重庆", "郭文浩");
		friends[11] = new Friend("杨迪", "18511116666", "四川", "刘诗诗");
	}

	private static DBUtil db = new DBUtil();

	public static DBUtil getInstance() {
		return db;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public Friend[] getFriends() {
		return friends;
	}

	public void setFriends(Friend[] friends) {
		this.friends = friends;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		DBUtil.username = username;
	}

}
