package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SlUserFinanceReward implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private Integer investNetUserId;/*投资用户网站的用户id（即j_users表的id）;len:10*/
	private Integer investType;/*1:散标;len:3*/
	private Integer investProjectId;/*项目id，如果invest_type=1,为散标项目id；;len:10*/
	private String investProjectTitle;/*项目名称;len:40*/
	private Integer investTenderId;/*投资订单id（j_user_tender_order表的id）;len:10*/
	private Double investTenderAmt;/*投资金额;len:15*/
	private LocalDateTime investTenderDt;/*投资时间;len:19*/
	private Double investProjectApr;/*项目利率;len:15*/
	private Integer investProjectTimelimit;/*项目期数;len:3*/
	private Integer investProjectRepaymentType;/*项目还款方式;len:5*/
	private Integer financeSysUserId;/*理财人员id，即sys_user表id，可能是(理财师，主管，总监);len:10*/
	private Double financeReward;/*理财人员收益;len:15*/
	private Integer financeRoleType;/*理财人员角色;len:10*/
	private Integer financeZgSysUserId;/*理财顾问主管id;len:10*/
	private Double financeZgReward;/*下属理财专员贡献于顾问主管的收益提成;len:15*/
	private Integer financeJlSysUserId;/*理财部经理id;len:10*/
	private Double financeJlReward;/*理财专员贡献的经理的收益提成;len:15*/
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
	public void setInvestTenderAmt(Double investTenderAmt){
		this.investTenderAmt = investTenderAmt;
	}
	public Double getInvestTenderAmt(){
		return investTenderAmt;
	}
	public void setInvestTenderDt(LocalDateTime investTenderDt){
		this.investTenderDt = investTenderDt;
	}
	public LocalDateTime getInvestTenderDt(){
		return investTenderDt;
	}
	public void setInvestProjectApr(Double investProjectApr){
		this.investProjectApr = investProjectApr;
	}
	public Double getInvestProjectApr(){
		return investProjectApr;
	}
	public void setInvestProjectTimelimit(Integer investProjectTimelimit){
		this.investProjectTimelimit = investProjectTimelimit;
	}
	public Integer getInvestProjectTimelimit(){
		return investProjectTimelimit;
	}
	public void setInvestProjectRepaymentType(Integer investProjectRepaymentType){
		this.investProjectRepaymentType = investProjectRepaymentType;
	}
	public Integer getInvestProjectRepaymentType(){
		return investProjectRepaymentType;
	}
	public void setFinanceSysUserId(Integer financeSysUserId){
		this.financeSysUserId = financeSysUserId;
	}
	public Integer getFinanceSysUserId(){
		return financeSysUserId;
	}
	public void setFinanceReward(Double financeReward){
		this.financeReward = financeReward;
	}
	public Double getFinanceReward(){
		return financeReward;
	}
	public void setFinanceRoleType(Integer financeRoleType){
		this.financeRoleType = financeRoleType;
	}
	public Integer getFinanceRoleType(){
		return financeRoleType;
	}
	public void setFinanceZgSysUserId(Integer financeZgSysUserId){
		this.financeZgSysUserId = financeZgSysUserId;
	}
	public Integer getFinanceZgSysUserId(){
		return financeZgSysUserId;
	}
	public void setFinanceZgReward(Double financeZgReward){
		this.financeZgReward = financeZgReward;
	}
	public Double getFinanceZgReward(){
		return financeZgReward;
	}
	public void setFinanceJlSysUserId(Integer financeJlSysUserId){
		this.financeJlSysUserId = financeJlSysUserId;
	}
	public Integer getFinanceJlSysUserId(){
		return financeJlSysUserId;
	}
	public void setFinanceJlReward(Double financeJlReward){
		this.financeJlReward = financeJlReward;
	}
	public Double getFinanceJlReward(){
		return financeJlReward;
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

	private static final long serialVersionUID =-317153465L;

}