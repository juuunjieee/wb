package com.ulwxbase.web.action.sys.services.service;
/**
 * 用户登陆锁定信息
 * @author lenovo
 *
 */

import com.ulwxbase.domain.db.sys.SysUsersLock;
import com.ulwxbase.web.action.sys.services.dao.sys.SysUsersLockDao;
import org.apache.log4j.Logger;

public class SysUsersLockService {
	Logger logger=Logger.getLogger(SysUsersLockService.class);
	
	public static SysUsersLockService instance=new SysUsersLockService();
	
	public SysUsersLock  getSysUsersLockInfo(Integer userId) throws Exception {
		try {
			return SysUsersLockDao.getUsersLockInfo(userId);
		}catch(Exception e) {
			logger.error("",e);
			throw new Exception("**********ERROR*******SysUsersLockService的获取登陆锁定信息异常******"+e.getMessage());
		}
		
	}

	public void updateUsersLock(SysUsersLock objLock) throws Exception {
		// TODO Auto-generated method stub
		try {
		    SysUsersLockDao.updateUsersLock(objLock);
		}catch(Exception e) {
			logger.error("",e);
			throw new Exception("**********ERROR*******SysUsersLockService的获取更新锁定信息异常******"+e.getMessage());
		}
	}

	public void insertUsersLock(SysUsersLock objLock) throws Exception {
		// TODO Auto-generated method stub
		try {
		    SysUsersLockDao.insertUsersLock(objLock);
		}catch(Exception e) {
			logger.error("",e);
			throw new Exception("**********ERROR*******SysUsersLockService的获取插入锁定信息异常******"+e.getMessage());
		}
	}
}
