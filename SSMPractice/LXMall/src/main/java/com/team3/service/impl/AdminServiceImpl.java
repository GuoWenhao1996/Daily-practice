package com.team3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.AdminDao;
import com.team3.po.Admin;
import com.team3.service.AdminService;

/**
 * 管理员业务接口的实现类
 * @author renzhonghao
 *
 */
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	public Admin getAdmin(Admin admin){
		return adminDao.getAdmin(admin);
	}
	
	

}
