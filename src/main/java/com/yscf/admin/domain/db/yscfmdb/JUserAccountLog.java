package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JUserAccountLog implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer userId;/*用户id;len:10*/
	private String orderNo;/*订单号;len:30*/
	private Integer logType;/*操作类型;len:5*/
	private Integer userType;/*用户类型;len:10*/
	private Double amt;/*操作金额;len:12*/
	private Integer inOrOut;/*0：此笔交易不会导致余额会增减 ，1:收入（导致余额增加），  -1：支出（导致余额减少）;len:3*/
	private Double principal;/*交易后待收本金;len:15*/
	private String bankname;/*银行名称;len:10*/
	private Double balance;/*交易后账户余额，-1表示查询失败;len:15*/
	private String remark;/*描述;len:300*/
	private String config;/*设置，根据不同的log_type含义不同;len:200*/
	private Integer status;/*状态： 0=初始 1=成功、2=失败;len:5*/
	private Integer orderStatus;/*订单处理状态 0，初始化，;len:5*/
	private Integer displayToUser;/*0：不显示 1：显示;len:3*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private Long logid;/*日志id;len:19*/
	private String serverid;/*服务器id;len:20*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	public String getOrderNo(){
		return orderNo;
	}
	public void setLogType(Integer logType){
		this.logType = logType;
	}
	public Integer getLogType(){
		return logType;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	public Integer getUserType(){
		return userType;
	}
	public void setAmt(Double amt){
		this.amt = amt;
	}
	public Double getAmt(){
		return amt;
	}
	public void setInOrOut(Integer inOrOut){
		this.inOrOut = inOrOut;
	}
	public Integer getInOrOut(){
		return inOrOut;
	}
	public void setPrincipal(Double principal){
		this.principal = principal;
	}
	public Double getPrincipal(){
		return principal;
	}
	public void setBankname(String bankname){
		this.bankname = bankname;
	}
	public String getBankname(){
		return bankname;
	}
	public void setBalance(Double balance){
		this.balance = balance;
	}
	public Double getBalance(){
		return balance;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setConfig(String config){
		this.config = config;
	}
	public String getConfig(){
		return config;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public Integer getOrderStatus(){
		return orderStatus;
	}
	public void setDisplayToUser(Integer displayToUser){
		this.displayToUser = displayToUser;
	}
	public Integer getDisplayToUser(){
		return displayToUser;
	}
	public void setModifyTime(LocalDateTime modifyTime){
		this.modifyTime = modifyTime;
	}
	public LocalDateTime getModifyTime(){
		return modifyTime;
	}
	public void setCreateTime(LocalDateTime createTime){
		this.createTime = createTime;
	}
	public LocalDateTime getCreateTime(){
		return createTime;
	}
	public void setLogid(Long logid){
		this.logid = logid;
	}
	public Long getLogid(){
		return logid;
	}
	public void setServerid(String serverid){
		this.serverid = serverid;
	}
	public String getServerid(){
		return serverid;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-1441615112L;

}