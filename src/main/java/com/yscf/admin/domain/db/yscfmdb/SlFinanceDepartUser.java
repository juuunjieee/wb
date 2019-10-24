package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SlFinanceDepartUser implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private Integer departId;/*理财部门id;len:10*/
	private Integer sysUserId;/*用户id，对应sys_user表的id;len:10*/
	private Integer roletypeCode;/*岗位编码（角色类型），对应sys_roletype表的sys_roletype_code;len:10*/
	private Integer leaderUserId;/*上级id，如果没有上级，则为0;len:10*/
	private Integer zgSysUserId;/*客服主管id,下级及同级填主管id,上级填0;len:10*/
	private Integer jlSysUserId;/*客服经理id,下级及同级填经理id,上级填0;len:10*/
	private Integer onjob;/*1：在职 2：离职;len:3*/
	private Integer netUserId;/*对应网站用户id，用于生成推荐二维码;len:10*/
	private Integer virtual;/*1：真实 2：虚拟;len:3*/
	private LocalDateTime updatime;/*更新时间;len:19*/
	private String updator;/*更新人姓名;len:15*/
	private Integer status;/*1:有效 2：无效;len:3*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setDepartId(Integer departId){
		this.departId = departId;
	}
	public Integer getDepartId(){
		return departId;
	}
	public void setSysUserId(Integer sysUserId){
		this.sysUserId = sysUserId;
	}
	public Integer getSysUserId(){
		return sysUserId;
	}
	public void setRoletypeCode(Integer roletypeCode){
		this.roletypeCode = roletypeCode;
	}
	public Integer getRoletypeCode(){
		return roletypeCode;
	}
	public void setLeaderUserId(Integer leaderUserId){
		this.leaderUserId = leaderUserId;
	}
	public Integer getLeaderUserId(){
		return leaderUserId;
	}
	public void setZgSysUserId(Integer zgSysUserId){
		this.zgSysUserId = zgSysUserId;
	}
	public Integer getZgSysUserId(){
		return zgSysUserId;
	}
	public void setJlSysUserId(Integer jlSysUserId){
		this.jlSysUserId = jlSysUserId;
	}
	public Integer getJlSysUserId(){
		return jlSysUserId;
	}
	public void setOnjob(Integer onjob){
		this.onjob = onjob;
	}
	public Integer getOnjob(){
		return onjob;
	}
	public void setNetUserId(Integer netUserId){
		this.netUserId = netUserId;
	}
	public Integer getNetUserId(){
		return netUserId;
	}
	public void setVirtual(Integer virtual){
		this.virtual = virtual;
	}
	public Integer getVirtual(){
		return virtual;
	}
	public void setUpdatime(LocalDateTime updatime){
		this.updatime = updatime;
	}
	public LocalDateTime getUpdatime(){
		return updatime;
	}
	public void setUpdator(String updator){
		this.updator = updator;
	}
	public String getUpdator(){
		return updator;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =313409904L;

}