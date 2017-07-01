package com.team3.service.gutil;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	private int start;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * 初始化分页信息
	 */
	public void  initPage(HttpServletRequest request){
		String str= request.getParameter("pager.offset");
		if(str!= null && !str.equals("")){
			start=Integer.parseInt(str);
		}else {
			start = 0;
		}
		System.out.println("str="+str);
	}
}
