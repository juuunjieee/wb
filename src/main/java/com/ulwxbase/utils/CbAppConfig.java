package com.ulwxbase.utils;

import com.ulwx.tool.Path;
import com.ulwx.tool.PropertyUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 
 * @author Iren08
 * @date 2017年3月8日 下午1:17:25
 * @version 1.0
 */
public final class CbAppConfig {

	private static final Logger log = LoggerFactory.getLogger(CbAppConfig.class);

	private static final String FILE_NAME = "/common-base.property";

	public static Map<String, String> pu = null;
	public static String loginSmsTestTo = "login.sms.test.to";
	public static String loginSmsTestToNoSmscode = "login.sms.no.smscode";
	public static String privateKey="private.key";
	public static String loginSmsClass="login.sms.class";
	public static String sysDbpoolname="sys.dbpoolname";
	public static String loginUserInfPlugin="login.userInf.plugin";

	static {
		try {
			pu = PropertyUtil.loadAsMap(Path.getResource(FILE_NAME));

		} catch (Exception e) {
			log.error("", e);
		}
	}

	public static String getLoginSmsClass() {
		return getValue( loginSmsClass);
	}

	public static String getLoginUserInfPlugin() {
		return  getValue( loginUserInfPlugin);
	}

	public static String getSysDbpoolname() {
		return getValue( sysDbpoolname);
	}

	public static String getValue(String propertyName) {
		return StringUtils.trim(pu.get(propertyName));
	}

	public static String getPrivateKey() {
		return getValue(privateKey);
	}


	public static Map<String, String> getPu() {
		return pu;
	}

	public static String getLoginSmsTestTo() {
		return getValue(loginSmsTestTo);
	}

	public static String getLoginSmsTestToNoSmscode() {
		return getValue(loginSmsTestToNoSmscode);
	}


}
