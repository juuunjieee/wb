package com.yscf.admin.services.dao.yscfmdb;


import com.ulwx.tool.MDbUtils;
import com.yscf.admin.domain.db.yscfmdb.SlFinanceDepartUser;
import com.yscf.admin.utils.Dao;

public class SlFinanceDepartUserDao {

	public SlFinanceDepartUserDao() {
		// TODO Auto-generated constructor stub
	}
	public static SlFinanceDepartUser getOnjobUserBy(Integer sysUserId) throws Exception{
		SlFinanceDepartUser jfu=new SlFinanceDepartUser();
		jfu.setSysUserId(sysUserId);
		jfu.setStatus(1);
		
		return MDbUtils.queryOne(Dao.yscfmdb, jfu);
	}
}
