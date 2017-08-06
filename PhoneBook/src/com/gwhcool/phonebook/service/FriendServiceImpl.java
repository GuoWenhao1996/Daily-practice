package com.gwhcool.phonebook.service;

import java.util.Scanner;

import com.gwhcool.phonebook.db.DBUtil;
import com.gwhcool.phonebook.entity.Friend;

/**
 * ͨѶ¼��ϵ��ʵ����
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
		System.out.println(">  ����\t\t�绰����\t\t\t��ַ");
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

	@Override
	public void findFriendByName(String username, String name) {
		int index = findByName(username, name);
		findByIndex(index, name);
	}

	/**
	 * ������ϵ������������ϵ��
	 * 
	 * @param username
	 *            �û���
	 * @param name
	 *            ��ϵ������
	 * @return ��ϵ���±꣬-1��ʾ������
	 */
	public int findByName(String username, String name) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name) && friends[i].getUsername().equals(username)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * �����±������ϵ����Ϣ
	 * 
	 * @param index
	 *            �±�
	 * @param str
	 *            Ԥ������ϵ������
	 */
	public void findByIndex(int index, String str) {
		if (index == -1) {
			System.out.println(">>>��Ҫ���ҵġ�" + str + "�������ڣ�");
		} else {
			System.out.println(">>>��        ����" + friends[index].getName());
			System.out.println(">>>�绰���룺" + friends[index].getPhoneNumber());
			System.out.println(">>>��        ַ��" + friends[index].getAddress());
		}
	}

	@Override
	public void findFriendByPhoneNumber(String username, String phoneNumber) {
		int index = findByPhoneNumber(username, phoneNumber);
		findByIndex(index, phoneNumber);
	}

	/**
	 * ������ϵ�˵绰���������ϵ��
	 * 
	 * @param username
	 *            �û���
	 * @param name
	 *            ��ϵ������
	 * @return ��ϵ���±꣬-1��ʾ������
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
	public void deleteFriendByName(String username, String name) {
		int index = findByName(username, name);
		if (index == -1) {
			System.out.println(">>>��ϵ�ˡ�" + name + "�������ڣ�");
		} else {
			friends[index] = null;
			System.out.println(">>>��ϵ�ˡ�" + name + "��ɾ���ɹ���");
		}
	}

	@Override
	public void updateFriendByName(String username, String name) {
		int index = findByName(username, name);
		if (index == -1) {
			System.out.println(">>>��ϵ�ˡ�" + name + "�������ڣ�");
		} else {

			Friend friend = new Friend();
			while (true) {
				System.out.println(">>>ԭ������" + friends[index].getName());
				System.out.println(">>>�����޸�Ϊ�������룡");
				System.out.print("<<<");
				Scanner sc = new Scanner(System.in);
				friend.setName(sc.next());
				if (findByName(DBUtil.getUsername(), friend.getName()) == -1) {
					System.out.println(">>>ԭ�绰���룺" + friends[index].getPhoneNumber());
					System.out.println(">>>�绰�����޸�Ϊ�������룡");
					System.out.print("<<<");
					friend.setPhoneNumber(sc.next());
					System.out.println(">>>ԭ��ַ��" + friends[index].getAddress());
					System.out.println(">>>��ַ�޸�Ϊ�������룡");
					System.out.print("<<<");
					friend.setAddress(sc.next());
					friend.setUsername(DBUtil.getUsername());
					System.out.println(">>>��ϵ���޸ĳɹ���");
					System.out.println(">>>��        ����" + friends[index].getName() + "\t\t->\t" + friend.getName());
					System.out.println(
							">>>�绰���룺" + friends[index].getPhoneNumber() + "\t->\t" + friend.getPhoneNumber());
					System.out
							.println(">>>��        ַ��" + friends[index].getAddress() + "\t\t->\t" + friend.getAddress());
					friends[index] = friend;
					break;
				} else {
					System.out.println(">>>��ϵ�ˡ�" + friend.getName() + "���Ѵ��ڣ�");
				}
			}
		}
	}

	@Override
	public void addFriend(Friend friend) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				System.out.println(">>>��ϵ�ˡ�" + friend.getName() + "����ӳɹ���");
				return;
			}
		}
		System.out.println(">>>�ڴ���������ϵ�ˡ�" + friend.getName() + "�����ʧ��");
	}
}
