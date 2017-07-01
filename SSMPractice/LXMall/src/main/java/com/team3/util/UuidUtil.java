package com.team3.util;

import java.util.UUID;

public class UuidUtil {
	/**
	 * 生成32位的唯一字符串
	 * @return
	 */
	public static String uuid(){
		String uuid=UUID.randomUUID().toString();
		char[] cs=new char[32];
		int j=0;
		for(int i=uuid.length();i-->0;){
			if(uuid.charAt(i)!='-'){
				cs[j++]=uuid.charAt(i);
			}
		}
		return new String(cs);
	}
}
