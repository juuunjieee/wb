package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.database.MDataBase;
import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysUserRole;
import com.ulwxbase.utils.CbDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SysUserRoleDao {

	public static List<SysUserRole> getRoles(Integer userId) throws Exception{
		SysUserRole sur=new SysUserRole();
		sur.setSysUserId(userId);
		
		return MDbUtils.query(CbDao.sys, sur);
	};
	
	
	public static List<SysUserRole> getAllRoles() throws Exception{
		SysUserRole sur=new SysUserRole();
		return MDbUtils.query(CbDao.sys, sur);
	};
	
	
	public static void insert(MDataBase mdb,Integer userId,Integer[] sysRoleIs,
			String updator)throws Exception {
		List<SysUserRole> list=new ArrayList<>();
		for(Integer id:sysRoleIs) {
			SysUserRole sur=new SysUserRole();
			sur.setSysUserId(userId);
			sur.setSysRoleId(id);
			sur.setUpdateTime(LocalDateTime.now());
			sur.setUpdator(updator);
			list.add(sur);
		}
		
		mdb.insert(list.toArray(new SysUserRole[0]));
		
	}
	
	public static void del(MDataBase mdb,Integer userId) throws Exception{
		SysUserRole su=new SysUserRole();
		su.setSysUserId(userId);
		mdb.del(su, "sysUserId");
	}
}
