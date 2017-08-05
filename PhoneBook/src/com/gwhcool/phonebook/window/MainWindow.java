package com.gwhcool.phonebook.window;

import java.util.Scanner;

import com.gwhcool.phonebook.db.DBUtil;
import com.gwhcool.phonebook.entity.Friend;
import com.gwhcool.phonebook.service.FriendService;
import com.gwhcool.phonebook.service.FriendServiceImpl;

/**
 * 程序主窗口<br>
 * 用于显示程序主业务<br>
 * 界面功能:
 * <li>增加好友</li>
 * <li>删除好友</li>
 * <li>查询好友</li>
 * <li>展示所有好友</li>
 * <li>注销</li>
 * <li>退出系统</li>
 * 
 * @author gwh
 * @version 1.0
 */
public class MainWindow extends Window {
	private FriendService friendService = new FriendServiceImpl();

	@Override
	public void show(Scanner sc) {
		System.out.println("***************************");
		System.out.println("|      gds通讯录主菜单                        |");
		System.out.println("|                         |");
		System.out.println("| 1、增加好友                                                 |");
		System.out.println("| 2、按姓名查询好友                                     |");
		System.out.println("| 3、按手机号查询好友                                 |");
		System.out.println("| 4、展示所有好友                                         |");
		System.out.println("| 5、删除好友                                                 |");
		System.out.println("| 9、注销                                                         |");
		System.out.println("| 0、退出系统                                                 |");
		System.out.println("|                         |");
		System.out.println("|      版权所有   翻版必究                      |");
		System.out.println("***************************");
		System.out.println(">>>请输入序号操作：");
		System.out.print("<<<");
		String choose = sc.next();
		if ("1".equals(choose)) {
			Friend friend = new Friend();
			System.out.println(">>>请输入联系人姓名：");
			friend.setName(sc.next());
			System.out.println(">>>请输入联系人电话号码：");
			friend.setPhoneNumber(sc.next());
			System.out.println(">>>请输入联系人地址：");
			friend.setAddress(sc.next());
			friend.setUsername(DBUtil.getUsername());
			friendService.addFriend(friend);
			show(sc);
		} else if ("2".equals(choose)) {
			System.out.println(">>>请输入要查找的联系人的姓名：");
			String name = sc.next();
			friendService.findFriendByName(DBUtil.getUsername(), name);
			System.out.println(">>>返回主菜单请按回车键！");
			sc.nextLine();
			sc.nextLine();
			show(sc);
		} else if ("3".equals(choose)) {
			System.out.println(">>>请输入要查找的联系人的电话号码：");
			String phoneNumber = sc.next();
			friendService.findFriendByPhoneNumber(DBUtil.getUsername(), phoneNumber);
			System.out.println(">>>返回主菜单请按回车键！");
			sc.nextLine();
			sc.nextLine();
			show(sc);
		} else if ("4".equals(choose)) {
			friendService.showAllFriends(DBUtil.getUsername());
			System.out.println(">>>返回主菜单请按回车键！");
			sc.nextLine();
			sc.nextLine();
			show(sc);
		} else if ("5".equals(choose)) {
			System.out.println(">>>请输入要删除的联系人姓名：");
			String name = sc.next();
			friendService.deleteFriendByName(DBUtil.getUsername(), name);
			show(sc);
		} else if ("9".equals(choose)) {
			System.out.println(">>>注销成功！");
			WindowUtil.start(sc);
		} else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println(">>>输入有误，请重新输入！");
			show(sc);
		}
	}

}
