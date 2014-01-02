package com.zdqk.laobing.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author 罗飞翔 
 *
 * true  验证通过
 * 
 * false 验证失败
 *
 */

public class ValidateTools {
	
	//非空验证
	
	public static boolean checkNull(String str){
		
		if(str==null||(str!=null&&str.equals(""))){
			return false;
		}
		
		return true;
	}

	
	//手机号验证
	
	public static boolean checkMobile(String str){

	    String reg_templete = "^0?(130|131|132|133|134|135|136|137|138|139|147|150|151|152|153|155|156|157|158|159|180|181|182|183|184|185|186|187|188|189)[0-9]{8}";  

	    return Pattern.compile(reg_templete).matcher(str).matches();  

	}

	//座机号验证
	
	public static boolean checkTelephone(String str){
		
		
		String[] myArray = null;
		myArray = str.split(";");
		
		for(int i=0;i<myArray.length;i++){
			String exp1 = "^[0-9\\-\\;]*$";
			String exp2 = "^(086-(0\\d{3}|0\\d{2})-(\\d{8}|\\d{7}))+(-(\\d{4}|\\d{3}))?";
	
			if(!(Pattern.compile(exp1).matcher(myArray[i]).matches() && Pattern.compile(exp2).matcher(myArray[i]).matches())){
				return false;
			}
		}
		return true;
	}
		
	//身份证验证

	public static boolean checkPersonId(String str){
		if (null == str || "".equals(str)) {
			return false;
		}
		
		String regexp = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";
		
		Pattern pattern = Pattern.compile(regexp);
		
		Matcher matcher = pattern.matcher(str);
		 
		if (!matcher.matches()) {
			return false;
		} else if (str.length() == 18) {
			int iSs = 0;
			int iY = 0;
			String szVerCode = "10X98765432";
			int[] iw = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
			
			for (int i = 0; i < 17; i++) {
				String temp = str.substring(i, (i + 1));
				
				iSs += iw[i] * ((Integer.parseInt(temp)) - 0);
			}
			
			iY = iSs % 11;
			
			String eChr = str.substring(17);
			String vChr = szVerCode.substring(iY);
			vChr = String.valueOf(vChr.charAt(0));
			
			if (eChr.equals(vChr)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}


	//非法字符验证
	
	public static boolean checkIllegalChar(String str){
		
		//String non_special_char_regexp = "。:,;,>,<,--,sp_,xp_,\\,dir,cmd,^,+,$,',copy,format,and,exec,insert,select,delete,update,count,*,%,chr,mid,master,truncate,char,declare";
		String non_special_char_regexp = "。:,\",>,<,--,sp_,xp_,\\,dir ,cmd ,^,+,$,',copy ,format ,and ,exec ,insert ,select ,delete ,update ,count ,*,%,chr ,mid ,master ,truncate ,char ,declare ";
	
		String non_special_char_regexp2 = " dir, cmd, copy , format, and, exec, insert, select, delete, update, count, chr, mid, master, truncate, char, declare";
    
		List<String> list=new ArrayList<String>();
        
        list.add(non_special_char_regexp);
        
        list.add(non_special_char_regexp2);
        
        for(int j=0;j<list.size();j++){
        	
        	String[] a = list.get(j).split(",");
        	
        	int strint = str.length();
        	
        	for(int i=0; i<a.length; i++){
        		
        		str=str.replace(a[i], "");
        		
        		if(str.length()<strint){
        			
        			return false;
        			
        		}
        		
        	}
        }
		
		return true;
	}	
	
	//数字验证
	
	public static boolean checkNumber(String str){
		
		String Number = "0123456789.";
		for (int i = 0; i < str.length();i++)
		{   
		    // Check that current character isn't whitespace.
		    char c = str.charAt(i);
		    if (Number.indexOf(c) == -1) return false;
		}
		return true;
	}
	
	//纯字母验证

	public static boolean checkChar(String str){
		
		String letter_regexp = "^[A-Za-z]*$"; 

		return Pattern.compile(letter_regexp).matcher(str).matches();
		
	}

	
	//电子邮件验证
	
	public static boolean checkEmail(String str){
		
		boolean flag = true;
		
		String[] myArray = null;
		myArray = str.split(";");
		
		for(int i=0;i<myArray.length;i++){
		
		
			String email_regexp = "(?:\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3}$)"; 
		
			flag = Pattern.compile(email_regexp).matcher(myArray[i]).matches();  
		}
		
		return flag;
	}

	//日期验证
	
	public static boolean checkDate(String str){
		
		String date="([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))";
		
		return Pattern.compile(date).matcher(str).matches();  
	}
	
	
	//验证域名
	
	public static boolean checkDomain(String str){
		
		String url_regexp = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?"; 
		
		return Pattern.compile(url_regexp).matcher(str).matches();  
	}
	
	//验证ip地址
	
	public static boolean checkIp(String str){
		
		String ip = "((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)(\\.((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)){3}";
		
		return Pattern.compile(ip).matcher(str).matches(); 
	}

	/**
	 * 比较日期范围（起始时间 < 终止时间）
	 * 
	 * @author lj
	 * @date 2009-12-4
	 * @param beginDate 起始时间
	 * @param endDate 终止时间
	 * @return
	 */
	public static boolean checkDateRange(Date beginDate, Date endDate) {
		if (beginDate.compareTo(endDate) == -1 || beginDate.compareTo(endDate) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 校验字符串长度
	 * 
	 * @author lj
	 * @param str 字符串
	 * @param len 长度
	 * @return
	 */
	public static boolean checkStrLen(String str, int len) {
		if (str.trim().length() < len) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args){
//		String s = "(130|131|132|133|134|135|136|137|138|139|147|150|151|152|153|155|156|157|158|159|180|181|182|183|184|185|186|187|188|189)\\d{8}";
		String s = "511324198609154072";
		System.out.println(s.substring(2));
		System.out.println(s.substring(1,3));
//		getPatternFromStr(s,"C:\\Users\\Administrator\\Desktop\\4.20_10000条.txt");
//		getPatternFromStr(s,"C:\\Users\\Administrator\\Desktop\\phone1.txt");
//		System.out.println(v.checkIllegalChar("and"));
		
	}
	
}
