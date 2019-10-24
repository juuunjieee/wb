package com.yscf.admin.services.utils;

import com.ulwx.type.TBoolean;
import com.ulwx.type.TString;
import com.ulwxbase.domain.db.sys.SysUser;
import com.ulwxbase.web.action.utils.LoginUserInfPlugin;
import com.yscf.admin.domain.cus.SaleUserInfo;
import com.yscf.admin.services.service.LoginUserInfPluginImplService;

public class LoginUserInfPluginImpl implements LoginUserInfPlugin<SaleUserInfo> {

	public LoginUserInfPluginImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SaleUserInfo contruct(SysUser sysUser, Integer[] roleTypes, Integer[] roles,TBoolean validate,TString validateMsg) throws Exception{
		// TODO Auto-generated method stub
		SaleUserInfo su= LoginUserInfPluginImplService.instance.getSaleUserInfo(sysUser, roleTypes);
		
		validate.setValue(true);
		if(su!=null) {
			////
		}
		return su;
		
		
	
	}

}
