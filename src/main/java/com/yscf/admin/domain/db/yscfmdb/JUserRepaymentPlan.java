package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JUserRepaymentPlan implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer userId;/*用户id，为0表明是平台代付利息，需借款人（代偿方）还;len:10*/
	private Integer proxyUserId;/*投资代表，如果没有真实的投资代表，则等于自己的用户id;len:10*/
	private Integer repayType;/*1:[本金+利息+罚息+补贴]，即用户本金，利息，罚息放在一行里  2：[本金]，即用户的本金单独一行 3：[利息+罚息]，即用户利息和罚息合在一起单独一行展示 4：[补贴]，即用户利息和罚息合在一起单独一行展示;len:3*/
	private Integer projectId;/*项目id;len:10*/
	private Integer periods;/*当前第几期;len:5*/
	private String tenderOrderNo;/*投项目订单号，j_user_tender_order表的order_no;len:30*/
	private Integer fromCh;/* tender_order_no对应的投资订单的来源属性。0:来自散标区-用户手动投标;len:3*/
	private String fromChOrderNo;/*渠道订单流水id，如果from_ch=0, 和tender_order_no相等;len:30*/
	private LocalDate startFigureDt;/*计算开始日期;len:10*/
	private LocalDateTime endFigureDt;/*计算结束日期;len:19*/
	private LocalDate repaymentDate;/*计划还款日期;len:10*/
	private LocalDateTime repaymentTime;/*实际还款时间;len:19*/
	private Double amt;/*还款总额;len:15*/
	private Double interest;/*还款利息;len:10*/
	private Double principal;/*还款本金;len:15*/
	private Double interestOverdue;/*逾期罚息;len:10*/
	private Double allowance;/*奖励金额;len:10*/
	private Integer repaymentStatus;/*还款状态,0表示无须还款 33：未还款 34：已还款（表明已还本息，含逾期罚息）;len:5*/
	private String repaymentOrderNo;/*还款订单号;len:30*/
	private Integer extStatus;/*0:正常还款  1：提前还款（全部） 2：提前还款（当期） 3：当期延迟还款    134：处理中;len:3*/
	private Integer status;/*状态 1：有效 2：无效;len:5*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/

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
	public void setProxyUserId(Integer proxyUserId){
		this.proxyUserId = proxyUserId;
	}
	public Integer getProxyUserId(){
		return proxyUserId;
	}
	public void setRepayType(Integer repayType){
		this.repayType = repayType;
	}
	public Integer getRepayType(){
		return repayType;
	}
	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
	public Integer getProjectId(){
		return projectId;
	}
	public void setPeriods(Integer periods){
		this.periods = periods;
	}
	public Integer getPeriods(){
		return periods;
	}
	public void setTenderOrderNo(String tenderOrderNo){
		this.tenderOrderNo = tenderOrderNo;
	}
	public String getTenderOrderNo(){
		return tenderOrderNo;
	}
	public void setFromCh(Integer fromCh){
		this.fromCh = fromCh;
	}
	public Integer getFromCh(){
		return fromCh;
	}
	public void setFromChOrderNo(String fromChOrderNo){
		this.fromChOrderNo = fromChOrderNo;
	}
	public String getFromChOrderNo(){
		return fromChOrderNo;
	}
	public void setStartFigureDt(LocalDate startFigureDt){
		this.startFigureDt = startFigureDt;
	}
	public LocalDate getStartFigureDt(){
		return startFigureDt;
	}
	public void setEndFigureDt(LocalDateTime endFigureDt){
		this.endFigureDt = endFigureDt;
	}
	public LocalDateTime getEndFigureDt(){
		return endFigureDt;
	}
	public void setRepaymentDate(LocalDate repaymentDate){
		this.repaymentDate = repaymentDate;
	}
	public LocalDate getRepaymentDate(){
		return repaymentDate;
	}
	public void setRepaymentTime(LocalDateTime repaymentTime){
		this.repaymentTime = repaymentTime;
	}
	public LocalDateTime getRepaymentTime(){
		return repaymentTime;
	}
	public void setAmt(Double amt){
		this.amt = amt;
	}
	public Double getAmt(){
		return amt;
	}
	public void setInterest(Double interest){
		this.interest = interest;
	}
	public Double getInterest(){
		return interest;
	}
	public void setPrincipal(Double principal){
		this.principal = principal;
	}
	public Double getPrincipal(){
		return principal;
	}
	public void setInterestOverdue(Double interestOverdue){
		this.interestOverdue = interestOverdue;
	}
	public Double getInterestOverdue(){
		return interestOverdue;
	}
	public void setAllowance(Double allowance){
		this.allowance = allowance;
	}
	public Double getAllowance(){
		return allowance;
	}
	public void setRepaymentStatus(Integer repaymentStatus){
		this.repaymentStatus = repaymentStatus;
	}
	public Integer getRepaymentStatus(){
		return repaymentStatus;
	}
	public void setRepaymentOrderNo(String repaymentOrderNo){
		this.repaymentOrderNo = repaymentOrderNo;
	}
	public String getRepaymentOrderNo(){
		return repaymentOrderNo;
	}
	public void setExtStatus(Integer extStatus){
		this.extStatus = extStatus;
	}
	public Integer getExtStatus(){
		return extStatus;
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

	private static final long serialVersionUID =-511671527L;

}