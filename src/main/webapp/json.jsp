
<%@page import="com.ulwx.tool.ObjectUtils"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
         errorPage=""%>
<%
	try
	{
		Object result = request.getAttribute("json");
		result = result instanceof String ? result : ObjectUtils.toJsonString(result);
		out.write((String) result);
	}
	catch (Exception e)
	{
		//JspLog.error("",e);

	}
%>