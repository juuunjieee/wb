package com.yscf.admin.utils;

import org.apache.log4j.Logger;



public class MyConstants {
	private static Logger log = Logger.getLogger(MyConstants.class);
	public static class SessionKey {
		public final static String USER = "USER";
		public final static String USER_LOG = "USER_LOG";
		public final static String CAPTCHA = "captcha";
		public final static String MsgReturnURL = "ReturnURL";
		public final static String MsgKey = "Msg";
	}
	
	public static class OperType {
		// 操作类型：1：登陆 2：退出 3：查看 4：编辑 5：删除 6：添加
		public static Integer LOGIN = 1;
		public static Integer LOGOUT = 2;
		public static Integer LOOK = 3;
		public static Integer EDIT = 4;
		public static Integer DEL = 5;
		public static Integer ADD = 6;
	}
	
	public static class Action{
		public final static String URL_FORWARD="url_forward";
		
		public final static String URL_REDIRECT="url_redirect";
		
		public final static String URL_DOWNLOAD="url_download";
		
		public final static String URL_DOWNLOAD_NAME="download_excel";
	}
	
	public static class SmsType{
		//短信发送类型定义
		public final static String VALIDATE_TYPE="1";//校验类型
		public final static String MARKETING_TYPE="2";//营销类型
		
	}


	public static void main(String[] args) {

	}
}
