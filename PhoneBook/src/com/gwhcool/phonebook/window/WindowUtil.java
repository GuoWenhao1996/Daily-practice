package com.gwhcool.phonebook.window;

import java.util.Scanner;

/**
 * ���ڹ�����<br>
 * ���崰�ڵ�һЩ��������
 * 
 * @author gwh
 * @version 1.0
 */
public final class WindowUtil {
	/**
	 * ���ý������ڣ�Ȼ���˳�����
	 * 
	 * @param sc
	 *            ������
	 */
	protected static void byebye(Scanner sc) {
		Window window = new ByeByeWindow();
		window.show(sc);
		System.exit(0);
	}

	/**
	 * ���û�ӭ���ڣ������¼ע��ҳ��
	 * 
	 * @param sc
	 *            ������
	 */
	public static void start(Scanner sc) {
		Window window = new WelcomeWindow();
		window.show(sc);
	}

}
