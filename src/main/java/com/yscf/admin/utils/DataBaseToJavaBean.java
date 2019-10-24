package com.yscf.admin.utils;

import com.ulwx.database.sql.SqlUtils;

public class DataBaseToJavaBean {

	public static void main(String[] args) {
		////System.out.println(Path.getClassPath());
		SqlUtils.exportTables("yscf_mdb", "yscfmdb", "d:/ok4/yscfmdb", "com.yscf.admin.domain.db.yscfmdb","utf-8",true);


	
	}
}