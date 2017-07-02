package com.team3.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.po.User;
import com.team3.service.UserService;
import com.team3.util.ToolUtil;

/**
 * 用户信息的控制器
 * 
 * @author renzhonghao
 *
 */
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("register.do")
	public String register(User user) {
		user.setSex("男");
		user.setStatus("普通用户");
		user.setPassword(ToolUtil.md5Password(user.getPassword()));
		userService.addUser(user);
		return "frontend/login";
	}

	@RequestMapping("login.do")
	public String login(User user, Model model,HttpServletResponse res) {
		User us = userService.getUser(user);
		if (us == null) {
			model.addAttribute("errormessage", "不存在该账号");
			return "frontend/login";
		} else if (ToolUtil.md5Password(user.getPassword()).equals(us.getPassword())) {
			Cookie cookieNo = new Cookie("cookieNo", us.getId()); 
			cookieNo.setPath("/");
			cookieNo.setMaxAge(60*60);
			res.addCookie(cookieNo);
			return "frontend/index";
		} else {
			model.addAttribute("errormessage", "密码错误");
			return "frontend/login";
		}
	}

	@RequestMapping("validate.do")
	public @ResponseBody String validate(User user) {
		if (user.getId().equals(null)) {
			return "";
		} else {
			User us = userService.getUser(user);
			if (us == null) {
				return "账号可用";
			} else {
				return "该账户已存在";
			}
		}
	}

	@RequestMapping("getpersondata.do")
	public String getpersondata(Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		User user = new User();
		System.out.println("个人资料："+ToolUtil.getCookieno(request));
		user.setId(ToolUtil.getCookieno(request));
		user = userService.getUser(user);
		model.addAttribute("user", user);
		return "frontend/user_center";
	}

	@RequestMapping("updateuser.do")
	public String updateuser(User user, Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		user.setId(ToolUtil.getCookieno(request));
		userService.updateUser(user);
		this.getpersondata(model, request);
		return "frontend/user_center";
	}

	@RequestMapping("updatapassword.do")
	public String updatapassword(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		String password = req.getParameter("password");
		User user=new User();
		user.setId(ToolUtil.getCookieno(req));
	    user=userService.getUser(user);
	    System.out.println(user.getPassword());
		if (!ToolUtil.md5Password(password1).equals(user.getPassword())) {
			model.addAttribute("message", "当前密码错误");
		} else if (password2.equals("")) {
			model.addAttribute("message", "密码不能为空");
		} else if (!password2.equals(password)) {
			model.addAttribute("message", "两次密码不一致");
		} else {
			user.setPassword(ToolUtil.md5Password(password));
			userService.updatePassword(user);
			model.addAttribute("message", "密码更改成功");
		}
		return "frontend/user_updatapassword";
	}
}
