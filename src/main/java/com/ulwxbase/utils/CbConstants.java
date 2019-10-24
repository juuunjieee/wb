package com.ulwxbase.utils;

import org.apache.log4j.Logger;



public class CbConstants {
	private static Logger log = Logger.getLogger(CbConstants.class);
	public static class SessionKey {
		public final static String USER = "USER";
		public final static String USER_LOG = "USER_LOG";
		public final static String CAPTCHA = "captcha";
		public final static String MsgReturnURL = "ReturnURL";
		public final static String MsgKey = "Msg";
		public final static String USER_ANALOGLANDING="USER_ANALOGLANDING";
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



	public static void main(String[] args) {

	}
}
