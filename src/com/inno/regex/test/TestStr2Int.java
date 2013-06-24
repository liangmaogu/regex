package com.inno.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestStr2Int {
	public static void main(String[] args) {
		String str = "++00";
		System.out.println(str2Int(str));
	}
	
	public static int str2Int(String str) {
		if (str == null || "".equals(str)) {
			return 0;
		}
		
		str = str.trim();
		
		Matcher matcher = Pattern.compile("^(-|\\+)?[0-9]+").matcher(str);
		if (matcher.find()) {
			String number = str.substring(matcher.start(), matcher.end());

			try {
				return Integer.parseInt(number);
			} catch(Exception e) {
				if (number.startsWith("-")) {
					return Integer.MIN_VALUE;
				} else {
					return Integer.MAX_VALUE;
				}
			}
		} 
		
		return 0;
	}
}
