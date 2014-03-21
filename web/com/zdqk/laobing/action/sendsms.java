package com.zdqk.laobing.action;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.zdqk.laobing.action.vo.ResultVo;

public class sendsms {
	private static String Url = "http://116.213.72.20/SMSHttpService/send.aspx";

	public static void sendmsg(String username, String password, String mobile,
			String content) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);
		// client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType",
				"application/x-www-form-urlencoded;charset=UTF-8");
		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", username),
				new NameValuePair("password", password),
				new NameValuePair("mobile", mobile),
				new NameValuePair("content", content), };
		method.setRequestBody(data);
		client.executeMethod(method);

	}
}