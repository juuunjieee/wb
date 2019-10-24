package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysPages;
import com.ulwxbase.domain.db.sys.SysServiceRight;
import com.ulwxbase.utils.CbDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 系统用户按钮权限dao
 * @author lenovo
 *
 */
public class SysServiceDao {

	public static List<SysServiceRight> getSysServiceRightList() throws Exception {
		// TODO Auto-generated method stub
		return MDbUtils.doQueryClass(CbDao.sys, SysServiceRight.class, CbDao.md(SysServiceDao.class, "getSysServiceRightList"),null);
	}

	public static List<SysPages> getSysPagesList(Integer userNo, Integer serviceType) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("userNo", userNo);
		params.put("serviceType", serviceType);
		return MDbUtils.doQueryClass(CbDao.sys, SysPages.class, CbDao.md(SysServiceDao.class, "getSysPagesList"), params);
	}
	
}
