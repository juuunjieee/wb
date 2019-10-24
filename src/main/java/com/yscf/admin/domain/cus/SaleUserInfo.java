package com.yscf.admin.domain.cus;

import java.util.HashMap;
import java.util.Map;
import com.ulwx.tool.ArrayUtils;

public class SaleUserInfo {

	private Integer sysUserId;
	private Integer[] sysRoleTypes;
	//是否含有理财部岗位
	private boolean hasFinDepartRoleType=false;

	
	/**
	 * 角色类型（岗位）对应的部门信息。如果是理财部里的岗位，对应的是理财部的信息
	 */
	public Map<Integer, Object> map = new HashMap<>();
	
	public Map<Integer, Object> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Object> map) {
		this.map = map;
	}



	public boolean isHasFinDepartRoleType() {
		return hasFinDepartRoleType;
	}

	public void setHasFinDepartRoleType(boolean hasFinDepartRoleType) {
		this.hasFinDepartRoleType = hasFinDepartRoleType;
	}



	public SaleUserInfo() {
		// TODO Auto-generated constructor stub
	}

	public static class OtherDepartInfo {

	}
	

	public Integer getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Integer[] getSysRoleTypes() {
		return sysRoleTypes;
	}

	public void setSysRoleTypes(Integer[] sysRoleTypes) {
		this.sysRoleTypes = sysRoleTypes;
	}


	/**
	 * 是否是理财部专员
	 * @return
	 */
	public boolean isFinDepartZy() {
		if (ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.zy)){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否是理财部主管
	 * @return
	 */
	public boolean isFinDepartZg() {
		if (ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.lczg)){
			return true;
		}
		return false;
	}
	/**
	 * 是否是理财部经理
	 * @return
	 */
	public boolean isFinDepartJl() {
		if (ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.lcjl)){
			return true;
		}
		return false;
	}


	/**
	 * 岗位里是否有理财部里的岗位
	 * 
	 * @return
	 */
	public boolean isInFinDepart() {
		if (ArrayUtils.contains(sysRoleTypes,  RoleType.FinDepartType.lcjl)
				|| ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.zy)
				|| ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.lczg)
				) {
			return true;
		}

		return false;
	}

	/**
	 * 判断岗位里是否都不包含门店和理财部的岗位
	 * 
	 * @return
	 */
	public boolean isNotInShopAdnFinDepart() {
		if (!isInFinDepart())
			return true;

		return false;
	}



	/**
	 * 获取理财部信息
	 * 
	 * @return
	 */
	public FinDepartInfo getFinDepartInfo() {

		if (ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.zy)) {
			return (FinDepartInfo) map.get(RoleType.FinDepartType.zy);
		} else if (ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.lcjl)) {
			return (FinDepartInfo) map.get(RoleType.FinDepartType.lcjl);
		}else if (ArrayUtils.contains(sysRoleTypes, RoleType.FinDepartType.lczg)) {
			return (FinDepartInfo) map.get(RoleType.FinDepartType.lczg);
		}
		return null;
	}

	
	/**
	 * 理财部信息表
	 * 
	 * @author jyd
	 *
	 */
	public static class FinDepartInfo {
		// 用户id
		private Integer sysUserId=0;
		// 角色类型（岗位）编码，520：理财部理财总监，500：理财部客服专员  510：理财主管
		private Integer roleType=-1;
		// 理财主管的用户id
		private Integer financeZgSysUserId=0;
		// 理财总监的用户id
		private Integer financeJlSysUserId=0;
		// 理财部部门id
		private Integer departId=0;
		private Integer onJob;
		
		public Integer getOnJob() {
			return onJob;
		}

		public void setOnJob(Integer onJob) {
			this.onJob = onJob;
		}

		public Integer getSysUserId() {
			return sysUserId;
		}

		public void setSysUserId(Integer sysUserId) {
			this.sysUserId = sysUserId;
		}

		public Integer getRoleType() {
			return roleType;
		}

		public void setRoleType(Integer roleType) {
			this.roleType = roleType;
		}

		public Integer getFinanceJlSysUserId() {
			return financeJlSysUserId;
		}

		public void setFinanceJlSysUserId(Integer financeJlSysUserId) {
			this.financeJlSysUserId = financeJlSysUserId;
		}

		public Integer getFinanceZgSysUserId() {
			return financeZgSysUserId;
		}

		public void setFinanceZgSysUserId(Integer financeZgSysUserId) {
			this.financeZgSysUserId = financeZgSysUserId;
		}

		public Integer getDepartId() {
			return departId;
		}

		public void setDepartId(Integer departId) {
			this.departId = departId;
		}

	}

	public static class RoleType {

		public static class FinDepartType {
			public static int zy = 500;// 客服专员
			public static int lczg=510;//理财主管
			public static int lcjl = 520;// 理财总监
		}
	}

}
