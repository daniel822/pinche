package com.pinche.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * 所有action基类
 */
public class CommonAction {
	
	/**
	 * 返回内容
	 * @param object
	 * @throws IOException
	 */
	public void output(Object object) throws IOException{
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter outer = res.getWriter();
		outer.print(object);
		outer.flush();
	}
}
