package com.team3.util;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 2017-6-30 11:33:43<br>
 * 系统工具类（从之前的项目中拷过来的，可能有些方法用不到）
 * 
 * @author 郭文浩
 * @version 1.0
 *
 */
public class ThisSystemUtil {

	/**
	 * 字符串是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNone(String s) {
		return s == null || (s.trim()).length() == 0;
	}

	/**
	 * 转换为正常的时间格式
	 * 
	 * @param strdate
	 * @return
	 * @throws Exception
	 * @author 莫天金
	 */
	public static String toNormalStringDate(String strdate) throws Exception {
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf2.format(sdf1.parse(strdate));
	}

	/**
	 * 自定义字符串转化为整数
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static int parseInt(String s, int defaultValue) {
		try {
			int value = Integer.parseInt(s);
			return value;
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 字符串转化为时间
	 * 
	 * @param s
	 * @return
	 */
	public static Date StringToDate(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = sdf.parse(s);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Date(System.currentTimeMillis());
	}

	/**
	 * MD5加密
	 * 
	 * @param password
	 * @return
	 */
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
	 * 获取当前系统时间工具方法
	 * 
	 * @return yyyy-MM-dd HH:mm:ss格式的时间
	 * @author 郭文浩
	 */
	public static String getSystemTime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		return time;
	}

	public static String orderStatus(String str) {
		// 订单状态 0、待付款 1、配货中 2、已出货 3、已签收 4、待评价 5、已完成 9、已取消
		switch (Integer.parseInt(str)) {
		case 0:
			return "待付款";
		case 1:
			return "配货中";
		case 2:
			return "已出货";
		case 3:
			return "已签收";
		case 4:
			return "待评价";
		case 5:
			return "已完成";
		case 9:
			return "已取消";
		default:
			return "";
		}
	}
}
