package com.ulwxbase.filter;

import com.ulwx.tool.MD5;
import com.ulwx.tool.StringUtils;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.utils.CbConstants;
import com.ulwxbase.web.action.sys.services.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DebugFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(DebugFilter.class);
	private String userName;
	private String userPass;
	


	/**
	 * Default constructor.
	 */
	public DebugFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) request; 
		HttpServletResponse hres = (HttpServletResponse) response;  
		String userAccount = this.userName;
		String userPassword =this.userPass;
		
		String MD5Password = MD5.MD5generator(userPassword);
		HttpSession session=hreq.getSession();
	
		try {
			if( session.getAttribute(CbConstants.SessionKey.USER)==null){
				UserInfo userInfo  = UserInfoService.instance.getUserInfo(userAccount);
				if(userInfo!=null){
					session.setAttribute(CbConstants.SessionKey.USER, userInfo);
					session.setAttribute("rights", userInfo.getRights());
				}
			
			}

		} catch (Exception e) {
			log.error("",e);
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig Config) throws ServletException {
		// TODO Auto-generated method stub
		
		userName = StringUtils.trim(Config.getInitParameter("userName"));
		userPass = StringUtils.trim(Config.getInitParameter("userPass"));
	}

}
