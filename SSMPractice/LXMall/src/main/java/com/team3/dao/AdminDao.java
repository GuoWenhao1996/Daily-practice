package com.team3.dao;

import com.team3.po.Admin;

/**
 * 管理员信息的信息访问接口
 * @author renzhonghao
 *
 */
public interface AdminDao {
	/**
	 * 根据条件查找管理员
	 * @param admin查询条件
	 * @return
	 */
	public Admin getAdmin(Admin admin);

}
