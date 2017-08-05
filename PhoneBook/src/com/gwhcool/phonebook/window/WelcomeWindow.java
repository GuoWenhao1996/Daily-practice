package com.gwhcool.phonebook.window;

import java.util.Scanner;

import com.gwhcool.phonebook.db.DBUtil;
import com.gwhcool.phonebook.service.UserService;
import com.gwhcool.phonebook.service.UserServiceImpl;

/**
 * ��ӭҳ����<br>
 * ���湦��:
 * <li>��¼</li>
 * <li>ע��</li>
 * <li>�˳�</li>
 * 
 * @author gwh
 * @version 1.0
 *
 */
public class WelcomeWindow extends Window {

	private UserService userService = new UserServiceImpl();

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|     ��ӭʹ��gdsͨѶ¼                       |");
		System.out.println("|                         |");
		System.out.println("| 1����¼                                                         |");
		System.out.println("| 2��ע��                                                         |");
		System.out.println("| 0���˳�                                                         |");
		System.out.println("|                         |");
		System.out.println("|      ��Ȩ����   ����ؾ�                      |");
		System.out.println("***************************");
		System.out.println(">>>��������Ų�����");
		System.out.print("<<<");
		String choose = sc.next();
		if ("1".equals(choose)) {
			int errorTime = 0;
			while (true) {
				System.out.println("\n>>>�������û�����");
				System.out.print("<<<");
				String username = sc.next();
				System.out.println(">>>���������룺");
				System.out.print("<<<");
				String password = sc.next();
				if (userService.login(username, password)) {
					DBUtil.setUsername(username);
					System.out.println(">>>��¼�ɹ���");
					Window window = new MainWindow();
					window.show(sc);
				} else {
					System.out.println(">>>�û����������������");
					errorTime++;
					if (errorTime > 2) {
						break;
					} else {
						System.out.println(">>>����������,������" + (3 - errorTime) + "�λ��ᣡ");
					}
				}
			}
			WindowUtil.byebye(sc);
		} else if ("2".equals(choose)) {
			System.out.println(">>>ע�Ṧ����δ���ţ�");
		} else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println(">>>�����������������룡");
			show(sc);
		}
	}
}
