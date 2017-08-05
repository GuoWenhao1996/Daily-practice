package com.gwhcool.phonebook.window;

import java.util.Scanner;

import com.gwhcool.phonebook.db.DBUtil;
import com.gwhcool.phonebook.service.UserService;
import com.gwhcool.phonebook.service.UserServiceImpl;

/**
 * 欢迎页窗口<br>
 * 界面功能:
 * <li>登录</li>
 * <li>注册</li>
 * <li>退出</li>
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
		System.out.println("|     欢迎使用gds通讯录                       |");
		System.out.println("|                         |");
		System.out.println("| 1、登录                                                         |");
		System.out.println("| 2、注册                                                         |");
		System.out.println("| 0、退出                                                         |");
		System.out.println("|                         |");
		System.out.println("|      版权所有   翻版必究                      |");
		System.out.println("***************************");
		System.out.println(">>>请输入序号操作：");
		System.out.print("<<<");
		String choose = sc.next();
		if ("1".equals(choose)) {
			int errorTime = 0;
			while (true) {
				System.out.println("\n>>>请输入用户名：");
				System.out.print("<<<");
				String username = sc.next();
				System.out.println(">>>请输入密码：");
				System.out.print("<<<");
				String password = sc.next();
				if (userService.login(username, password)) {
					DBUtil.setUsername(username);
					System.out.println(">>>登录成功！");
					Window window = new MainWindow();
					window.show(sc);
				} else {
					System.out.println(">>>用户名或密码输入错误！");
					errorTime++;
					if (errorTime > 2) {
						break;
					} else {
						System.out.println(">>>请重新输入,您还有" + (3 - errorTime) + "次机会！");
					}
				}
			}
			WindowUtil.byebye(sc);
		} else if ("2".equals(choose)) {
			System.out.println(">>>注册功能暂未开放！");
		} else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println(">>>输入有误，请重新输入！");
			show(sc);
		}
	}
}
