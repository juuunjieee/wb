package com.ulwxbase.services.dao;

import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysUserOperLog;
import com.ulwxbase.utils.CbDao;

/**
 * 用户操作日志Dao
 * @author lenovo
 *
 */
public class SysUserOperLogDao {
	
	public static void insertOper(SysUserOperLog obj) throws Exception {
		// TODO Auto-generated method stub
		MDbUtils.insert(CbDao.sys, obj);
	}

	
	
}
