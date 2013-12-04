package com.coderdream;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class HTMLDecoder {

	public static String decode(String str) {
		String[] tmp = str.split(";&#|&#|;");
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].matches("\\d{5}")) {
				sb.append((char) Integer.parseInt(tmp[i]));
			} else {
				sb.append(tmp[i]);
			}
		}
		return sb.toString();
	}

	public static String string2Unicode(String s) {
		try {
			StringBuffer out = new StringBuffer("");
			byte[] bytes = s.getBytes("unicode");
			for (int i = 2; i < bytes.length - 1; i += 2) {
				out.append("u");
				String str = Integer.toHexString(bytes[i + 1] & 0xff);
				for (int j = str.length(); j < 2; j++) {
					out.append("0");
				}
				String str1 = Integer.toHexString(bytes[i] & 0xff);
				out.append(str1);
				out.append(str);
				out.append(" ");
			}
			return out.toString().toUpperCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 输出十进制，格式为&#00000; 如“中国”输出：&#20013;&#22269;
	 * 
	 * @param s
	 * @return
	 */
	public static String string2UnicodeNumber(String s) {
		try {
			StringBuffer out = new StringBuffer("");
			StringBuffer temp = null;
			StringBuffer number = null;
			byte[] bytes = s.getBytes("unicode");
			for (int i = 2; i < bytes.length - 1; i += 2) {
				temp = new StringBuffer("&#");
				number = new StringBuffer("");
				String str = Integer.toHexString(bytes[i + 1] & 0xff);
				for (int j = str.length(); j < 2; j++) {
					temp.append("0");
				}
				String str1 = Integer.toHexString(bytes[i] & 0xff);
				// 十进制转化为十六进制，结果为C8。
				// Integer.toHexString(200);
				// 十六进制转化为十进制，结果140。
				// Integer.parseInt("8C",16);
				number.append(str1);
				number.append(str);

				BigInteger bi = new BigInteger(number.toString(), 16);
				String show = bi.toString(10);

				temp.append(show + ";");
				out.append(temp.toString());
			}

			return out.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String unicode2String(String unicodeStr) {
		StringBuffer sb = new StringBuffer();
		String str[] = unicodeStr.toUpperCase().split("U");
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(""))
				continue;
			char c = (char) Integer.parseInt(str[i].trim(), 16);
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// System.out.println(string2Unicode("中国"));
		System.out.println(string2UnicodeNumber("中国"));
		System.out.println(string2UnicodeNumber("微软雅黑"));
		System.out.println(string2UnicodeNumber("楷体"));
		System.out.println(string2Unicode("中文测试ABC"));
		System.out.println(unicode2String(string2Unicode("中文测试ABC")));
	}

}
