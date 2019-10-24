package com.ulwxbase.web.action.sys.services.dao.sys;

import com.ulwx.database.MDataBase;
import com.ulwx.tool.MDbUtils;
import com.ulwx.tool.PageBean;
import com.ulwx.type.TInteger;
import com.ulwxbase.domain.db.sys.SysUser;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.web.action.sys.domain.AdminUserInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysUserDao {
	public static void changePassword(Integer userId,String pass) throws Exception {
		SysUser user=new SysUser();
		user.setSysUserSno(userId);
		user.setPassword(pass);
		
		MDbUtils.update(CbDao.sys, user, "sysUserSno");
		
		 
	}
	
	public static int addUser(MDataBase mdb,SysUser user) throws Exception{
		
		return (int)mdb.insertReturnKey(user);
		
	}
	
	public static void delUser(MDataBase mdb,SysUser user) throws Exception{
		
		 mdb.del(user, "sysUserSno");
		
	}
	
	
	public static int editUser(MDataBase mdb,SysUser user) throws Exception{
		
		return mdb.update(user, "sysUserSno");
		
	}
	
	public static SysUser getUser(String account)throws Exception{
		SysUser user=new SysUser();
		user.setAccount(account);
		return MDbUtils.queryOne(CbDao.sys, user, "account");
	}
	
	public static SysUser getAccountUser(String account)throws Exception{
		SysUser user=new SysUser();
		user.setAccount(account);
		user.setEnable(1);
		return MDbUtils.queryOne(CbDao.sys, user, "account,enable");
	}
	
	public static List<AdminUserInfo> getUserList(String userName, String userPhone, int page, int perPage,PageBean pb)throws Exception{
		Map<String ,Object> arg=new HashMap<>();
		arg.put("userName", userName);
		arg.put("userPhone", userPhone);
		return MDbUtils.query(CbDao.sys, AdminUserInfo.class, CbDao.md(SysUserDao.class, "getUserList"), arg, page, perPage, pb, null);
	}
	/**
	 * 通过手机号获取用户信息
	 * @param userPhone
	 * @return
	 * @throws Exception 
	 */
	public static SysUser getUserByPhone(String userPhone) throws Exception {
		// TODO Auto-generated method stub
		Map<String ,Object> arg=new HashMap<>();
		arg.put("userPhone", userPhone);
		return MDbUtils.queryOne(CbDao.sys, AdminUserInfo.class, CbDao.md(SysUserDao.class, "getUserList"),arg);

	}
	
	/**
	 * 通过用户账户和id查询
	 * @param userPhone
	 * @return
	 * @throws Exception
	 */
	public static TInteger getUserInfo(String account,int userId) throws Exception {
		// TODO Auto-generated method stub
		Map<String ,Object> arg=new HashMap<>();
		arg.put("account", account);
		arg.put("userId", userId);
		return MDbUtils.queryOne(CbDao.sys, TInteger.class, CbDao.md(SysUserDao.class, "getUserInfo"),arg);

	}
	/**
	 * 修改所有符合条件的用户
	 * @param password
	 * @param string 
	 * @throws Exception 
	 */
	public static void changeAllPassword(String userPhone,String password) throws Exception {
		// TODO Auto-generated method stub
		Map<String ,Object> arg=new HashMap<>();
		arg.put("userPhone", userPhone);
		arg.put("password", password);
	    MDbUtils.update(CbDao.sys, CbDao.md(SysUserDao.class, "changeAllPassword"), arg);

	}

	public static void updatePassword(String newPassword, int sysUserId, MDataBase mdb) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<>();
		params.put("password", newPassword);
		params.put("sysUserId", sysUserId);
		mdb.update(CbDao.md(SysUserDao.class, "updatePassword"), params);
	}

	public static void updateUserNameMobile(String realname, String mobile, int sysUserId, MDataBase mdb) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<>();
		params.put("realname", realname);
		params.put("mobile", mobile);
		params.put("sysUserId", sysUserId);
		mdb.update(CbDao.md(SysUserDao.class, "updateUserNameMobile"), params);
	}
	
	public static SysUser getUserById(Integer sysUserId)throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("sysUserId", sysUserId);
		return MDbUtils.queryOne(CbDao.sys, SysUser.class, CbDao.md(SysUserDao.class, "getUserById"), params);
	}
}
