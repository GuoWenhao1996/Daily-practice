package com.gwhcool.phonebook.start;

import java.util.Scanner;

import com.gwhcool.phonebook.window.WelcomeWindow;
import com.gwhcool.phonebook.window.Window;
import com.gwhcool.phonebook.window.WindowUtil;

/**
 * ͨѶ¼����̨Ӧ�ó���������ļ�
 * 
 * @author gwh
 * @version 1.0
 *
 */
public class PhoneBookStart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WindowUtil.start(sc);
	}
}
