package com.gwhcool.phonebook.service;

/**
 * �û�����ӿ�
 * 
 * @author gwh
 * @version 1.0
 */
public interface UserService {
	/**
	 * ��¼
	 * 
	 * @param name
	 *            �û���
	 * @param pwd
	 *            ����
	 * @return
	 */
	abstract boolean login(String name, String pwd);

	/**
	 * ע��
	 * 
	 * @param name
	 *            �û���
	 * @param pwd
	 *            ����
	 * @return �Ƿ�ע��ɹ�
	 */
	abstract boolean resister(String name, String pwd);

	/**
	 * �ж��û����Ƿ����
	 * 
	 * @param name
	 * @return �Ƿ����
	 */
	boolean isExist(String name);
}
