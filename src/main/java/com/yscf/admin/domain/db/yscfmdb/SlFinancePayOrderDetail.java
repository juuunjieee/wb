package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SlFinancePayOrderDetail implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private Integer investNetUserId;/*投资用户网站的用户id（即j_users表的id）;len:10*/
	private Integer investType;/*1：普通标;len:3*/
	private Integer investProjectId;/*项目id，如果invest_type=1,为散标项目id；;len:10*/
	private String investProjectTitle;/*项目名称;len:40*/
	private Integer investTenderId;/*投资订单id（j_user_tender_order表的id），如果invest_type=1,为jyd2.j_user_tender_order的id；;len:10*/
	private LocalDateTime investTenderDt;/*项目投资时间;len:19*/
	private Integer investProjectTimelimit;/*项目期数;len:3*/
	private Double investTenderAmt;/*投资金额;len:15*/
	private Integer investProjectRepaymentType;/*项目还款方式;len:5*/
	private Double investProjectApr;/*项目费率;len:15*/
	private Integer sysUserId;/*享受收益的理财人员id;len:10*/
	private Integer sysUserRoletypeCode;/*冗余字段，岗位编码，对应sys_roletype的code;len:10*/
	private Integer rewardType;/*1:直接收益（理财专员的收益） 2:间接提成收益（上级的提成）;len:3*/
	private Double rewardAmt;/*收益;len:15*/
	private Integer isVirtual;/*1:真实 2：虚拟;len:3*/
	private Integer finDepartId;/*理财部id;len:10*/
	private Integer status;/*1:有效 2：无效;len:3*/
	private LocalDateTime creatime;/*更新时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setInvestNetUserId(Integer investNetUserId){
		this.investNetUserId = investNetUserId;
	}
	public Integer getInvestNetUserId(){
		return investNetUserId;
	}
	public void setInvestType(Integer investType){
		this.investType = investType;
	}
	public Integer getInvestType(){
		return investType;
	}
	public void setInvestProjectId(Integer investProjectId){
		this.investProjectId = investProjectId;
	}
	public Integer getInvestProjectId(){
		return investProjectId;
	}
	public void setInvestProjectTitle(String investProjectTitle){
		this.investProjectTitle = investProjectTitle;
	}
	public String getInvestProjectTitle(){
		return investProjectTitle;
	}
	public void setInvestTenderId(Integer investTenderId){
		this.investTenderId = investTenderId;
	}
	public Integer getInvestTenderId(){
		return investTenderId;
	}
	public void setInvestTenderDt(LocalDateTime investTenderDt){
		this.investTenderDt = investTenderDt;
	}
	public LocalDateTime getInvestTenderDt(){
		return investTenderDt;
	}
	public void setInvestProjectTimelimit(Integer investProjectTimelimit){
		this.investProjectTimelimit = investProjectTimelimit;
	}
	public Integer getInvestProjectTimelimit(){
		return investProjectTimelimit;
	}
	public void setInvestTenderAmt(Double investTenderAmt){
		this.investTenderAmt = investTenderAmt;
	}
	public Double getInvestTenderAmt(){
		return investTenderAmt;
	}
	public void setInvestProjectRepaymentType(Integer investProjectRepaymentType){
		this.investProjectRepaymentType = investProjectRepaymentType;
	}
	public Integer getInvestProjectRepaymentType(){
		return investProjectRepaymentType;
	}
	public void setInvestProjectApr(Double investProjectApr){
		this.investProjectApr = investProjectApr;
	}
	public Double getInvestProjectApr(){
		return investProjectApr;
	}
	public void setSysUserId(Integer sysUserId){
		this.sysUserId = sysUserId;
	}
	public Integer getSysUserId(){
		return sysUserId;
	}
	public void setSysUserRoletypeCode(Integer sysUserRoletypeCode){
		this.sysUserRoletypeCode = sysUserRoletypeCode;
	}
	public Integer getSysUserRoletypeCode(){
		return sysUserRoletypeCode;
	}
	public void setRewardType(Integer rewardType){
		this.rewardType = rewardType;
	}
	public Integer getRewardType(){
		return rewardType;
	}
	public void setRewardAmt(Double rewardAmt){
		this.rewardAmt = rewardAmt;
	}
	public Double getRewardAmt(){
		return rewardAmt;
	}
	public void setIsVirtual(Integer isVirtual){
		this.isVirtual = isVirtual;
	}
	public Integer getIsVirtual(){
		return isVirtual;
	}
	public void setFinDepartId(Integer finDepartId){
		this.finDepartId = finDepartId;
	}
	public Integer getFinDepartId(){
		return finDepartId;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setCreatime(LocalDateTime creatime){
		this.creatime = creatime;
	}
	public LocalDateTime getCreatime(){
		return creatime;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-306655863L;

}