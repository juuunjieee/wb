package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JProjectRepayment implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer projectId;/*项目id;len:10*/
	private Integer periods;/*当前第几期;len:5*/
	private Integer repayType;/*1:[本金+利息+罚息+补贴]，即用户本金，利息，罚息放在一行里  2：[本金]，即用户的本金单独一行 3：[利息+罚息]，即用户利息和罚息合在一起单独一行展示 4：[补贴]，即用户利息和罚息合在一起单独一行展示;len:3*/
	private LocalDate startFigureDt;/*开始计息日期;len:10*/
	private LocalDate endFigureDt;/*最终计息日期;len:10*/
	private LocalDate repaymentDate;/*计划还款日期，一般和end_figure_dt相等;len:10*/
	private LocalDateTime repaymentTime;/*实际还款时间;len:19*/
	private Double repaymentAmt;/*还款总金额（包括平台佣金，助贷服务费）;len:15*/
	private Double repaymentInterest;/*还款利息;len:10*/
	private Double repaymentInterestOverdue;/*用户的总逾期罚息;len:10*/
	private Double repaymentInterestAllowance;/*用户的补贴金额;len:10*/
	private Double repaymentCapital;/*还款本金;len:15*/
	private String repaymentServiceFeeOrderNo;/*平台佣金的还款订单号;len:30*/
	private Double repaymentServiceFee;/*还款时平台收取的佣金;len:10*/
	private Integer repaymentServiceFeeStatus;/*平台佣金的还款状态,0表示无须还款，33：未还款  34：已还款;len:5*/
	private Integer repaymentStatus;/*还款状态，0表示无须还款，33：未还款  34：已还款（表明本期投资用户应还本息，平台佣金，罚息都已还）;len:5*/
	private String repaymentPreOrderNo;/*还款预处理订单号（冻结还款方的资金）;len:30*/
	private Integer status;/*状态，1：有效 2：无效;len:5*/
	private Integer extStatus;/*0:当期正常还款  1：提前还款(全部)   2:提前还款（当期） 3：当期延迟还款;len:3*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
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
	public void setRepayType(Integer repayType){
		this.repayType = repayType;
	}
	public Integer getRepayType(){
		return repayType;
	}
	public void setStartFigureDt(LocalDate startFigureDt){
		this.startFigureDt = startFigureDt;
	}
	public LocalDate getStartFigureDt(){
		return startFigureDt;
	}
	public void setEndFigureDt(LocalDate endFigureDt){
		this.endFigureDt = endFigureDt;
	}
	public LocalDate getEndFigureDt(){
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
	public void setRepaymentAmt(Double repaymentAmt){
		this.repaymentAmt = repaymentAmt;
	}
	public Double getRepaymentAmt(){
		return repaymentAmt;
	}
	public void setRepaymentInterest(Double repaymentInterest){
		this.repaymentInterest = repaymentInterest;
	}
	public Double getRepaymentInterest(){
		return repaymentInterest;
	}
	public void setRepaymentInterestOverdue(Double repaymentInterestOverdue){
		this.repaymentInterestOverdue = repaymentInterestOverdue;
	}
	public Double getRepaymentInterestOverdue(){
		return repaymentInterestOverdue;
	}
	public void setRepaymentInterestAllowance(Double repaymentInterestAllowance){
		this.repaymentInterestAllowance = repaymentInterestAllowance;
	}
	public Double getRepaymentInterestAllowance(){
		return repaymentInterestAllowance;
	}
	public void setRepaymentCapital(Double repaymentCapital){
		this.repaymentCapital = repaymentCapital;
	}
	public Double getRepaymentCapital(){
		return repaymentCapital;
	}
	public void setRepaymentServiceFeeOrderNo(String repaymentServiceFeeOrderNo){
		this.repaymentServiceFeeOrderNo = repaymentServiceFeeOrderNo;
	}
	public String getRepaymentServiceFeeOrderNo(){
		return repaymentServiceFeeOrderNo;
	}
	public void setRepaymentServiceFee(Double repaymentServiceFee){
		this.repaymentServiceFee = repaymentServiceFee;
	}
	public Double getRepaymentServiceFee(){
		return repaymentServiceFee;
	}
	public void setRepaymentServiceFeeStatus(Integer repaymentServiceFeeStatus){
		this.repaymentServiceFeeStatus = repaymentServiceFeeStatus;
	}
	public Integer getRepaymentServiceFeeStatus(){
		return repaymentServiceFeeStatus;
	}
	public void setRepaymentStatus(Integer repaymentStatus){
		this.repaymentStatus = repaymentStatus;
	}
	public Integer getRepaymentStatus(){
		return repaymentStatus;
	}
	public void setRepaymentPreOrderNo(String repaymentPreOrderNo){
		this.repaymentPreOrderNo = repaymentPreOrderNo;
	}
	public String getRepaymentPreOrderNo(){
		return repaymentPreOrderNo;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setExtStatus(Integer extStatus){
		this.extStatus = extStatus;
	}
	public Integer getExtStatus(){
		return extStatus;
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

	private static final long serialVersionUID =2013634109L;

}