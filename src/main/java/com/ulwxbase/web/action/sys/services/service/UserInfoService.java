package com.ulwxbase.web.action.sys.services.service;

import com.ulwx.database.MDataBase;
import com.ulwx.database.MDbManager;
import com.ulwx.tool.ArrayUtils;
import com.ulwx.tool.ObjectUtils;
import com.ulwx.tool.PageBean;
import com.ulwx.tool.StringUtils;
import com.ulwx.type.TBoolean;
import com.ulwx.type.TInteger;
import com.ulwx.type.TString;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.domain.db.sys.*;
import com.ulwxbase.utils.CbAppConfig;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.web.action.sys.domain.AdminUserInfo;
import com.ulwxbase.web.action.sys.services.dao.sys.*;
import com.ulwxbase.web.action.utils.LoginUserInfPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoService {
	static Logger log = LoggerFactory.getLogger(UserInfoService.class);
	public static UserInfoService instance = new UserInfoService();

	public void addUser(AdminUserInfo adminUserInfo) throws Exception {
		MDataBase mdb = null;
		try {
			mdb = MDbManager.getDataBase(CbDao.sys);
			mdb.setAutoCommit(false);
			
			SysUser sysUser=ObjectUtils.fromBeanToBean(SysUser.class, adminUserInfo);
			Integer userId=SysUserDao.addUser(mdb, sysUser);
			
			String roles=adminUserInfo.getSysRoleIds();
			String[] roleIdStrs=roles.split(",");
			Integer[] roleIds=ArrayUtils.StringArrayToIntegerArray(roleIdStrs);
			SysUserRoleDao.insert(mdb, userId, roleIds, adminUserInfo.getUpdator());
			
			
			String roleTypes=adminUserInfo.getSysRoleTypeCodes();
			String[] roleTypesStr=roleTypes.split(",");
			Integer[] roleTypeIds=ArrayUtils.StringArrayToIntegerArray(roleTypesStr);
			SysUserRoletypeDao.insert(mdb, userId, roleTypeIds, adminUserInfo.getUpdator());
			
			mdb.commit();
		} catch (Exception e) {
			if(mdb!=null)
			mdb.rollback();
			throw e;
			
		} finally {
			if(mdb!=null)
			mdb.close();
		}

	}

	public void delUser(AdminUserInfo[]  adminUserInfos) throws Exception {
		MDataBase mdb = null;
		try {
			mdb = MDbManager.getDataBase(CbDao.sys);
			mdb.setAutoCommit(false);
			for(AdminUserInfo adminUserInfo:adminUserInfos) {
				SysUser sysUser=ObjectUtils.fromBeanToBean(SysUser.class, adminUserInfo);
				SysUserDao.delUser(mdb, sysUser);
				Integer userId=adminUserInfo.getSysUserSno();
				SysUserRoleDao.del(mdb, userId);
				SysUserRoletypeDao.del(mdb, userId);
			}
			
			mdb.commit();
		} catch (Exception e) {
			mdb.rollback();
			throw e;
			
		} finally {
			if(mdb!=null)
			mdb.close();
		}

	}
	public void editUser(AdminUserInfo adminUserInfo) throws Exception {
		MDataBase mdb = null;
		try {
			mdb = MDbManager.getDataBase(CbDao.sys);
			mdb.setAutoCommit(false);
			
			SysUser sysUser=ObjectUtils.fromBeanToBean(SysUser.class, adminUserInfo);
			SysUserDao.editUser(mdb, sysUser);
			
			Integer userId=adminUserInfo.getSysUserSno();
			SysUserRoleDao.del(mdb, userId);
			String roles=adminUserInfo.getSysRoleIds();
			String[] roleIdStrs=roles.split(",");
			Integer[] roleIds=ArrayUtils.StringArrayToIntegerArray(roleIdStrs);
			SysUserRoleDao.insert(mdb, userId, roleIds, adminUserInfo.getUpdator());
			
			SysUserRoletypeDao.del(mdb, userId);
			String roleTypes=adminUserInfo.getSysRoleTypeCodes();
			String[] roleTypesStr=roleTypes.split(",");
			Integer[] roleTypeIds=ArrayUtils.StringArrayToIntegerArray(roleTypesStr);
			SysUserRoletypeDao.insert(mdb, userId, roleTypeIds, adminUserInfo.getUpdator());
			
			
			mdb.commit();
		} catch (Exception e) {
			mdb.rollback();
			throw e;
			
		} finally {
			if(mdb!=null)
			mdb.close();
		}

	}
	public UserInfo getUserInfo(String account) throws Exception {
		UserInfo user = new UserInfo();
		try {
			SysUser suser = SysUserDao.getAccountUser(account);
			if(suser==null) {
				return null;
			}
			user.setUser(suser);

			// 角色类型id
			List<SysUserRoletype> listRoletypes = SysUserRoletypeDao.getRoletypes(suser.getSysUserSno());
			Integer[] roleTypeCodes = new Integer[listRoletypes.size()];
			for (int i = 0; i < listRoletypes.size(); i++) {
				roleTypeCodes[i] = listRoletypes.get(i).getSysRoletypeCode();
			}
			user.setRoleTypes(roleTypeCodes);

			// 判断是否为超级管理员
			List<SysUserRole> ls = null;
			if (user.isAdminUser()) {
				//ls = SysUserRoleDao.getAllRoles();
			} else {
				// 取角色id
				ls = SysUserRoleDao.getRoles(suser.getSysUserSno());

			}
			if (ls != null) {
				Integer[] roleIds = new Integer[ls.size()];
				for (int i = 0; i < ls.size(); i++) {
					roleIds[i] = ls.get(i).getSysRoleId();
				}
				user.setRoles(roleIds);

				List<SysRight> rights = SysRoleRightDao.getRightByRoles(user.getRoles());
				user.setRights(rights);
			}else {
				if(user.isAdminUser()) {
					List<SysRight> rights = SysRightDao.getAllRight();
					user.setRights(rights);
				}
			}
			
			//添加导出权限控制功能，放session
			Map<Integer,List<String>> mapList=new HashMap<>();
			//1.获取权限码
			Integer userNo=suser.getSysUserSno();//用户id
			List<SysServiceRight> serviceList= SysServiceDao.getSysServiceRightList();
			for(SysServiceRight rightObj:serviceList) {
				Integer serviceRightCode=rightObj.getRightCode();
				List<SysPages> pagesList=SysServiceDao.getSysPagesList(userNo,serviceRightCode);
				List<String> urlcol=new ArrayList<String>();
				for(SysPages pagesObj:pagesList) {
					urlcol.add(pagesObj.getMatchUrlSuffix());
				}
				mapList.put(serviceRightCode, urlcol);
			}
			user.setServiceRightMap(mapList);
			
			String userInfoPlugin=CbAppConfig.getLoginUserInfPlugin();
			if(StringUtils.hasText(userInfoPlugin)) {
				LoginUserInfPlugin<?> plugin=(LoginUserInfPlugin<?>)Class.forName(userInfoPlugin).newInstance();
				TBoolean tValidate=new TBoolean(false);
				TString tValidateMsg=new TString();
				Object ret=plugin.contruct(user.getUser(),user.getRoleTypes(),user.getRoles(),tValidate,tValidateMsg);
				if(!tValidate.getValue().booleanValue()) {
					throw new Exception(tValidateMsg.getValue());
				}
				user.setExtInfo(ret);
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		
		return user;
	}

	public List<AdminUserInfo> getUserList(String userName, String userPhone, int pageNum, int perPage, PageBean pb)
			throws Exception {

		return SysUserDao.getUserList(userName, userPhone, pageNum, perPage, pb);

	}
	/**
	 * 通过账户获取信息
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	public SysUser getAccountInfo(String account) throws Exception {
		// TODO Auto-generated method stub
		try {
			 return SysUserDao.getAccountUser(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("",e);
			throw new Exception("**************通过account获取用户信息异常****"+e.getMessage());
		}
	}
	/**
	 * 通过手机号获取用户信息
	 * @param userPhone
	 * @return
	 * @throws Exception 
	 */
	public SysUser getUserByPhone(String userPhone) throws Exception {
		// TODO Auto-generated method stub
		try {
			 return SysUserDao.getUserByPhone(userPhone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("",e);
			throw new Exception("**************通过phone获取用户的信息异常****"+e.getMessage());
		}
	}
	
	public TInteger getUserInfo(String account,int userId) throws Exception {
		try {
			 return SysUserDao.getUserInfo(account,userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("",e);
			throw new Exception("**************通过account与userId获取用户的信息异常****"+e.getMessage());
		}
	}

	public void updatePassword(String newPassword, int sysUserId, MDataBase mdb)throws Exception {
		// TODO Auto-generated method stub
		SysUserDao.updatePassword(newPassword,sysUserId,mdb);
	}

	public void updateUserNameMobile(String realname, String mobile, int sysUserId, MDataBase mdb)throws Exception {
		// TODO Auto-generated method stub
		SysUserDao.updateUserNameMobile(realname,mobile,sysUserId,mdb);
	}

	public SysUser getUserById(Integer sysUserId)throws Exception {
		// TODO Auto-generated method stub
		return SysUserDao.getUserById(sysUserId);
	}
}
