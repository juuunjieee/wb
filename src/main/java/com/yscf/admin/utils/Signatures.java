package com.yscf.admin.utils;

import com.ulwx.tool.MD5;
import com.ulwx.tool.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TreeMap;

public class Signatures {
	private static final Logger log = LoggerFactory.getLogger(Signatures.class);
	private static final String key = "xygedgeerxs@345%4#dee@";//1 交易系统的防篡改md5加密key
	public static String urlEncode(String text) {
		try {
			return URLEncoder.encode(text, "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return text;
	}

	public static String signature(String message) {

		try {
			String sMessagekey=message+"&key="+ Signatures.key;
			log.debug("signMessage="+sMessagekey);
			
			return MD5.MD5generator(sMessagekey,"utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static  String signature(TreeMap<String,String> parmMap) {
		String signMessage="";
		for(String key:parmMap.keySet()){
			String val=parmMap.get(key);
			if(val!=null){
				String str=key+"="+val;
				signMessage=signMessage+"&"+str;
			}
			
			
		}
		signMessage=StringUtils.trimLeadingString(signMessage, "&");
		
		return signature(signMessage);
	}
	public static  String signature(TreeMap<String,String> parmMap,String hkey) {
		String signMessage="";
		for(String key:parmMap.keySet()){
			String val=parmMap.get(key);
			if(val!=null){
				String str=hkey+"="+val;
				signMessage=signMessage+"&"+str;
			}
			
			
		}
		signMessage=StringUtils.trimLeadingString(signMessage, "&");
		
		return signature(signMessage);
	}
	public static void main(String[] args) throws Exception {

	}
}
