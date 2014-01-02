package com.zdqk.laobing.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.zdqk.laobing.tools.ChineseUtils;
import com.zdqk.laobing.tools.GeneratePasswordUtil;


@Namespace("/lfx")
@ParentPackage("lfx-default")
@InterceptorRefs( { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("defaultStack") })
//public class RandomAction extends BasicAction {
public class RandomAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action("randomImg")
	public void randomImg() {

		try {
			 HttpSession session=ServletActionContext.getRequest().getSession();;					
			 HttpServletResponse response =ServletActionContext.getResponse();
							
//			String tmp = ChineseUtils.getRandomLengthChiness(3, 4);
			String tmp =GeneratePasswordUtil.generateIcpUserPassword(4);
			session.setAttribute("vc", tmp);
//			session.setMaxInactiveInterval(30);
			response.setContentType("image/jpeg");
			ServletOutputStream outImg = response.getOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outImg);
			encoder.encode(ChineseUtils.getImage(tmp));
			outImg.close();

		} catch (com.sun.image.codec.jpeg.ImageFormatException ie) {

		} catch (java.io.IOException e) {

		}

	}
}
