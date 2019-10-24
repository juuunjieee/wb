package com.ulwx.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface AccessPlugin {

	public AccessBean doVerify(HttpServletRequest hreq,HttpServletResponse hres,AccessFilter filter) ;
}
