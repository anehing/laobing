package com.zdqk.laobing.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings({"rawtypes","unchecked"})
public class RequestFilter implements Filter {
	
	static long MAX_TIME = 10 * 1000;

	static int MAX_TIMES_PER_SECOND = 5;

	private Map requestMap;

	public void destroy() {
		requestMap = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    String client = request.getRemoteAddr();
    RequestInfo requestInfo = (RequestInfo) requestMap.get(client);

    if (requestInfo != null) {
      //���������Ϣ̫�Ͼ�����

    if (requestInfo.isTooOld()) {
        requestInfo.reset();
        chain.doFilter(request, response);
      } else {
        requestInfo.newRequest();
        if (requestInfo.isTooMuch()) {
          ((HttpServletResponse) response).sendRedirect("/Ewm/toomuch.html");
        } else {
        	try{
        		chain.doFilter(request, response);
        	}catch (java.lang.IllegalStateException e) {
					System.out.println("ҳ��״̬�쳣�������µ�¼");
					 ((HttpServletResponse) response).sendRedirect("/Ewm/login.html");	
			}
        }
      }
    } else {
      requestInfo = new RequestInfo();
      requestMap.put(client, requestInfo);
	  	try{
			chain.doFilter(request, response);
		}catch (java.lang.IllegalStateException e) {
			System.out.println("ҳ����ڣ������µ�¼");
		}
    }
  }

	public void init(FilterConfig filterConfig) throws ServletException {
		requestMap = new HashMap();
	}

	class RequestInfo {
		long firstTime;

		long lastTime;

		int count;

		public RequestInfo() {
			firstTime = System.currentTimeMillis();
			lastTime = System.currentTimeMillis();
			count = 1;
		}

		public void reset() {
			firstTime = System.currentTimeMillis();
			lastTime = System.currentTimeMillis();
			count = 1;
		}

		public void newRequest() {
			lastTime = System.currentTimeMillis();
			count++;
		}

		public boolean isTooMuch() {
			int seconds = (int) ((lastTime - firstTime) / 1000);
			if (seconds == 0) {
				seconds = 1;
			}
			int times = (int) (count / seconds);
			if (times > MAX_TIMES_PER_SECOND) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isTooOld() {
			if (System.currentTimeMillis() - firstTime > MAX_TIME) {
				return true;
			} else {
				return false;
			}
		}
	}
}