package com.gwhcool.phonebook.window;

import java.util.Scanner;

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

		} else if ("9".equals(choose)) {
			System.out.println(">>>ע���ɹ���");
			WindowUtil.start(sc);
		}else if ("0".equals(choose)) {
			WindowUtil.byebye(sc);
		} else {
			System.out.println(">>>�����������������룡");
			show(sc);
		}
	}

}
