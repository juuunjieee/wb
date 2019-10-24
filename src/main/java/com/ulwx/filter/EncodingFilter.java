package com.ulwx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** *//**
 * 处理Tomcat 服务器表单编码问题。
 * 此过滤器最好作为所有web.xml里过滤器的最后一个过滤器
 * @author htqx
 * @version 1.0 2008-1-20
 */
public class EncodingFilter implements Filter {

    /** *//**
     * 客户端的编码类型。
     * 默认为 UTF-8
     */
    String encode = "UTF-8";
 
    public void destroy() {
    }

   
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        if (request instanceof HttpServletRequest)
        {
            HttpServletRequest r = (HttpServletRequest)request;
           // System.out.println("encoding="+encode);
            r.setCharacterEncoding( encode );
            ((HttpServletResponse)response).setCharacterEncoding(encode);
      
        }
        //
        ((HttpServletResponse)response).setHeader("Access-Control-Allow-Origin", "*");        
        ((HttpServletResponse)response).setHeader("Access-Control-Allow-Methods", "POST, GET");        
        ((HttpServletResponse)response).setHeader("Access-Control-Max-Age", "3600");        
        ((HttpServletResponse)response).addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); 
        
        chain.doFilter(request, response);
        
    }
    public void init(FilterConfig filterConfig) throws ServletException {
        String c = filterConfig.getInitParameter("encode");
        if (c != null)
        {
            encode = c;
        }
        
    }

}
