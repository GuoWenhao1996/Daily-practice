package com.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.po.Admin;
import com.team3.service.AdminService;
import com.team3.util.ToolUtil;

/**
 * 管理员管理的控制器
 * @author renzhonghao
 *
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	/**
	 * 管理员登录的方法
	 * @param admin
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(Admin admin,Model model){
		Admin ad=adminService.getAdmin(admin);
		if(ad==null){
			model.addAttribute("errormessage", "不存在该账号");
			return "backend/login";
		}
		else if(ToolUtil.md5Password(admin.getApassword()).equals(ad.getApassword())){
			return "backend/navigation";
		}
		else{
			model.addAttribute("errormessage", "密码错误");			
			return "backend/login";
		}
	}
}
