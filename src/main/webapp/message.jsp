
<%@page import="com.ulwx.tool.StringUtils"%>
<%@page import="com.ulwxbase.utils.CbConstants"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html> 
<head>
<title>消息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<style type="text/css">
  .message_tip{
	    background-color: #EEEEEE;
	    border: 1px dotted rgba(0, 0, 0, 0.2);
	    border-radius: 5px 5px 5px 5px;
	    margin: 10px 17px;
	    padding: 0 0 10px;
	    height:100px;
	    width:300px;
   }
</style>
 
<jsp:include page="/head.jsp" flush="true"></jsp:include>

<script  type="text/javascript" language="javascript">
<%String msg=(String)request.getAttribute(CbConstants.SessionKey.MsgKey);
String returnUrl=StringUtils.trim((String)request.getAttribute(CbConstants.SessionKey.MsgReturnURL));
// if(returnUrl.equals("")) returnUrl="javascript:history.back();void 0;";%>
function url(){
	<%
	if(!returnUrl.equals("")){
	
	%>
	if(window.top!=null){
		window.top.location='<%=returnUrl%>';
	}else{
		window.location='<%=returnUrl%>';
	}
	<%}%>
}
$(document).ready(function(){

});
</script>
</head>
<body > 

<div id="MessageDlg" iconCls='icon-tip' class="easyui-dialog" title="消息提示" style=""  
        data-options="onClose:function(){url()}">  
        <div class="messager-body panel-body panel-body-noborder window-body" title="" style="width: 380px; height: auto;">
        <div class="messager-icon messager-info"></div><div><%=msg %></div>
        <div style="clear:both;"></div>
          <div id="tb" style="text-align: center;margin-top:10px">
	       <a  class="easyui-linkbutton"   onclick="url()">确 定</a>
	     </div>
        </div>
	 
</div>
</body>
</html>