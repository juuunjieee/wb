package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class StatStatisticsHistory implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private String historyDate;/*日期,格式：20160508;len:8*/
	private Integer regUserCount;/*注册用户数;len:10*/
	private Integer addUserCount;/*新增用户数;len:10*/
	private Integer effectiveUserCount;/*有效用户数;len:10*/
	private Integer nowEffectiveUser;/*当前有效用户数;len:10*/
	private Integer addEffectiveUserCount;/*新增有效用户数;len:10*/
	private Double notRepaymentAmt;/*待收总金额;len:15*/
	private Double notRepaymentInterest;/*待收利息;len:15*/
	private Double notRepaymentPrincipal;/*待收本金;len:15*/
	private Double rechargeAmt;/*充值总数;len:15*/
	private Double withdrawAmt;/*提现总数;len:15*/
	private Double repaymentAmt;/*还款总数;len:15*/
	private Double tradeAmt;/*交易总数;len:15*/
	private Integer borrowerCount;/*累计借款人总数;len:10*/
	private Integer nowBorrowerCount;/*当前借款人总数;len:10*/
	private Double beforeFiveAmt;/*前5户借款余额;len:15*/
	private Integer status;/*状态;len:10*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setHistoryDate(String historyDate){
		this.historyDate = historyDate;
	}
	public String getHistoryDate(){
		return historyDate;
	}
	public void setRegUserCount(Integer regUserCount){
		this.regUserCount = regUserCount;
	}
	public Integer getRegUserCount(){
		return regUserCount;
	}
	public void setAddUserCount(Integer addUserCount){
		this.addUserCount = addUserCount;
	}
	public Integer getAddUserCount(){
		return addUserCount;
	}
	public void setEffectiveUserCount(Integer effectiveUserCount){
		this.effectiveUserCount = effectiveUserCount;
	}
	public Integer getEffectiveUserCount(){
		return effectiveUserCount;
	}
	public void setNowEffectiveUser(Integer nowEffectiveUser){
		this.nowEffectiveUser = nowEffectiveUser;
	}
	public Integer getNowEffectiveUser(){
		return nowEffectiveUser;
	}
	public void setAddEffectiveUserCount(Integer addEffectiveUserCount){
		this.addEffectiveUserCount = addEffectiveUserCount;
	}
	public Integer getAddEffectiveUserCount(){
		return addEffectiveUserCount;
	}
	public void setNotRepaymentAmt(Double notRepaymentAmt){
		this.notRepaymentAmt = notRepaymentAmt;
	}
	public Double getNotRepaymentAmt(){
		return notRepaymentAmt;
	}
	public void setNotRepaymentInterest(Double notRepaymentInterest){
		this.notRepaymentInterest = notRepaymentInterest;
	}
	public Double getNotRepaymentInterest(){
		return notRepaymentInterest;
	}
	public void setNotRepaymentPrincipal(Double notRepaymentPrincipal){
		this.notRepaymentPrincipal = notRepaymentPrincipal;
	}
	public Double getNotRepaymentPrincipal(){
		return notRepaymentPrincipal;
	}
	public void setRechargeAmt(Double rechargeAmt){
		this.rechargeAmt = rechargeAmt;
	}
	public Double getRechargeAmt(){
		return rechargeAmt;
	}
	public void setWithdrawAmt(Double withdrawAmt){
		this.withdrawAmt = withdrawAmt;
	}
	public Double getWithdrawAmt(){
		return withdrawAmt;
	}
	public void setRepaymentAmt(Double repaymentAmt){
		this.repaymentAmt = repaymentAmt;
	}
	public Double getRepaymentAmt(){
		return repaymentAmt;
	}
	public void setTradeAmt(Double tradeAmt){
		this.tradeAmt = tradeAmt;
	}
	public Double getTradeAmt(){
		return tradeAmt;
	}
	public void setBorrowerCount(Integer borrowerCount){
		this.borrowerCount = borrowerCount;
	}
	public Integer getBorrowerCount(){
		return borrowerCount;
	}
	public void setNowBorrowerCount(Integer nowBorrowerCount){
		this.nowBorrowerCount = nowBorrowerCount;
	}
	public Integer getNowBorrowerCount(){
		return nowBorrowerCount;
	}
	public void setBeforeFiveAmt(Double beforeFiveAmt){
		this.beforeFiveAmt = beforeFiveAmt;
	}
	public Double getBeforeFiveAmt(){
		return beforeFiveAmt;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
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

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-279363256L;

}