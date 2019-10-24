package com.ulwxbase.filter;

import com.ulwx.filter.AccessBean;
import com.ulwx.filter.AccessFilter;
import com.ulwx.filter.AccessPlugin;
import com.ulwx.tool.StringUtils;
import com.ulwx.type.TInteger;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.services.service.SysUsersSessionService;
import com.ulwxbase.utils.CbConstants;
import com.ulwxbase.utils.CbIPAddressUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class SessionFilter implements AccessPlugin {
	Logger log=Logger.getLogger(SessionFilter.class);
	@Override
	public AccessBean doVerify(HttpServletRequest hreq, HttpServletResponse hres,AccessFilter filter) {
		// TODO Auto-generated method stub
		HttpSession session=hreq.getSession();
		UserInfo userInfo=(UserInfo) session.getAttribute(CbConstants.SessionKey.USER);
		String USER_ANALOGLANDING=(String)session.getAttribute(CbConstants.SessionKey.USER_ANALOGLANDING);
		AccessBean aceBean=new AccessBean();
		aceBean.setIsExit(1);
		try {
			if(!StringUtils.isEmpty(USER_ANALOGLANDING) && USER_ANALOGLANDING.equals("true")) {
				aceBean.setErrorCode(0);
				aceBean.setMessage("成功");
				aceBean.setStatus(1);
			}else {
			TInteger currentMinuteSession=SysUsersSessionService.instance.countAllUsersSession();
				if(currentMinuteSession.getValue()>50) {
					Integer[] currentRole=userInfo.getRoleTypes();
					if(useList(currentRole,3)) {//判断是否有领导角色，true是 ，false不是
						
					}else {//非领导
						aceBean.setErrorCode(0);
						aceBean.setMessage("资源正在加载中,请等待");
						aceBean.setStatus(0);
						return aceBean;
					}
				}
				String sessionId=hreq.getSession().getId();
				String ipaddress=CbIPAddressUtil.getRemoteAddr(hreq);
				log.error("filter"+sessionId);
				if(!StringUtils.isEmpty(sessionId) && !StringUtils.isEmpty(ipaddress)) {
					
						TInteger count=SysUsersSessionService.instance.countUsersSession(userInfo.getUser().getSysUserSno().toString(), sessionId, ipaddress);
						if(count.getValue()==0) {
							aceBean.setErrorCode(0);
							aceBean.setMessage("您已经在其它地方登录，请重新登录！");
							aceBean.setStatus(0);
						}else {
							aceBean.setErrorCode(0);
							aceBean.setMessage("");
							aceBean.setStatus(1);
						}
				}else {
					aceBean.setErrorCode(0);
					aceBean.setMessage("成功");
					aceBean.setStatus(1);
				}
			  } 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				log.error("",e);
				aceBean.setErrorCode(0);
				aceBean.setMessage("您已经在其它地方登录，请重新登录！");
				aceBean.setStatus(0);
			}
		return aceBean;
	}
	
	private static boolean useList(Object[] arr, Object targetValue) {
	    return Arrays.asList(arr).contains(targetValue);
	}
	
	
	public static void main(String[] args) {
		Integer[] intArray= {1,2,3,4,5,6};
		System.out.println(useList(intArray,7));
	}
	
}
