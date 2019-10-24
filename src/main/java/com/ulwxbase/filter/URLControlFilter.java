package com.ulwxbase.filter;

import com.ulwx.filter.AccessBean;
import com.ulwx.filter.AccessFilter;
import com.ulwx.filter.AccessPlugin;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.domain.db.sys.SysRight;
import com.ulwxbase.utils.CbConstants;
import com.ulwxbase.web.action.sys.services.dao.sys.SysRightDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class URLControlFilter implements AccessPlugin{
	Logger log=Logger.getLogger(URLControlFilter.class);
	@Override
	public AccessBean doVerify(HttpServletRequest hreq, HttpServletResponse hres,AccessFilter filter) {
		// TODO Auto-generated method stub
		HttpSession session=hreq.getSession();
		UserInfo userInfo=(UserInfo) session.getAttribute(CbConstants.SessionKey.USER);
		AccessBean aceBean=new AccessBean();
		String ruri=hreq.getRequestURI();
		String rur3=hreq.getContextPath();
		String sysRightURL=ruri.replaceFirst(rur3+"/", "");
		try {
			int count =SysRightDao.getDataCountByUrl(sysRightURL);
			if(count==0) {//不存在菜单列表中
				aceBean.setErrorCode(0);
				aceBean.setMessage("");
				aceBean.setStatus(1);
			}else {//存在菜单列表中
				//1.获取角色的SysRight，并判断角色菜单中是否包含本列表
				List<SysRight> sysRightList=userInfo.getRights();
				List<String> urlSet=new ArrayList<String>(); 
				for(SysRight sysRight:sysRightList) {
					urlSet.add(sysRight.getSysRightUrl());
				}
				if(urlSet.contains(sysRightURL)) {//包含
					aceBean.setErrorCode(0);
					aceBean.setMessage("");
					aceBean.setStatus(1);
				}else {//不包含
					aceBean.setErrorCode(0);
					aceBean.setMessage("越权访问,您没有访问当前页面的权限");
					aceBean.setStatus(0);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("",e);
			aceBean.setErrorCode(0);
			aceBean.setMessage("越权访问,您没有访问当前页面的权限");
			aceBean.setStatus(0);
		}
		return aceBean;
	}
	
    
	
}
