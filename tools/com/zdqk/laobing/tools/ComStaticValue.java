package com.zdqk.laobing.tools;



import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 
 * @author lfx
 *
 */
public class ComStaticValue implements ServletContextListener{

	public static ResourceBundle bundle = null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		bundle = null;
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		bundle = PropertyResourceBundle.getBundle("initconfig");
	}
	public static String init(String name) {
		return	bundle.getString(name);
	}
}
