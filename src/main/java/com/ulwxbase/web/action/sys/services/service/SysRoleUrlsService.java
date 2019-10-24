package com.ulwxbase.web.action.sys.services.service;

import com.ulwx.database.MDataBase;
import com.ulwx.database.MDbManager;
import com.ulwx.tool.PageBean;
import com.ulwxbase.domain.db.sys.SysRole;
import com.ulwxbase.domain.db.sys.SysRoleUrls;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.web.action.sys.domain.SysRoleUrlsVo;
import com.ulwxbase.web.action.sys.services.dao.sys.SysRoleUrlsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SysRoleUrlsService {
	static Logger log = LoggerFactory.getLogger(SysRoleUrlsService.class);
	public static SysRoleUrlsService instance = new SysRoleUrlsService();

	
	//根据roleId获取URL -分页
	public List<SysRoleUrlsVo> getSysRoleUrlsList(String roleId,int pageNum,int perPage, PageBean pb) throws Exception{
		return SysRoleUrlsDao.getSysRoleUrlsList(roleId,pageNum, perPage, pb);
	}
	
	//根据roleId获取URL
	public List<SysRoleUrlsVo> getSysRoleUrlsList(String roleId) throws Exception{
		return SysRoleUrlsDao.getSysRoleUrlsList(roleId);
	}
	
	//新增角色URL
	public void addRoleUrls(SysRoleUrls rUrls) throws Exception {
		MDataBase mdb = MDbManager.getDataBase(CbDao.sys);
		SysRoleUrlsDao.addRoleUrls(mdb, rUrls);
	}
	
	//删除角色菜单
	public void delRoleUrlsById(String id) throws Exception {
		MDataBase mdb = null;
		try {
			mdb = MDbManager.getDataBase(CbDao.sys);
			mdb.setAutoCommit(false);
			SysRoleUrlsDao.delRoleUrlsById(mdb,id);
			mdb.commit();
		} catch (Exception e) {
			if(mdb!=null) {
			mdb.rollback();
			}
			throw e;	
		} finally {
			if(mdb!=null) {
			mdb.close();
			}
		}
	}
	
	//修改
	public void updateRoleUrlsById(SysRoleUrls urls) throws Exception {
		MDataBase mdb = null;
		try {
			mdb = MDbManager.getDataBase(CbDao.sys);
			mdb.setAutoCommit(false);
			SysRoleUrlsDao.updateRoleUrlsById(mdb,urls);
			mdb.commit();
		} catch (Exception e) {
			mdb.rollback();
			throw e;	
		} finally {
			if(mdb!=null)
			mdb.close();
		}
	}
	
	//角色
	public List<SysRole> getRoleList(String roleId) throws Exception{
		return SysRoleUrlsDao.getRoleList(roleId);
	}
	
}
