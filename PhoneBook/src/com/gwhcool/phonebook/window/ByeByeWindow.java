package com.gwhcool.phonebook.window;

import java.util.Scanner;

/**
 * 结束窗口<br>
 * 用于增强用户体验
 * 
 * @author gwh
 * @version 1.0
 */
public class ByeByeWindow extends Window {

	@Override
	public void show(Scanner sc) {
		System.out.println(">>>    ********      ********");
		System.out.println("     *          *  *          *");
		System.out.println("   *                            *");
		System.out.println("   *                            *");
		System.out.println("   *        欢  迎  下  次  使  用                          *");
		System.out.println("   *                            *");
		System.out.println("   *            再   见                                    *");
		System.out.println("     *                        *");
		System.out.println("       *                    *");
		System.out.println("         *                *");
		System.out.println("           *            *");
		System.out.println("              *      *");
		System.out.println("                 **");
	}

}
