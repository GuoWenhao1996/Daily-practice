package com.gwhcool.phonebook.window;

import java.util.Scanner;

/**
 * 窗口工具类<br>
 * 定义窗口的一些公共操作
 * 
 * @author gwh
 * @version 1.0
 */
public final class WindowUtil {
	/**
	 * 调用结束窗口，然后退出程序
	 * 
	 * @param sc
	 *            接收器
	 */
	protected static void byebye(Scanner sc) {
		Window window = new ByeByeWindow();
		window.show(sc);
		System.exit(0);
	}

	/**
	 * 调用欢迎窗口，进入登录注册页面
	 * 
	 * @param sc
	 *            接收器
	 */
	public static void start(Scanner sc) {
		Window window = new WelcomeWindow();
		window.show(sc);
	}

}
