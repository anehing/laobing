package com.zdqk.laobing.action;
import java.net.InetAddress;
import java.net.MalformedURLException; 
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException; 

import com.jtd.sms.SmsImpl;
import com.jtd.sms.SmsInterface;
 
 
public class test {
	 
	public static void main(String[] args) throws UnknownHostException {
		
			InetAddress addr = InetAddress.getLocalHost();
			String ip=addr.getHostAddress().toString();//获得本机IP
			String address=addr.getHostName().toString();//获得本机名称


			System.out.println(ip);
			System.out.println(address);
	
	
}
}