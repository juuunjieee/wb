package com.ulwx.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class NoPageCacheFilter implements Filter {

	private static Logger log = LoggerFactory.getLogger(NoPageCacheFilter.class);
	protected FilterConfig filterConfig;


	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
	
	} 

	public void doFilter(final ServletRequest req, final ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
	
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 
		response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
		
//		Enumeration headerNames = request.getHeaderNames();
//		String headerValues = "";
//		while (headerNames.hasMoreElements()) {
//			String headerName = (String) headerNames.nextElement();
//			headerValues = headerValues + headerName + ":"
//					+ request.getHeader(headerName) + "\n";
//
//		}
//		String url = StringUtils.trim(request.getRequestURI());
//		log.debug("request URL="+url);
//		log.debug("HTTP request Headers:" + headerValues);
		chain.doFilter(req, res);
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void setFilterConfig(final FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
}
