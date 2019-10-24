package com.yscf.admin.web.action;

import com.ulwxbase.domain.cus.UserInfo;
import com.yscf.admin.domain.cus.SaleUserInfo;

public class BaseAction extends com.ulwxbase.web.action.CbBaseAction {

	public SaleUserInfo getSaleUserInfo() {
		UserInfo userInfo =this.getUserInfo() ;
		Object obj=userInfo.getExtInfo();
		return (SaleUserInfo)obj;
	}
	
	
}
