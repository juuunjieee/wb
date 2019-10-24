package com.yscf.admin.utils;

public class Dao {

	public static String yscfmdb = "yscf_mdb";

	// 使用md的方式对数据库增删改查
	private static String getMdMethodStr(Class daoClass, String method) {
		String prefix = daoClass.getName();
		return prefix + ".md:" + method;
	}

	public static String md(Class daoClass, String method) {
		return getMdMethodStr(daoClass, method);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
	}

}
