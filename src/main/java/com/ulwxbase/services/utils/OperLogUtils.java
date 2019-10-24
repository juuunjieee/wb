package com.ulwxbase.services.utils;

import com.ulwx.tool.IpUtils;
import com.ulwx.tool.ObjectUtils;
import com.ulwx.tool.RequestUtils;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.domain.db.sys.SysUserOperLog;
import com.ulwxbase.services.service.SysUserOperLogService;
import com.ulwxbase.utils.CbConstants;
import com.ulwxbase.utils.CbIPAddressUtil;
import org.apache.log4j.Logger;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 操作日志公用类
 * @author lenovo
 *
 */
public class OperLogUtils {

	public static Logger logger=Logger.getLogger(OperLogUtils.class);
	/**
	 * 更新操作用户日志：用户id,用户名称，ip地址，操作时间,并插入
	 * @param request
	 * @param log
	 * @return
	 * @throws Exception 
	 */
	public static void insertUserOperLogInfo (RequestUtils ru,HttpServletRequest request,SysUserOperLog operLog) throws Exception {
		insertUserOperLogInfo (ru,request,operLog,null);
	}
	
	/**
	 * 更新操作用户日志：用户id,用户名称，ip地址，操作时间,并插入
	 * @param request
	 * @param log
	 * @return
	 * @throws Exception 
	 */
	public static void insertUserOperLogInfo (RequestUtils ru,HttpServletRequest request,SysUserOperLog operLog,UserInfo myuserInfo) throws Exception {
		operLog.setSource(2);
		String mdcLogid=MDC.get("logid");
		String srcIp=IpUtils.getLocalIp();
		operLog.setLogid(mdcLogid);
		operLog.setSrcIp(srcIp);
		Map<String, Object[]> paramsMap=ru.getrParms();
		String reqArgsString=ObjectUtils.toJsonString(paramsMap);
		if(reqArgsString.length()>1000) {
			reqArgsString=reqArgsString.substring(0, 1000);
		}
		operLog.setReqArgs(reqArgsString);
		if(myuserInfo==null) {
			HttpSession session=request.getSession();
			UserInfo userInfo = (UserInfo) session.getAttribute(CbConstants.SessionKey.USER);
			if(userInfo!=null) {
				operLog.setUserId(userInfo.getUser().getSysUserSno());
				operLog.setUserName(userInfo.getUser().getAccount());
				operLog.setOperTime(LocalDateTime.now());
				operLog.setIp(CbIPAddressUtil.getRemoteAddr(request));
			}else {
				operLog.setUserId(0);
				operLog.setUserName("0");
				operLog.setOperTime(LocalDateTime.now());
				operLog.setIp(CbIPAddressUtil.getRemoteAddr(request));
			}
		}else {
			operLog.setUserId(myuserInfo.getUser().getSysUserSno());
			operLog.setUserName(myuserInfo.getUser().getAccount());
			operLog.setOperTime(LocalDateTime.now());
			operLog.setIp(CbIPAddressUtil.getRemoteAddr(request));

		}
		SysUserOperLogService.instance.insertUserOper(operLog);
	}
	
	
	/** 
     * 获取当前网络ip 
     * @param request 
     * @return 
     */  
    public static String getIpAddr(HttpServletRequest request){  
        String ipAddress = request.getHeader("x-forwarded-for");  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getRemoteAddr();  
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                    //根据网卡取本机配置的IP  
                    InetAddress inet=null;  
                    try {  
                        inet = InetAddress.getLocalHost();  
                    } catch (UnknownHostException e) {  
                      logger.error(e,e);  
                    }  
                    ipAddress= inet.getHostAddress();  
                }  
            }  
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
                if(ipAddress.indexOf(",")>0){  
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
                }  
            }  
            return ipAddress;   
    }
}
