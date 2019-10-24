package com.ulwxbase.web.action.utils;

import com.ulwx.type.TBoolean;
import com.ulwx.type.TString;
import com.ulwxbase.domain.db.sys.SysUser;

public interface LoginUserInfPlugin<T> {

	/**
	 * 
	 * @param sysUser ：系统用户
	 * @param roleTypes：此用户角色类型
	 * @param roles：此用户的角色
	 * @param validate：存放是否验证通过
	 * @return
	 * @throws Exception
	 */
	public T contruct(SysUser sysUser,Integer[] roleTypes,Integer[] roles,TBoolean validate,TString validateMsg) throws Exception;
}
