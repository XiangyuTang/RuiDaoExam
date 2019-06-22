package com.neuedu.ruidaoexam.configUtils;

import java.security.MessageDigest;

/**
 * 密码MD5加密工具类
 */
public class MD5Util {
	public static void main(String[] args) {
		System.out.println(MD5Util.md5Encode("123456"));
	}

	/*
	 * 方法：密码加密
	 * 详细：参数是密码，返回是加密的密码
	 */
	public static String md5Encode(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		byte[] byteArray = inStr.getBytes();
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuilder hexValue = new StringBuilder();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
}
