package com.gwhcool.phonebook.window;

import java.util.Scanner;

import com.gwhcool.phonebook.db.DBUtil;
import com.gwhcool.phonebook.entity.Friend;
import com.gwhcool.phonebook.service.FriendService;
import com.gwhcool.phonebook.service.FriendServiceImpl;

/**
 * ����������<br>
 * ������ʾ������ҵ��<br>
 * ���湦��:
 * <li>���Ӻ���</li>
 * <li>ɾ������</li>
 * <li>��ѯ����</li>
 * <li>չʾ���к���</li>
 * <li>ע��</li>
 * <li>�˳�ϵͳ</li>
 * 
 * @author gwh
 * @version 1.0
 */
public class MainWindow extends Window {
	private FriendService friendService = new FriendServiceImpl();

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|      gdsͨѶ¼���˵�                        |");
		System.out.println("|                         |");
		System.out.println("| 1�����Ӻ���                                                 |");
		System.out.println("| 2����������ѯ����                                     |");
		System.out.println("| 3�����ֻ��Ų�ѯ����                                 |");
		System.out.println("| 4��չʾ���к���                                         |");
		System.out.println("| 5��ɾ������                                                 |");
		System.out.println("| 9��ע��                                                         |");
		System.out.println("| 0���˳�ϵͳ                                                 |");
		System.out.println("|                         |");
		System.out.println("|      ��Ȩ����   ����ؾ�                      |");
		System.out.println("***************************");
		System.out.println(">>>��������Ų�����");
		System.out.print("<<<");
		String choose = sc.next();
		if ("1".equals(choose)) {
			Friend friend = new Friend();
			System.out.println(">>>��������ϵ��������");
			friend.setName(sc.next());
			System.out.println(">>>��������ϵ�˵绰���룺");
			friend.setPhoneNumber(sc.next());
			System.out.println(">>>��������ϵ�˵�ַ��");
			friend.setAddress(sc.next());
			friend.setUsername(DBUtil.getUsername());
			friendService.addFriend(friend);
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println(">>>������Ҫ���ҵ���ϵ�˵�������");
			String name = sc.next();
			friendService.findFriendByName(DBUtil.getUsername(), name);
			System.out.println(">>>�������˵��밴�س�����");
			sc.nextLine();
			sc.nextLine();
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println(">>>������Ҫ���ҵ���ϵ�˵ĵ绰���룺");
			String phoneNumber = sc.next();
			friendService.findFriendByPhoneNumber(DBUtil.getUsername(), phoneNumber);
			System.out.println(">>>�������˵��밴�س�����");
			sc.nextLine();
			sc.nextLine();
			show(sc);
		} else if ("4".equals(choose)) {
			friendService.showAllFriends(DBUtil.getUsername());
			System.out.println(">>>�������˵��밴�س�����");
			sc.nextLine();
			sc.nextLine();
			show(sc);
		} else if ("5".equals(choose)) {
			System.out.println(">>>������Ҫɾ������ϵ��������");
			String name = sc.next();
			friendService.deleteFriendByName(DBUtil.getUsername(), name);
			show(sc);
		} else if ("9".equals(choose)) {
			System.out.println(">>>ע���ɹ���");
			WindowUtil.start(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println(">>>�����������������룡");
			show(sc);
		}
	}

}
