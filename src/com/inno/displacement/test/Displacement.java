package com.inno.displacement.test;

public class Displacement {
	public static void main(String[] args) {
		int a = 122;
		String msg = "abcdsadfsadfas";
		System.out.println(a + " to binary: " + Integer.toBinaryString(a));
		String result = "";
		for (int i = 0; i < msg.length(); i++) {
			result += (char)((msg.charAt(i) & 0x81) | ((msg.charAt(i) & 0x54) >> 1) | ((msg.charAt(i) & 0x2a) << 1));
		}
		System.out.println(result);
		
		char[] c = Integer.toBinaryString(a).toCharArray();
		for (int i = 0; i < c.length; i++) {
			c[i] = (char) (c[i]^1);	// 异或 同为1时结果为零，否则为1
		}
		a = Integer.valueOf(String.valueOf(c), 2);
		
		System.out.println(a + " to binary: " + Integer.toBinaryString(a));
	}
}
