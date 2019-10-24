package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.database.DataBaseSet;
import com.ulwx.database.DbException;
import com.ulwx.database.MDataBase;
import com.ulwx.database.MDbManager;
import com.ulwx.tool.MDbUtils;
import com.ulwx.tool.PageBean;
import com.ulwx.type.TInteger;
import com.ulwxbase.domain.cus.CbEasyUICombobox;
import com.ulwxbase.domain.cus.CbEasyUIGridModel;
import com.ulwxbase.domain.db.sys.SysRole;
import com.ulwxbase.domain.db.sys.SysRoleRight;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.web.action.sys.domain.SysRoleInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysRoleDao {

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-11-8 @param sysRightCode
	 * @param sysRoleTypeCode
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static List<SysRoleInfo> getData(String RoleName,  Integer pageNum, Integer pageSize,
			CbEasyUIGridModel<SysRoleInfo> model) throws Exception {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("roleName", RoleName);

		PageBean pb = new PageBean();
		List<SysRoleInfo> list = MDbUtils.query(CbDao.sys, SysRoleInfo.class,
				CbDao.md(SysRoleDao.class, "getData"), args, pageNum, pageSize, pb, null);
		model.setRows(list);
		model.setTotal(pb.getTotal());
		return list;
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrbb
	 * @创建时间：2011-11-8 @param entity
	 * @return
	 * @throws Exception
	 */
	public static int insertData(SysRole entity, SysRoleRight srr, String[] sysRightArray) throws Exception {

		MDataBase db = null;
		int sysRoleID = 0;
		try {
			db = MDbManager.getDataBase(CbDao.sys);
			db.setAutoCommit(false);
			db.excuteInsertClass(entity);
			DataBaseSet set = db.queryForResultSet(CbDao.md(SysRoleDao.class, "insertData"), null);
			while (set.next())
				sysRoleID = set.getInt("insertRoleID");
			srr.setSysRoleId(sysRoleID);
			for (String right : sysRightArray) {
				srr.setSysRightCode(right);
				db.excuteInsertClass(srr);
			}
			db.commit();
			return sysRoleID;
		} catch (DbException e) {
			db.rollback();
			throw e;
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-10-19
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public static SysRole getOneData(Integer sno) throws Exception {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRoleSno", sno);
		List<SysRole> list = MDbUtils.doQueryClass(CbDao.sys, SysRole.class,
				CbDao.md(SysRoleDao.class, "getOneData"), args);
		if (list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public static List<String> getSysRightByRole(Integer sno) throws Exception {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRoleSno", sno);
		DataBaseSet set = MDbUtils.query(CbDao.sys, CbDao.md(SysRoleDao.class, "getSysRightByRole"),
				args);
		List<String> list = new ArrayList<String>();
		while (set.next()) {
			list.add(set.getString("sysRightCode"));
		}
		return list;
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-10-21
	 * @param entity
	 * @return
	 */
	public static int updateData(SysRole sysRole,  SysRoleRight sysRoleRight, String[] sysRightArray)
			throws Exception {

		MDataBase db = null;
		try {

			db = MDbManager.getDataBase(CbDao.sys);
			db.setAutoCommit(false);
			int row = db.update(sysRole, "sysRoleSno");
			db.del(sysRoleRight, "sysRoleId");
			for (String sysRight : sysRightArray) {
				sysRoleRight.setSysRightCode(sysRight);
				db.insert(sysRoleRight);
			}
			db.commit();
			return row;
		} catch (Exception ex) {
			db.rollback();
			throw ex;
		} finally {
			if (db != null)
				db.close();
		}
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-10-21
	 * @param entity
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public static int DeleteData(SysRole entity, String deleteProperteis) throws Exception {
		MDataBase db = null;
		try {

			db = MDbManager.getDataBase(CbDao.sys);
			db.setAutoCommit(false);
			SysRoleRight srr = new SysRoleRight();
			srr.setSysRoleId(entity.getSysRoleSno());
			db.del(srr, "SysRoleId");
			int row = db.del(entity, deleteProperteis);
			db.commit();
			return row;
		} catch (DbException ex) {
			db.rollback();
			throw ex;
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}



	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-11-10
	 * @param mainRightID
	 * @return
	 * @throws Exception
	 */
	public static List<CbEasyUICombobox> getSysRight(String mainRightID) throws Exception {

		Map<String, Object> args = new HashMap<String, Object>();

		args.put("sysRightCode", mainRightID);
		args.put("sysRightCode2", mainRightID.substring(0, 2));
		args.put("sysRightCode", "000");

		DataBaseSet set = MDbUtils.query(CbDao.sys, CbDao.md(SysRoleDao.class, "getSysRight"), args);
		List<CbEasyUICombobox> list = new ArrayList<CbEasyUICombobox>();
		CbEasyUICombobox combo = null;
		while (set.next()) {
			combo = new CbEasyUICombobox();
			combo.setId(set.getString("sys_right_code"));
			combo.setText(set.getString("sys_right_name"));
			list.add(combo);
		}
		return list;
	}



	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-11-10
	 * @param newRoleName
	 * @return
	 * @throws Exception
	 */
	public static List<SysRole> getDataByName(String newRoleName) throws Exception {
		// String sql = "SELECT * FROM SysRole WHERE (1=1)";
		Map<String, Object> args = new HashMap<String, Object>();

		args.put("newRoleName", newRoleName);

		return MDbUtils.query(CbDao.sys, SysRole.class, CbDao.md(SysRoleDao.class, "getDataByName"),
				args);
	}
	
	public static List<SysRole> getAllRoles()throws Exception{
		return MDbUtils.query(CbDao.sys, new SysRole());
	}

	public static TInteger getYdyRoleCount(String[] iDs) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("ids", iDs);
		return MDbUtils.queryOne(CbDao.sys, TInteger.class, CbDao.md(SysRoleDao.class, "getYdyRoleCount"), params);
	}

}
