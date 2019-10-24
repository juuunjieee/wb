package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysUsersLock;
import com.ulwxbase.utils.CbDao;

import java.util.HashMap;
import java.util.Map;

public class SysUsersLockDao {

	public static SysUsersLock getUsersLockInfo(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("userId", userId);
		SysUsersLock  obj=MDbUtils.queryOne(CbDao.sys, SysUsersLock.class, CbDao.md(SysUsersLockDao.class, "getUsersLock"), params);
		return obj;
	}

	public static void updateUsersLock(SysUsersLock objLock) throws Exception {
		// TODO Auto-generated method stub
		MDbUtils.update(CbDao.sys, objLock, "SysUserId");
	}

	public static void insertUsersLock(SysUsersLock objLock) throws Exception {
		// TODO Auto-generated method stub
		MDbUtils.insert(CbDao.sys, objLock);
	}

}
