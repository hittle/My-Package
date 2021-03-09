package com.lzl.util;

public class CardFormat {

	public static String numberFormat(String s) {
		StringBuilder sb = new StringBuilder(s);
		if(sb.length()==11) {
			sb.replace(3, 7, "****");
		}else if(sb.length() == 18) {
			sb.replace(6, 14, "****");
		}
		return sb.toString();
	}
}
