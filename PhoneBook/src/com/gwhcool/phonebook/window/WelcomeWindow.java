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
			while (true) {
				System.out.println(">>>�������û�����");
				System.out.print("<<<");
				String username = sc.next();
				if (userService.isExist(username)) {
					System.out.println(">>>�û�����" + username + "���Ѵ��ڣ����������룡");
					continue;
				} else {
					System.out.println(">>>��ϲ�㣬�û�����" + username + "�����ã�");
					while (true) {
						System.out.println(">>>���������룺");
						System.out.print("<<<");
						String pwd1 = sc.next();
						System.out.println(">>>������ȷ�����룺");
						System.out.print("<<<");
						String pwd2 = sc.next();
						if (pwd1.equals(pwd2)) {
							if (userService.resister(username, pwd1)) {
								System.out.println(">>>ע��ɹ���");
							} else {
								System.out.println(">>>�ڴ�������ע��ʧ�ܣ�");
							}
							break;
						} else {
							System.out.println(">>>�������벻һ�£����������룡");
							continue;
						}
					}
					break;
				}
			}
			show(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println(">>>�����������������룡");
			show(sc);
		}
	}
}
