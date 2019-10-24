package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysRoletype;
import com.ulwxbase.utils.CbDao;

import java.util.List;

public class SysRoletypeDao {

	public static List<SysRoletype> getAllRoles()throws Exception{
		return MDbUtils.query(CbDao.sys, new SysRoletype());
	}
	
	

}
