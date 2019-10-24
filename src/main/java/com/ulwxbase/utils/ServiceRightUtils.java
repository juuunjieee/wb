package com.ulwxbase.utils;

import com.ulwxbase.domain.cus.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class ServiceRightUtils {

	public ServiceRightUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static Boolean decideExport(HttpServletRequest request) {
		
     	String url=request.getRequestURL().toString();
		Integer serviceRight=1000;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute(CbConstants.SessionKey.USER);
		Map<Integer,List<String>>  serviceRightList=userInfo.getServiceRightMap();
		//1取用户
		List<String> exportList=serviceRightList.get(serviceRight);
		boolean flag=false;
		if(exportList!=null) {
			for(String exportStr:exportList) {
				if(url.contains(exportStr)) {
					flag=true;
					break;
				}
				
			}
		}
		return flag;
		
	}

}
