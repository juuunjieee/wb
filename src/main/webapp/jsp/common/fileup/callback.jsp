<%@page import="com.ulwx.tool.ObjectUtils"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
	
<%
  String data=request.getParameter("data");
  out.write(data);

%>

