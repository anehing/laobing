package com.zdqk.laobing.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ChineseUtils {

	private static Random random = null;

	// 图片的宽度
	private final static int IMAGEWIDTH = 32;
	// 图片的高度
	private final static int IMAGEHEIGHT = 32;

	// 字体大小
	private final static int FONTSIZE = 24;

	private static Random getRandomInstance() {
		if (random == null) {
			random = new Random(new Date().getTime());
		}
		return random;
	}

	public static String getChinese() {
		String str = null;
		int highPos, lowPos;
		Random random = getRandomInstance();
		highPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = 161 + Math.abs(random.nextInt(93));
		byte[] b = new byte[2];
		b[0] = (new Integer(highPos)).byteValue();
		b[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(b, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String getFixedLengthChinese(int length) {
		String str = "";
		for (int i = length; i > 0; i--) {
			str = str + ChineseUtils.getChinese();
		}
		return str;
	}

	public static String getRandomLengthChiness(int start, int end) {//入口3，4
		String str = "";
		int length = new Random().nextInt(end + 1);
		if (length < start) {
			str = getRandomLengthChiness(start, end);
		} else {
			for (int i = 0; i < length; i++) {
				str = str + getChinese();
			}
		}
		return str;
	}

	/**
	 * 生成指定字符串的图像数据
	 * 
	 * @param verifyCode
	 *            即将被打印的随机字符串
	 * @return 生成的图像数据
	 */
	public static BufferedImage getImage(String verifyCode) {
		getRandomInstance();
		// 生成画布
		BufferedImage image = new BufferedImage(IMAGEWIDTH
				* verifyCode.length(), IMAGEHEIGHT, BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文 （生成画笔）
		Graphics graphics = image.getGraphics();

		// 设置背景色（）
		graphics.setColor(getRandColor(50, 100));

		// 填充矩形区域 ，作为背景
		graphics.fillRect(0, 0, IMAGEWIDTH * 4, IMAGEHEIGHT);

		// 设置边框颜色
		//graphics.setColor(new Color(0, 255, 0));

		// 画出边框
		/*
		for (int i = 0; i < 2; i++)
			graphics.drawRect(i, i, IMAGEWIDTH * verifyCode.length() - i * 2
					- 1, IMAGEHEIGHT - i * 2 - 1);
		 */
		// 设置随机干扰线条颜色
		graphics.setColor(getRandColor(200, 250));

		// 产生干扰线条
		for (int i = 0; i < 6; i++) {
			int x1 = random.nextInt(IMAGEWIDTH * verifyCode.length() - 4) + 2;
			int y1 = random.nextInt(IMAGEHEIGHT - 4) + 2;
			int x2 = random.nextInt(IMAGEWIDTH * verifyCode.length() - 2 - x1)
					+ x1;
			int y2 = y1;
			graphics.drawLine(x1, y1, x2, y2);
		}

		// 设置字体
		graphics.setFont(new Font("", Font.BOLD, FONTSIZE));

		// 画字符串
		for (int i = 0; i < verifyCode.length(); i++) {

			String temp = verifyCode.substring(i, i + 1);
			graphics.setColor(getRandColor(100, 255));
			graphics.drawString(temp, 30 * i + 6, 24);
		}

		// 图像生效
		graphics.dispose();

		return image;

	}

	/**
	 * 生成随机颜色
	 * 
	 * @param ll
	 *            产生颜色值下限(lower limit)
	 * @param ul
	 *            产生颜色值上限(upper limit)
	 * @return 生成的随机颜色对象
	 */
	private static Color getRandColor(int ll, int ul) {
		if (ll > 255)
			ll = 255;
		if (ll < 1)
			ll = 1;
		if (ul > 255)
			ul = 255;
		if (ul < 1)
			ul = 1;
		if (ul == ll)
			ul = ll + 1;
		int r = random.nextInt(ul - ll) + ll;
		int g = random.nextInt(ul - ll) + ll;
		int b = random.nextInt(ul - ll) + ll;
		Color color = new Color(r, g, b);
		return color;
	}

	public static void main(String args[]) throws ImageFormatException, IOException {
		/*
		System.out.println(ChineseUtils.getChinese());
		System.out.println(ChineseUtils.getFixedLengthChinese(20));
		System.out.println(ChineseUtils.getRandomLengthChiness(2, 5));
		*/
		String tmp=ChineseUtils.getRandomLengthChiness(3, 4);
		System.out.println(tmp);
		FileOutputStream fos = new FileOutputStream("c://test.jpg");
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
		encoder.encode(getImage(tmp));

	}
}
