package com.ulwxbase.utils;

import com.ulwx.database.sql.SqlUtils;

public class CbDataBaseToJavaBean {

	public static void main(String[] args) {
		////System.out.println(Path.getClassPath());
		SqlUtils.exportTables("jyd2sale", "jyd2_sale", "d:/ok4/sys", "com.ulwxbase.domain.db.sys","utf-8",true);

	
	}
}