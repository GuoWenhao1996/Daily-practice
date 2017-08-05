package com.gwhcool.phonebook.db;

import com.gwhcool.phonebook.entity.Friend;
import com.gwhcool.phonebook.entity.User;

/**
 * ���ݿ⹤����<br>
 * ��������ģ�����ݿ�<br>
 * ���õ���ģʽ��ȡΨһ�����ݿ����<br>
 * �ڴ������ݿ����ʱ��ʼ������
 * 
 * @author gwh
 * @version 1.0
 */
public class DBUtil {

	private static String username = null;

	private User[] users = new User[20];
	private Friend[] friends = new Friend[200];

	private DBUtil() {
		users[0] = new User("���ĺ�", "111");
		users[1] = new User("��ʫʫ", "222");
		friends[0] = new Friend("����", "13311111111", "����", "���ĺ�");
		friends[1] = new Friend("����Ѹ", "18511111111", "���", "��ʫʫ");
		friends[2] = new Friend("����", "13311112222", "����", "���ĺ�");
		friends[3] = new Friend("���¸�", "18511112222", "����", "��ʫʫ");
		friends[4] = new Friend("����", "13311113333", "����", "���ĺ�");
		friends[5] = new Friend("Ѧ֮ǫ", "18511113333", "�Ϻ�", "��ʫʫ");
		friends[6] = new Friend("����", "13311114444", "����", "���ĺ�");
		friends[7] = new Friend("����", "18511114444", "����", "��ʫʫ");
		friends[8] = new Friend("����", "13311115555", "����", "���ĺ�");
		friends[9] = new Friend("Ǯ��", "18511115555", "�Ϻ�", "��ʫʫ");
		friends[10] = new Friend("���", "13311116666", "����", "���ĺ�");
		friends[11] = new Friend("���", "18511116666", "�Ĵ�", "��ʫʫ");
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
