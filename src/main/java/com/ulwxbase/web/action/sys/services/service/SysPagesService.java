package com.ulwxbase.web.action.sys.services.service;

import com.ulwx.database.MDataBase;
import com.ulwx.database.MDbManager;
import com.ulwx.tool.PageBean;
import com.ulwx.type.TInteger;
import com.ulwxbase.domain.db.sys.*;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.web.action.sys.domain.SysPagesAdminVo;
import com.ulwxbase.web.action.sys.domain.SysPagesVo;
import com.ulwxbase.web.action.sys.services.dao.sys.SysPagesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class SysPagesService {
	static Logger log = LoggerFactory.getLogger(SysPagesService.class);
	public static SysPagesService instance = new SysPagesService();
	
	public List<SysPagesVo> getPageList(String pageName,int pageNum, int perPage ,PageBean pb) throws Exception{
		return SysPagesDao.getPageList(pageName, pageNum, perPage, pb);
	}
	
	public void AddPage(SysPages page) throws Exception {
		MDataBase mdb = MDbManager.getDataBase(CbDao.sys);
		SysPagesDao.AddPage(mdb, page);
	}
	
	public void updatePage(SysPages page) throws Exception {
		MDataBase mdb = MDbManager.getDataBase(CbDao.sys);
		SysPagesDao.updatePage(mdb, page);
	}
	
	public List<SysPagesAdminVo> getPageAdminList(String name,int pageNum, int perPage ,PageBean pb) throws Exception{
		return SysPagesDao.getPageAdminList(name, pageNum, perPage, pb);
	}
	
	public List<SysUser> getSysload() throws Exception{
		return SysPagesDao.getSysload();
	}
	
	
	public List<SysPages> getloadPageName() throws Exception{
		return SysPagesDao.getloadPageName();
	}
	
	public List<SysServiceRight> getloadRightName() throws Exception{
		return SysPagesDao.getloadRightName();
	}
	
	public int addRigthUser(int pageId,int rightCode,Integer[] names) throws Exception {
		MDataBase mdb = null;
		try {
			mdb = MDbManager.getDataBase(CbDao.sys);
			mdb.setAutoCommit(false);
			
			//根据pageId和rightCode查询sys_pages_service_right表中是否有记录
			TInteger rightId = SysPagesDao.getRight(pageId, rightCode);
			
			if(rightId != null) {//如果有，该表不做重复插入，只操作sys_pages_service_right_user表
				int ServiceRightId = rightId.getValue();
				for(int i=0;i<names.length;i++) {	
					SysPagesServiceRightUser SysUser = new SysPagesServiceRightUser();
					SysUser.setUpdatime(LocalDateTime.now());
					SysUser.setPageServiceRightId(ServiceRightId);
					SysUser.setSysUserId(names[i]);
					SysPagesDao.addPageServiceRightUser(mdb, SysUser);
				}
			}else {//如果没有，则两张表同时插入数据
				SysPagesServiceRight right = new SysPagesServiceRight();
				right.setPageId(pageId);
				right.setServiceRightCode(rightCode);
				right.setUpdatime(LocalDateTime.now());
				int id = SysPagesDao.addPageServiceRight(mdb, right);
				if(id>0) {
					for(int i=0;i<names.length;i++) {
						SysPagesServiceRightUser SysUser = new SysPagesServiceRightUser();
						SysUser.setPageServiceRightId(id);
						SysUser.setSysUserId(names[i]);
						SysUser.setUpdatime(LocalDateTime.now());
						SysPagesDao.addPageServiceRightUser(mdb, SysUser);
					}
					
				}
			}
			
			mdb.commit();
			return 1;
		}catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
			if(mdb != null) {
				mdb.rollback();
			}
		}finally {
			if(mdb != null) {
				mdb.close();
			}
		}
		return 0;
	}
	
	public TInteger countUserById(int userId,int pageId,int rightCode) throws Exception {
		return SysPagesDao.countUserById(userId,pageId,rightCode);
	}
	
	public void deleteServiceRightUser(SysPagesServiceRightUser serviceRightUser) throws Exception {
		MDataBase mdb = MDbManager.getDataBase(CbDao.sys);
		SysPagesDao.deleteServiceRightUser(mdb, serviceRightUser);
	}
}
