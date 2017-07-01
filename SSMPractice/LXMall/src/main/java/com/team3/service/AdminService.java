package com.team3.service;

import com.team3.po.Admin;

/**
 * 管理员信息的核心管理业务接口
 * @author renzhonghao
 *
 */
public interface AdminService {
	/**
	 * 根据条件查找管理员
	 * @param admin查询条件
	 * @return
	 */
	public Admin getAdmin(Admin admin);

}
