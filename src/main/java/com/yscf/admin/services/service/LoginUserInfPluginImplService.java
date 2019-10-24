package com.yscf.admin.services.service;


import org.apache.log4j.Logger;

import com.ulwx.tool.ObjectUtils;
import com.ulwxbase.domain.db.sys.SysUser;
import com.yscf.admin.domain.cus.SaleUserInfo;
import com.yscf.admin.domain.cus.SaleUserInfo.FinDepartInfo;
import com.yscf.admin.domain.cus.SaleUserInfo.OtherDepartInfo;
import com.yscf.admin.domain.db.yscfmdb.SlFinanceDepartUser;
import com.yscf.admin.services.dao.yscfmdb.SlFinanceDepartUserDao;

public class LoginUserInfPluginImplService {
	private static Logger logger=Logger.getLogger(LoginUserInfPluginImplService.class);
	
	public static LoginUserInfPluginImplService instance=new LoginUserInfPluginImplService();
	public LoginUserInfPluginImplService() {
		// TODO Auto-generated constructor stub
	}
	
	public SaleUserInfo getSaleUserInfo(SysUser sysUser,Integer[] roleTypes) throws Exception{
		Integer sysUserId=sysUser.getSysUserSno();
		SaleUserInfo saleUserInfo=new SaleUserInfo();
		
		saleUserInfo.setSysRoleTypes(roleTypes);
		saleUserInfo.setSysUserId(sysUserId);
		
		for(Integer roleType:roleTypes) {
			
			if(SaleUserInfo.RoleType.FinDepartType.zy==roleType) {
				SlFinanceDepartUser jfdu=SlFinanceDepartUserDao.getOnjobUserBy(sysUserId);
				if(jfdu==null) {
					logger.error("客服顾问没有配置到理财部！");
					continue;
				}
				FinDepartInfo fdi=new FinDepartInfo();
				fdi.setOnJob(jfdu.getOnjob());
				fdi.setDepartId(jfdu.getDepartId());
				fdi.setFinanceZgSysUserId(jfdu.getLeaderUserId());
				
				SlFinanceDepartUser jfduzg=SlFinanceDepartUserDao.getOnjobUserBy(jfdu.getLeaderUserId());
				fdi.setFinanceJlSysUserId(jfduzg.getLeaderUserId());
				fdi.setRoleType(roleType);
				fdi.setSysUserId(sysUserId);
				
				saleUserInfo.map.put(roleType, fdi);
			}else if(SaleUserInfo.RoleType.FinDepartType.lczg==roleType) {
				SlFinanceDepartUser jfdu=SlFinanceDepartUserDao.getOnjobUserBy(sysUserId);
				if(jfdu==null) {
					logger.error("理财主管没有配置到理财部！");
					continue;
				}
				FinDepartInfo fdi=new FinDepartInfo();
				fdi.setRoleType(roleType);
				fdi.setSysUserId(sysUserId);
				fdi.setDepartId(jfdu.getDepartId());
				fdi.setOnJob(jfdu.getOnjob());
				fdi.setFinanceZgSysUserId(sysUserId);
				fdi.setFinanceJlSysUserId(jfdu.getLeaderUserId());
				
				saleUserInfo.map.put(roleType, fdi);
				
			}else if(SaleUserInfo.RoleType.FinDepartType.lcjl==roleType) {
				SlFinanceDepartUser jfdu=SlFinanceDepartUserDao.getOnjobUserBy(sysUserId);
				if(jfdu==null) {
					logger.error("理财总监没有配置到理财部！");
					continue;
				}
				FinDepartInfo fdi=new FinDepartInfo();
				fdi.setRoleType(roleType);
				fdi.setSysUserId(sysUserId);
				fdi.setDepartId(jfdu.getDepartId());
				fdi.setOnJob(jfdu.getOnjob());
				fdi.setFinanceZgSysUserId(0);
				fdi.setFinanceJlSysUserId(sysUserId);
			
				
				saleUserInfo.map.put(roleType, fdi);
				
			}else {
				OtherDepartInfo oDepartInfo=new OtherDepartInfo();
				saleUserInfo.map.put(roleType, oDepartInfo);
				
			}
		}
		if(saleUserInfo.isInFinDepart()) {
			saleUserInfo.setHasFinDepartRoleType(true);
		}

		return saleUserInfo;
		
	}
	
	public static void main(String[] args) throws Exception{
		SysUser sysUser=new SysUser();
		Integer[] roleTypes=new Integer[] {6};
		sysUser.setSysUserSno(369);
		System.out.println(ObjectUtils.toString(LoginUserInfPluginImplService.instance.getSaleUserInfo(sysUser,roleTypes)));
	}

}
