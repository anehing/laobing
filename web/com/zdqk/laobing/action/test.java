package com.zdqk.laobing.action;
import java.net.MalformedURLException; 
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException; 

import com.jtd.sms.SmsImpl;
import com.jtd.sms.SmsInterface;
 
 
public class test {
	public static void main(String[] args) {
		try {
			  
			SmsInterface s=SmsImpl.getInterface("http://116.90.87.221/qxt_jtd/service/SmsService"); 
			System.out.println(s.getBalance("jddl", "jddl123"));
			String mes=s.sendSms("jddl", "jddl123", "15122554903,15033987695", "laobing2", "43");
			System.out.println(s.getReport("jddl", "jddl123")); 
			System.out.println(mes); 
			 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
