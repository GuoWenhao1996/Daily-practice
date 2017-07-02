package com.team3.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToolUtil {
	
	public static String md5Password(String password) {
		try {
			// 得到一个信息摘要器
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(password.getBytes());
			StringBuffer buffer = new StringBuffer();
			// 把没一个byte 做一个与运算 0xff;
			for (byte b : result) {
				// 与运算
				int number = b & 0xff;// 加盐
				String str = Integer.toHexString(number);
				if (str.length() == 1) {
					buffer.append("0");
				}
				buffer.append(str);
			}
			// 标准的md5加密后的结果
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 返回cookie存储的学号对象
	 * @param request
	 * @return 已登录的学号
	 * @throws UnsupportedEncodingException
	 */
	public static String getCookieno(HttpServletRequest request) throws UnsupportedEncodingException{
		String name=null;
		Cookie Cookies[] = request.getCookies();
		if (Cookies != null) {
			for (int n = 0; n < Cookies.length; n++) {
				Cookie newCookie = Cookies[n];
				if (newCookie.getName().equals("cookieNo")) {
					name = newCookie.getValue();
					name = java.net.URLDecoder.decode(name, "UTF-8");
				}
			}
		}
		return name;
	}
}
