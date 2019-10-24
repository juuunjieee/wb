package com.ulwxbase.web.action.sys.domain;

import com.ulwxbase.domain.db.sys.SysRole;

public class SysRoleInfo extends SysRole{

	private String SysRoleTypeName;

	public String getSysRoleTypeName() {
		return SysRoleTypeName;
	}

	public void setSysRoleTypeName(String sysRoleTypeName) {
		SysRoleTypeName = sysRoleTypeName;
	}
	
}
