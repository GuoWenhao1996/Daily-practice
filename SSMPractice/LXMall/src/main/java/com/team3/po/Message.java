package com.team3.po;

import java.util.Date;

/**
 * 向前台回传信息的类
 * @author 莫天金
 *
 */
public class Message {
	private Date date;
	private String content;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
