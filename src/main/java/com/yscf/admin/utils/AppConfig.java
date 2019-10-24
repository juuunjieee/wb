package com.yscf.admin.utils;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ulwx.tool.Path;
import com.ulwx.tool.PropertyUtil;

/**
 * 
 * @author Iren08
 * @date 2017年3月8日 下午1:17:25
 * @version 1.0
 */
public final class AppConfig {

	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

	private static final String FILE_NAME = "/application.property";

	public static Map<String, String> pu = null;
	public static String httpPrefix="http.prefix";
	public static String fileUploadIntf="file.upload.intf";
	public static String jydAdmin2Url="jyd.admin2.url";

	public static String fileUploadActiveIntf="file.upload.active.intf";

	public static String fileUploadDirect="file.upload.direct";
	public static String fileUploadList="file.upload.list";


	static {
		try {
			pu = PropertyUtil.loadAsMap(Path.getResource(FILE_NAME));

		} catch (Exception e) {
			log.error("", e);
		}
	}


	public static String getFileUploadIntf() {
		return getValue(fileUploadIntf);
	}
	public static String getFileUploadActiveIntf() {
		return getValue(fileUploadActiveIntf);
	}
	
	public static String getFileUploadList() {
		return getValue(fileUploadList);
	}
	public static String getJydAdmin2Url() {
		return getValue(jydAdmin2Url);
	}

	public static String getValue(String propertyName) {
		return StringUtils.trim(pu.get(propertyName));
	}

	
	public static String getHttpPrefix() {
		return getValue(httpPrefix);

	}

	public static String getFileUploadDirect() {
		return getValue(fileUploadDirect);
	}
}
