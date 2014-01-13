package com.zdqk.laobing.action;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class sendsms {
	private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";

	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);
		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType",
				"application/x-www-form-urlencoded;charset=UTF-8");
		String content = new String("您的验证码是：7528。请不要把验证码泄露给其他人。");

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", "cf_aameimei"),
				new NameValuePair("password", "784533"),
				new NameValuePair("mobile", "15081509046"),
				new NameValuePair("content", content), };
		method.setRequestBody(data);
		try {
			client.executeMethod(method);
			System.out.println(method.getResponseBodyAsString());
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("短信提交成功");
	}
}