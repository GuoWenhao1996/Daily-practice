package com.team3.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.team3.po.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User getUser(User user);
	
	public User updateUser(User user);
	
	public void updatePassword(User user);

}
