package com.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.team3.po.User;
import com.team3.service.UserService;

/**
 * 用户信息的控制器
 * @author renzhonghao
 *
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("register.do")
	public String register(User user){
		user.setSex("男");
		user.setStatus("普通用户");
		userService.addUser(user);
		return "frontend/login";		
	}
	
	@RequestMapping("login.do")
	public String login(User user,Model model) {
		User us=userService.getUser(user);
		if(us==null){
			model.addAttribute("errormessage", "不存在该账号");
			return "frontend/login";
		}
		else if(user.getPassword().equals(us.getPassword())){
			return "frontend/navigation";
		}
		else{
			model.addAttribute("errormessage", "密码错误");			
			return "frontend/login";
		}
	}

}
