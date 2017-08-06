package com.gwhcool.phonebook.service;

import com.gwhcool.phonebook.entity.Friend;

/**
 * ͨѶ¼��ϵ�˽ӿ�
 * 
 * @author gwh
 * @version 1.0
 */
public interface FriendService {
	/**
	 * չʾ���û���������ϵ��
	 * 
	 * @param username
	 *            �û���
	 */
	abstract void showAllFriends(String username);

	/**
	 * ͨ������������ϵ��
	 * 
	 * @param username
	 *            �û���
	 * @param name
	 *            ��ϵ������
	 */
	abstract void findFriendByName(String username, String name);

	/**
	 * ͨ���绰���������ϵ��
	 * 
	 * @param username
	 *            �û���
	 * @param phoneNumber
	 *            ��ϵ�˵绰����
	 */
	abstract void findFriendByPhoneNumber(String username, String phoneNumber);

	/**
	 * ͨ������ɾ����ϵ��
	 * 
	 * @param username
	 *            �û���
	 * @param name
	 *            ��ϵ������
	 */
	abstract void deleteFriendByName(String username, String name);

	/**
	 * ͨ�������޸���ϵ����Ϣ
	 * 
	 * @param username
	 *            �û���
	 * @param name
	 *            ��ϵ������
	 */
	abstract void updateFriendByName(String username, String name);

	
	/**
	 * �����ϵ��
	 * 
	 * @param friend
	 *            ��ϵ�˶���
	 */
	abstract void addFriend(Friend friend);

}
