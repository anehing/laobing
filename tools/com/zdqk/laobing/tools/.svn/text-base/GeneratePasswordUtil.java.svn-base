package com.zdqk.laobing.tools;

 

import org.apache.commons.lang.math.RandomUtils;

/**
 * @email messagelook@hotmail.com
 * @Description 随机数工具方法
 */
public class GeneratePasswordUtil {
	
	private final static char[] chars = new char[]{'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	private final static int [] ints = new int[]{2,3,4,5,6,7,8,9};
	
	private GeneratePasswordUtil(){}

	/**
	 * 按传入数据生成相对应位数随机码
	 */
	public static String generateIcpUserPassword(int size) {
		if(size % 2 != 0) {
			size = size + 1;
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < size/2; i++) {
			buffer.append(chars[RandomUtils.nextInt(chars.length)]);
		}
		
		for (int i = 0; i < size/2; i++) {
			buffer.append(ints[RandomUtils.nextInt(ints.length)]);
		}
		return buffer.toString();
	}
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(GeneratePasswordUtil.generateIcpUserPassword(4).toLowerCase());
		}
	}
}
