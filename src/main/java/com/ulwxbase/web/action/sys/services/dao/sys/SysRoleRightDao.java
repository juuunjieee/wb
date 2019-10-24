package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.tool.ArrayUtils;
import com.ulwx.tool.MDbUtils;
import com.ulwxbase.domain.db.sys.SysRight;
import com.ulwxbase.utils.CbDao;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysRoleRightDao {

	private static Logger log = Logger.getLogger(SysRoleRightDao.class);

	public static List<SysRight> getRightByRoles(Integer[] roles) {


		try {
			
			if(ArrayUtils.isEmpty(roles)){
				 return new ArrayList<SysRight>();
			}
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("roles", roles);

			List<SysRight> list = MDbUtils.query(CbDao.sys, SysRight.class,
					CbDao.md(SysRoleRightDao.class, "getRightByRoles")
					
					, args);
			return list;
		} catch (Exception e) {
			log.error("", e);
		}
		return new ArrayList<SysRight>();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
