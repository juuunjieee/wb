
<%@page import="com.ulwxbase.utils.CbConstants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String forward_url=(String)request.getAttribute(CbConstants.Action.URL_FORWARD);
	request.getRequestDispatcher(forward_url).forward(request, response);
%>