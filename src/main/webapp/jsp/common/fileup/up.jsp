<%@page import="com.yscf.admin.utils.AppConfig"%>
<%@page import="com.ulwx.tool.StringUtils"%>

<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta charset="UTF-8">
<title>上传活动</title>
<jsp:include page="/head.jsp" flush="true"></jsp:include>
<style>
</style>

<script>
	
	$(document).ready(function () {			
		$("body").css("visibility", "visible");  
	})

	function initform(){

		if(dlg.data){
			$('#type').val(dlg.data.type);
			$('#fType').val(dlg.data.fType);
			$('#id').val(dlg.data.id);
			$('#callbackUrl').val($.pageRoot+"/jsp/common/fileup/callback.jsp");
		}
	    clearEasyUiInvalidTip("#saveUserForm");
	}
	function initfirst(){
		initform();
		
	}
  	function add(){

	}


	/**弹窗框弹出的时候会初始化调用init方法，dlg为弹出框的引用*/
	var dlg=null;
	var edit=false;
	function init(d){
		dlg=d;
		initfirst();
		add();
		$("body").css("visibility", "visible");  
		
	}	

	/**更新时使用，此方法会在当前页面所有ajax调用完后被框架触发，保证combobox类似这种异步加载完数据后，加载当前页面的数据 */
	function all_ajax_loaded_on_init(){
		if(edit){
		}
	}
	
    function saveFormData() {
    	clearEasyUiInvalidTip("#saveUserForm");
    
    	$("body").showLoading();
    	var url="<%=AppConfig.getFileUploadIntf()%>";

		$('#saveUserForm').form('submit',
		{
			url : url,
			iframe:true,
			onSubmit : function(param) {
				var ret = $(this).form('enableValidation').form(
						'validate');
				if (!ret) {
					$("body").hideLoading();
				}
				return ret;
			},
			success : function(data) {
				$("body").hideLoading();
				//alert(data);
				var ret = $.evalJSON($.trim(data));
				if (ret.status == 1) {
					dlg.data.callback(ret.data,1,ret.message);
					dlg.close();

				} else {
					//dlg.data.callback({},0,ret.message);
					//alert("操作失败！[" + ret.message + "]");
					window.top.$.messager.alert("错误！","操作失败！[" + ret.message + "]");
				}
			}
		});

	}

	//点击取消把窗口关闭
	function closeWindow() {
		dlg.close();
	}
</script>

</head>
<body >

	<form class="commonForm" id="saveUserForm" enctype="multipart/form-data" method="post">
		<div class="commonForm-items">
			<input data-options="label:'文件:',buttonText:'选择'" 
				name="file" id="file" class="easyui-filebox" style="width:400px" /> 
			<input	type="hidden" name="type" id="type" /> 
			<input type="hidden" name="fType" id="fType" />
			<input type="hidden" name="id" id="id" />
			<input type="hidden" name="callbackUrl" id="callbackUrl" />
		</div>
		<div class="btns">
			<a style="margin-right: 15px;" class="easyui-linkbutton"
				onclick="saveFormData()">保存</a> &nbsp; <a
				class="easyui-linkbutton normalBtn" onclick="closeWindow()">取消</a>
		</div>
	</form>


</body>
</html>