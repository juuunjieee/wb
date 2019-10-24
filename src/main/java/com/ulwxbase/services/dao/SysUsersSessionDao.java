package com.ulwxbase.services.dao;

import com.ulwx.tool.MDbUtils;
import com.ulwx.type.TInteger;
import com.ulwxbase.domain.db.sys.SysUsersSession;
import com.ulwxbase.utils.CbDao;

import java.util.HashMap;
import java.util.Map;

public class SysUsersSessionDao {
	
	
	public static TInteger countUsersSession(String userId, String sessionId, String loginIp) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("sessionId", sessionId);
		params.put("loginIp", loginIp);
		return MDbUtils.queryOne(CbDao.sys, TInteger.class, CbDao.md(SysUsersSessionDao.class, "countUsersSession"), params);
	}

	public static SysUsersSession getUsersSession(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("userId", userId);
		return MDbUtils.queryOne(CbDao.sys, SysUsersSession.class, CbDao.md(SysUsersSessionDao.class, "getUsersSession"), params);
	}

	public static void updateUsersSession(SysUsersSession mySession) throws Exception {
		// TODO Auto-generated method stub
		MDbUtils.update(CbDao.sys, mySession, "SysUserId");
	}

	public static void insertUsersSession(SysUsersSession juSession) throws Exception {
		// TODO Auto-generated method stub
		MDbUtils.insert(CbDao.sys, juSession);
	}
	/**
	 * 获取当前session一分钟内的登陆数资源
	 * @return
	 * @throws Exception 
	 */
	public static TInteger countAllUsersSession() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		return MDbUtils.queryOne(CbDao.sys, TInteger.class, CbDao.md(SysUsersSessionDao.class, "countCurrentOneMiniteSession"), params);
	}

}
