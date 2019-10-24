package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.database.DataBaseSet;
import com.ulwx.database.MDataBase;
import com.ulwx.database.MDbManager;
import com.ulwx.tool.MDbUtils;
import com.ulwx.tool.PageBean;
import com.ulwxbase.domain.cus.CbEasyUIGridModel;
import com.ulwxbase.domain.db.sys.SysRight;
import com.ulwxbase.utils.CbDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysRightDao {
	static Logger log = LoggerFactory.getLogger(SysRightDao.class);

	public static List<SysRight> getAllRight() {

		try {
			List<SysRight> list = MDbUtils.query(CbDao.sys, SysRight.class,
					CbDao.md(SysRightDao.class, "getAllRight"), (Map<String,Object>)null);

			return list;
		} catch (Exception e) {
			log.error("", e);
		}
		return new ArrayList<SysRight>();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(NFunction.isNotEmpty("xxxx"));
		getData("", "xxxx", 1, 10, new CbEasyUIGridModel<SysRight>());
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-11-8 @param sysRightCode
	 * @param sysRightName
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static List<SysRight> getData(String sysRightCode, String sysRightName, Integer pageNum, Integer pageSize,
			CbEasyUIGridModel<SysRight> model) throws Exception {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRightCode", sysRightCode);
		args.put("sysRightName", sysRightName);
		PageBean pb = new PageBean();
		List<SysRight> list = MDbUtils.query(CbDao.sys,SysRight.class, CbDao.md(SysRightDao.class, "getData"),
				args, pageNum, pageSize, pb, null);
		model.setRows(list);
		model.setTotal(pb.getTotal());
		return list;
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-11-8 @param entity
	 * @return
	 * @throws Exception
	 */
	public static int insertData(SysRight entity) throws Exception {

		return MDbUtils.insert(CbDao.sys,entity);
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-11-8 @param sysRightCode
	 * @param sysRightName
	 * @return
	 * @throws Exception
	 */
	public static int getDataCount(String sysRightCode, String sysRightName) throws Exception {
		int count = 0;
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRightCode", sysRightCode);
		args.put("sysRightName", sysRightName);
		DataBaseSet set = MDbUtils.query(CbDao.sys,CbDao.md(SysRightDao.class, "getDataCount"), args);
		while (set.next())
			count = set.getInt("dataCount");
		return count;

	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-10-19
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public static SysRight getOneData(String sno) throws Exception {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRightCode", sno);

		List<SysRight> list = MDbUtils.query(CbDao.sys,SysRight.class, CbDao.md(SysRightDao.class, "getOneData"),
				args);
		if (list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-10-21
	 * @param entity
	 * @return
	 */
	public static int updateData(SysRight entity, String beanKey) throws Exception {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRightCode", entity.getSysRightCode());
		args.put("sysRightName", entity.getSysRightName());
		args.put("sysRightUrl", entity.getSysRightUrl());
		args.put("enable", entity.getEnable());
		args.put("updateTime", entity.getUpdateTime());
		args.put("updator", entity.getUpdator());
		args.put("orderCode", entity.getOrderCode());
		args.put("sysRightCode2", beanKey);
		args.put("icon", entity.getIcon());
		return MDbUtils.update(CbDao.sys,CbDao.md(SysRightDao.class, "updateData"), args);
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2011-10-21
	 * @param entity
	 * @param string
	 * @return
	 */
	public static int DeleteData(SysRight entity, String deleteProperteis) throws Exception {

		MDataBase db = null;
		try {
			db = MDbManager.getDataBase(CbDao.sys);
			return db.del(entity, deleteProperteis);
		} catch (Exception ex) {
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
	 * @开发：linrb @创建时间：2012-1-11
	 * @param rightCode
	 * @return
	 * @throws Exception
	 */
	public static String getUrlByRightCode(String rightCode) throws Exception {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRightCode", rightCode.trim());
		MDataBase db = null;
		try {
			db = MDbManager.getDataBase(CbDao.sys);
			DataBaseSet set = db.queryForResultSet(CbDao.md(SysRightDao.class, "getUrlByRightCode"), args);
			while (set.next()) {
				return set.getString("SysRightUrl").trim();
			}
		} finally {
			if (db != null) {
				db.close();
			}
		}
		return null;
	}

	/**
	 * 方法说明:
	 * 
	 * @开发：linrb @创建时间：2012-3-21
	 * @param substring
	 * @return
	 * @throws Exception
	 */
	public static List<SysRight> getRightByCode(String substring) throws Exception {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRightCode", substring);
		MDataBase db = null;
		try {
			db = MDbManager.getDataBase(CbDao.sys);
			return db.query(SysRight.class, CbDao.md(SysRightDao.class, "getRightByCode"), args);
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}
	
	
	/**
	 * 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-11-8 @param sysRightCode
	 * @param sysRightName
	 * @return
	 * @throws Exception
	 */
	public static int getDataCountByUrl(String sysRightUrl) throws Exception {
		int count = 0;
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sysRightUrl", sysRightUrl);
		DataBaseSet set = MDbUtils.query(CbDao.sys,CbDao.md(SysRightDao.class, "getDataCountByUrl"), args);
		while (set.next())
			count = set.getInt("dataCount");
		return count;

	}
}
