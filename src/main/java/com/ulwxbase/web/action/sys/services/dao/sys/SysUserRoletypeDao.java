package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.database.MDataBase;
import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysUserRoletype;
import com.ulwxbase.utils.CbDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SysUserRoletypeDao {
	public static List<SysUserRoletype> getRoletypes(Integer userId) throws Exception{
		SysUserRoletype sur=new SysUserRoletype();
		sur.setSysUserId(userId);
		
		return MDbUtils.query(CbDao.sys, sur);
	};
	
	public static void insert(MDataBase mdb,Integer userId,Integer[] sys_roletype_codes,
			String updator)throws Exception {
		List<SysUserRoletype> list=new ArrayList<>();
		for(Integer code:sys_roletype_codes) {
			SysUserRoletype sur=new SysUserRoletype();
			sur.setSysUserId(userId);
			sur.setSysRoletypeCode(code);
			sur.setUpdateTime(LocalDateTime.now());
			sur.setUpdator(updator);
			list.add(sur);
		}
		
		mdb.insert(list.toArray(new SysUserRoletype[0]));
		
	}
	
	public static void del(MDataBase mdb,Integer userId) throws Exception{
		SysUserRoletype su=new SysUserRoletype();
		su.setSysUserId(userId);
		mdb.del(su, "sysUserId");
	}
}
