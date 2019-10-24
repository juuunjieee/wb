package com.ulwxbase.services.service;

import com.ulwx.type.TInteger;
import com.ulwxbase.domain.db.sys.SysUsersSession;
import com.ulwxbase.services.dao.SysUsersSessionDao;
import org.apache.log4j.Logger;

/**
 * 用户session服务service
 * @author lenovo
 *
 */
public class SysUsersSessionService {
	Logger log=Logger.getLogger(SysUsersSessionService.class);
	public static SysUsersSessionService instance=new SysUsersSessionService();
	
	public TInteger countUsersSession(String userId,String sessionId,String loginIp) throws Exception {
		//TODO
		try {
			return SysUsersSessionDao.countUsersSession(userId,sessionId,loginIp);
		}catch(Exception e){
			log.error("",e);
			throw new Exception("***************SysUserSessionService的countUsersSession获取符合条件个数异常"+e.getMessage());
		}
		
	}
	/**
	 * 通过userId获取session信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public SysUsersSession getUsersSession(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		try {
			return SysUsersSessionDao.getUsersSession(userId);
		}catch(Exception e){
			log.error("",e);
			throw new Exception("***************SysUserSessionService的getUsersSession获取session信息异常"+e.getMessage());
		}
	}
	/**
	 * 更新jusersSession信息
	 * @param mySession
	 * @throws Exception
	 */
	public void updateUsersSession(SysUsersSession mySession) throws Exception {
		// TODO Auto-generated method stub
		try {
			 SysUsersSessionDao.updateUsersSession(mySession);
		}catch(Exception e){
			log.error("",e);
			throw new Exception("***************SysUserSessionService的updateUsersSession更新session信息异常"+e.getMessage());
		}
	}
	/**
	 * 插入jusersSession信息
	 * @param juSession
	 * @throws Exception 
	 */
	public void insertUsersSession(SysUsersSession juSession) throws Exception {
		// TODO Auto-generated method stub
		try {
			 SysUsersSessionDao.insertUsersSession(juSession);
		}catch(Exception e){
			log.error("",e);
			throw new Exception("***************SysUserSessionService的updateUsersSession更新insertUsersSession信息异常"+e.getMessage());
		}
	}
	
	/**
	 * 获取当前一分钟内再先的session数
	 * @param 
	 * @param sessionId
	 * @param loginIp
	 * @return
	 * @throws Exception
	 */
	public TInteger countAllUsersSession() throws Exception {
		//TODO
		try {
			return SysUsersSessionDao.countAllUsersSession();
		}catch(Exception e){
			log.error("",e);
			throw new Exception("***************SysUserSessionService的countAllUsersSession获取符合条件个数异常"+e.getMessage());
		}
		
	}
	
}
