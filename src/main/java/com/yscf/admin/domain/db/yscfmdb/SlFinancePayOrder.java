package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SlFinancePayOrder implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private LocalDate grantDate;/*发放日期，如六月份，则发放日期为6月1日;len:10*/
	private Double investTenderAmt;/*当前月直接投资金额;len:15*/
	private Double reward;/*直接担当理财师获取的直接收益;len:15*/
	private Double indirectTenderAmt;/*当前月间接投资总额，即下属（包括间接下属）以及自己担当理财师的投资总额;len:15*/
	private Double indirectReward;/*当前月间接分成收益，即下属（包括间接下属）以及自己担当理财师的分成收益;len:15*/
	private Integer sysUserId;/*理财部门人员的系统用户id，此用户直接服务投资人;len:10*/
	private Integer sysUserRoletypeCode;/*应sys_roletype的code,分理财顾问专员，理财顾问主管，理财顾问经理;len:10*/
	private String orderNo;/*发放收益订单号;len:30*/
	private LocalDateTime orderDt;/*发放收益日期;len:19*/
	private Integer orderStatus;/*订单状态，23；处理失败 24：处理成功 134：处理中 0：初始化;len:5*/
	private Integer finDepartId;/*理财部id;len:10*/
	private Integer grantStatus;/*0：不需要财务审核发放。财务独立发放模式：30=待财务审核 ,20=财务审核通过（待财务发放） 21=财务审核不通过（拒绝发放），10=财务已发放 。;len:3*/
	private Integer isVirtual;/*1:真实 2；虚拟;len:3*/
	private Integer status;/*1:有效 2：无效;len:3*/
	private LocalDateTime creatime;/*更新时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setGrantDate(LocalDate grantDate){
		this.grantDate = grantDate;
	}
	public LocalDate getGrantDate(){
		return grantDate;
	}
	public void setInvestTenderAmt(Double investTenderAmt){
		this.investTenderAmt = investTenderAmt;
	}
	public Double getInvestTenderAmt(){
		return investTenderAmt;
	}
	public void setReward(Double reward){
		this.reward = reward;
	}
	public Double getReward(){
		return reward;
	}
	public void setIndirectTenderAmt(Double indirectTenderAmt){
		this.indirectTenderAmt = indirectTenderAmt;
	}
	public Double getIndirectTenderAmt(){
		return indirectTenderAmt;
	}
	public void setIndirectReward(Double indirectReward){
		this.indirectReward = indirectReward;
	}
	public Double getIndirectReward(){
		return indirectReward;
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
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	public String getOrderNo(){
		return orderNo;
	}
	public void setOrderDt(LocalDateTime orderDt){
		this.orderDt = orderDt;
	}
	public LocalDateTime getOrderDt(){
		return orderDt;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public Integer getOrderStatus(){
		return orderStatus;
	}
	public void setFinDepartId(Integer finDepartId){
		this.finDepartId = finDepartId;
	}
	public Integer getFinDepartId(){
		return finDepartId;
	}
	public void setGrantStatus(Integer grantStatus){
		this.grantStatus = grantStatus;
	}
	public Integer getGrantStatus(){
		return grantStatus;
	}
	public void setIsVirtual(Integer isVirtual){
		this.isVirtual = isVirtual;
	}
	public Integer getIsVirtual(){
		return isVirtual;
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

	private static final long serialVersionUID =1790955121L;

}