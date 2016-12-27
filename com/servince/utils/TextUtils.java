package com.servince.utils;

public class TextUtils {
	public static boolean isEmpty(String str){
		if (null == str || "".equals(str)){
			return false;	
		}else{
			return true;	
		}	
	}
}
