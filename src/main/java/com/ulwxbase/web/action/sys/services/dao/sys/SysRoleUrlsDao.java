package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.database.MDataBase;
import com.ulwx.tool.MDbUtils;
import com.ulwx.tool.PageBean;
import com.ulwxbase.domain.db.sys.SysRole;
import com.ulwxbase.domain.db.sys.SysRoleUrls;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.web.action.sys.domain.SysRoleUrlsVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysRoleUrlsDao {

	//根据角色ID获取URL - 分页
	public static List<SysRoleUrlsVo> getSysRoleUrlsList(String roleId,  Integer pageNum, Integer pageSize,PageBean pb) throws Exception {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("roleId", roleId);

		List<SysRoleUrlsVo> list = MDbUtils.query(CbDao.sys, SysRoleUrlsVo.class,
				CbDao.md(SysRoleUrlsDao.class, "getSysRoleUrlsList"), args, pageNum, pageSize, pb, null);
		return list;
	}
	
	//根据角色ID获取URL
	public static List<SysRoleUrlsVo> getSysRoleUrlsList(String roleId) throws Exception {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("roleId", roleId);

		List<SysRoleUrlsVo> list = MDbUtils.query(CbDao.sys, SysRoleUrlsVo.class,
				CbDao.md(SysRoleUrlsDao.class, "getSysRoleUrlsList"), args);
		return list;
	}
	
	
	//新增
	public static int addRoleUrls(MDataBase mdb,SysRoleUrls rUrls) throws Exception {
		return mdb.insert(rUrls);
	}
	
	//删除
	public static int delRoleUrlsById(MDataBase mdb,String id) throws Exception {
		SysRoleUrls u = new SysRoleUrls();
		u.setId(Integer.parseInt(id));
		return mdb.del(u, "id");
	}
	
	//修改
	public static int updateRoleUrlsById(MDataBase mdb,SysRoleUrls urls) throws Exception {
		return mdb.update(urls, "id");
	}
	
	//角色
	public static List<SysRole> getRoleList(String roleId) throws Exception{
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("roleId", roleId);
		List<SysRole> list = MDbUtils.query(CbDao.sys, SysRole.class,
				CbDao.md(SysRoleUrlsDao.class, "getRoleList"), args);
		return list;
	}


}
