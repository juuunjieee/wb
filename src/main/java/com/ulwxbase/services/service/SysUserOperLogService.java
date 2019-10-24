package com.ulwxbase.services.service;

import com.ulwxbase.domain.db.sys.SysUserOperLog;
import com.ulwxbase.services.dao.SysUserOperLogDao;
import org.apache.log4j.Logger;

/**
 * 用户操作日志 service
 * @author lenovo
 *
 */
public class SysUserOperLogService {
	Logger logger=Logger.getLogger(SysUserOperLogService.class);
	
	public static SysUserOperLogService instance=new SysUserOperLogService();
	
	/**
	 * 插入用户操作记录
	 * @param obj
	 * @throws Exception
	 */
	public void insertUserOper(SysUserOperLog obj)throws Exception {
		try {
			SysUserOperLogDao.insertOper(obj);
		}catch(Exception e) {
			logger.error("",e);
			throw new Exception("#######################ERROR##########UserOperLogService插入用户操作日志异常");
			
		}
		
	};
	
	
	
	
}
