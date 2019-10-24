
<%@page import="com.ulwxbase.utils.CbConstants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String redirect_url=(String)request.getAttribute(CbConstants.Action.URL_REDIRECT);
	response.sendRedirect(request.getContextPath()+redirect_url);
%>