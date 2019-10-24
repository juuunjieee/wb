package com.ulwxbase.services.dao;

import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysSms;
import com.ulwxbase.utils.CbDao;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信查询验证码
 * @author lenovo
 *
 */
public class SmsDao {
	/**
	 * 5分钟短信验证
	 * @return
	 * @throws Exception 
	 */
	public static SysSms getSmsInfo(String mobile) throws Exception {
		//TODO
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("mobile",mobile);
		SysSms jsms=MDbUtils.queryOne(CbDao.sys,SysSms.class, CbDao.md(SmsDao.class, "getSmsInfo"), params);
		return jsms;
	}
	
	/**
	 * 短信验证密码修改短信
	 * @return
	 * @throws Exception 
	 */
	public static SysSms getSmsInfoRecent(String mobile) throws Exception {
		//TODO
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("mobile",mobile);
		SysSms jsms=MDbUtils.queryOne(CbDao.sys,SysSms.class, CbDao.md(SmsDao.class, "getSmsRecent"), params);
		return jsms;
	}
}
