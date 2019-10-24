package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.database.MDataBase;
import com.ulwx.tool.MDbUtils;
import com.ulwx.tool.PageBean;
import com.ulwx.type.TInteger;
import com.ulwxbase.domain.db.sys.*;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.web.action.sys.domain.SysPagesAdminVo;
import com.ulwxbase.web.action.sys.domain.SysPagesVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysPagesDao {

	public static List<SysPagesVo> getPageList(String pageName,int pageNum, int perPage ,PageBean pb) throws Exception{
		Map<String ,Object> arg = new HashMap<String,Object>();
		arg.put("pageName", pageName);
		
		return MDbUtils.query(CbDao.sys, SysPagesVo.class, CbDao.md(SysPagesDao.class, "getPageList"), arg, pageNum, perPage, pb, null);
	}
	
	public static int AddPage(MDataBase mdb, SysPages page) throws Exception {
		return mdb.insert(page);
	}
	
	public static int updatePage(MDataBase mdb, SysPages page) throws Exception {
		return mdb.update(page, "id");
	}
	
	public static List<SysPagesAdminVo> getPageAdminList(String name,int pageNum, int perPage ,PageBean pb) throws Exception{
		Map<String ,Object> arg = new HashMap<String,Object>();
		arg.put("name", name);
		
		return MDbUtils.query(CbDao.sys, SysPagesAdminVo.class, CbDao.md(SysPagesDao.class, "getPageAdminList"), arg, pageNum, perPage, pb, null);
	}
	
	public static List<SysUser> getSysload() throws Exception{
		Map<String ,Object> arg = new HashMap<String,Object>();
		return MDbUtils.query(CbDao.sys, SysUser.class, CbDao.md(SysPagesDao.class, "getSysload"), arg,null);
	}
	

	
	public static List<SysPages> getloadPageName() throws Exception{
		Map<String ,Object> arg = new HashMap<String,Object>();
		return MDbUtils.query(CbDao.sys, SysPages.class, CbDao.md(SysPagesDao.class, "getloadPageName"), arg,null);
	}
	
	public static List<SysServiceRight> getloadRightName() throws Exception{
		Map<String ,Object> arg = new HashMap<String,Object>();
		return MDbUtils.query(CbDao.sys, SysServiceRight.class, CbDao.md(SysPagesDao.class, "getloadRightName"), arg,null);
	}
	
	public static int addPageServiceRight(MDataBase mdb, SysPagesServiceRight right) throws Exception {
		return (int) mdb.insertReturnKey(right);
	}
	
	public static int addPageServiceRightUser(MDataBase mdb, SysPagesServiceRightUser rightUser) throws Exception {
		return mdb.insert(rightUser);
	}
	
	public static TInteger countUserById(int userId,int pageId,int rightCode) throws Exception {
		Map<String ,Object> arg = new HashMap<String,Object>();
		arg.put("userId", userId);
		arg.put("pageId", pageId);
		arg.put("rightCode", rightCode);
		return MDbUtils.queryOne(CbDao.sys, TInteger.class, CbDao.md(SysPagesDao.class, "countUserById"), arg);
	}
	
	public static TInteger getRight(int pageId,int rightCode) throws Exception {
		Map<String ,Object> arg = new HashMap<String,Object>();
		arg.put("pageId", pageId);
		arg.put("rightCode", rightCode);
		return MDbUtils.queryOne(CbDao.sys, TInteger.class, CbDao.md(SysPagesDao.class, "getRight"), arg);
	}
	
	public static int deleteServiceRightUser(MDataBase mdb, SysPagesServiceRightUser serviceRightUser) throws Exception {
		return mdb.del(serviceRightUser, "id");
	}
}
