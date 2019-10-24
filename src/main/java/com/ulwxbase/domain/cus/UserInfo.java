package com.ulwxbase.domain.cus;

import com.ulwx.tool.ArrayUtils;
import com.ulwx.tool.ObjectUtils;
import com.ulwxbase.domain.db.sys.SysRight;
import com.ulwxbase.domain.db.sys.SysUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = 456018811819402534L;
	private SysUser user;
	private Integer[] roles;// 存放角色id
	private Integer[] roleTypes;
	private List<SysRight> rights;
	
	private Map<Integer,List<String>> serviceRightMap=new HashMap<>();
	private Object extInfo;
	
	
	public Object getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(Object extInfo) {
		this.extInfo = extInfo;
	}

	public Map<Integer, List<String>> getServiceRightMap() {
		return serviceRightMap;
	}

	public void setServiceRightMap(Map<Integer, List<String>> serviceRightMap) {
		this.serviceRightMap = serviceRightMap;
	}

	public boolean isAdminUser() {
		return ArrayUtils.contains(this.getRoleTypes(), 0);
	}

	public Integer getUserId(){
		return this.getUser().getSysUserSno();
	}
	public String getUserAccount() {
		return this.getUser().getAccount();
	}
	public String getUserName() {
		return this.getUser().getName();
	}
	public List<SysRight> getRights() {
		return rights;
	}


	public void setRights(List<SysRight> rights) {
		this.rights = rights;
	}


	public Integer[] getRoleTypes() {
		return roleTypes;
	}


	public void setRoleTypes(Integer[] roleTypes) {
		this.roleTypes = roleTypes;
	}


	public String getPassword() {
		return this.getUser().getPassword();
	}



	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public Integer[] getRoles() {
		return roles;
	}

	public void setRoles(Integer[] roles) {
		this.roles = roles;
	}


	
	@Override
	public String toString() {
		return  ObjectUtils.toString(this);
	}

}
