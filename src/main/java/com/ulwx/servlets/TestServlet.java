
package com.ulwx.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ulwx.tool.IOUtils;

public class TestServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(TestServlet.class);
	private static final long serialVersionUID    = 7343884308690712345L;

	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {   
		
//		String bkurl = "javascript:closeWin();void 0;";
//		//bkurl="javascript:backWin();void 0;";
//		HttpSession session = req.getSession();
//		session.setAttribute("msg", "操作成功！");
//		session.setAttribute("backurl", bkurl);
//		String context = req.getContextPath();
//		String nextUrl = context + "/msg.jsp";
//		resp.sendRedirect(nextUrl);
		ServletInputStream in =null;
		try {
			in = request.getInputStream();
			String postStr = IOUtils.toString(in,"gb2312", true);
			System.out.println(postStr);
		} catch (Exception e) {
			log.error("",e);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
