package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SysRole implements java.io.Serializable {

	private Integer sysRoleSno;/*流水号;len:10*/
	private String roleName;/*角色名称;len:30*/
	private Integer isSys;/*1:系统预定义角色  0：用户自定义角色。系统预定义角色，界面上不能删除;len:3*/
	private Integer roleTypeCode;/*角色类型，对应sys_role_type的code;len:10*/
	private String description;/*角色说明;len:100*/
	private LocalDateTime updateTime;/*更新时间;len:19*/
	private String updator;/*更新人;len:30*/

	public void setSysRoleSno(Integer sysRoleSno){
		this.sysRoleSno = sysRoleSno;
	}
	public Integer getSysRoleSno(){
		return sysRoleSno;
	}
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	public String getRoleName(){
		return roleName;
	}
	public void setIsSys(Integer isSys){
		this.isSys = isSys;
	}
	public Integer getIsSys(){
		return isSys;
	}
	public void setRoleTypeCode(Integer roleTypeCode){
		this.roleTypeCode = roleTypeCode;
	}
	public Integer getRoleTypeCode(){
		return roleTypeCode;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public void setUpdateTime(LocalDateTime updateTime){
		this.updateTime = updateTime;
	}
	public LocalDateTime getUpdateTime(){
		return updateTime;
	}
	public void setUpdator(String updator){
		this.updator = updator;
	}
	public String getUpdator(){
		return updator;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =158195373L;

}