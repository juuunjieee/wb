package com.ulwxbase.utils;

import com.ulwx.tool.ArrayUtils;
import com.ulwx.tool.StringUtils;
import com.ulwx.type.TInteger;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CbDao {

	public static String sys = CbAppConfig.getSysDbpoolname();
	// 使用md的方式对数据库增删改查
	private static String getMdMethodStr(Class daoClass, String method) {
		String prefix = daoClass.getName();
		return prefix + ".md:" + method;
	}

	public static String md(Class daoClass, String method) {
		return getMdMethodStr(daoClass, method);
	}

	public static String getSqlWherePartAndSetParms(String property, Object[] objs, Map<Integer, Object> vars,
			TInteger startIndex) {

		if (ArrayUtils.isEmpty(objs)) {
			return " (1=1) ";
		}

		int f = startIndex.getValue();
		String sqlpart = "  " + property + "  " + "("
				+ StringUtils.arrayToCommaDelimitedString(ArrayUtils.nCopy("?", objs.length)) + ")";
		for (int i = 0; i < objs.length; i++) {
			vars.put(f++, objs[i]);
		}
		startIndex.setValue(f);
		return sqlpart;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {


		ExecutorService es = Executors.newFixedThreadPool(10);


	}

}
