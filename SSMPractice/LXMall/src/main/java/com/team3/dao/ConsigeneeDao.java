package com.team3.dao;

import java.util.List;

import com.team3.po.Consigenee;

/**
 * 收获地址数据信息访问接口
 * @author 莫天金
 *
 */
public interface ConsigeneeDao {
	/**
	 * 添加收获地址
	 * @param consigenee
	 */
	public void addConsigenee(Consigenee consigenee);
	
	/**
	 * 根据用户Id得到收获地址列表
	 * @param userId
	 * @return
	 */
	public List<Consigenee> getConsigeneeList(String userId);
	
	/**
	 * 根据收获地址Id删除收获地址
	 * @param consigeneeId
	 */
	public void deleteConsigenee(Consigenee consigenee);
	
	/**
	 * 根据条件加载收货地址信息
	 * @param consigenee
	 * @return
	 */
	public Consigenee getConsigeneeById(Consigenee consigenee);
	
}
