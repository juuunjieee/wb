package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JUserTenderOrder implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer userId;/*用户id，实际投资人;len:10*/
	private Integer projectId;/*项目id;len:10*/
	private String orderNo;/*投资订单号，每笔投资生成一个订单号;len:30*/
	private Integer proxyUserId;/*投资代表，一般和user_id相等（即自己是自己的投资代表），如果为有限合伙，有可能不相等，有可能为真正的投资代表;len:10*/
	private LocalDate orderDate;/*订单日期;len:10*/
	private LocalDateTime orderTime;/*订单时间;len:19*/
	private String freezeOrderNo;/*冻结订单号，新系统后和order_no相同;len:30*/
	private String unfreezeOrderNo;/*解冻订单号，出现异常解冻时，会用到此字段;len:30*/
	private Integer orderStatus;/*0：未处理 ，23：失败 24：成功。j_dic_category=11;len:5*/
	private Integer loanStatus;/*0：未放款，23：失败 24：成功。j_dic_category=11;len:5*/
	private String loanOrderNo;/*放款的订单号;len:30*/
	private LocalDateTime loanTime;/*实际放款时间;len:19*/
	private Double amt;/*投标金额;len:15*/
	private Double repyedPrincipal;/*当前已还本金;len:15*/
	private Integer fromCh;/*订单产生的条件，0:来自散标区-用户手动投标;len:3*/
	private String fromChOrderNo;/*如果from_ch=0，和order_no相等;len:30*/
	private Integer fromId;/*保留字段;len:10*/
	private Integer finishStatus;/*本笔投资的状态，0:未结束（本金和利息未全部收回）  1：已结束（全部收回本金和利息）;len:3*/
	private LocalDateTime finishTime;/*结束时间（本金和利息全部收回的时间）;len:19*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private Integer status;/*状态，1：有效 2：无效 0:初始;len:5*/

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
	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
	public Integer getProjectId(){
		return projectId;
	}
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	public String getOrderNo(){
		return orderNo;
	}
	public void setProxyUserId(Integer proxyUserId){
		this.proxyUserId = proxyUserId;
	}
	public Integer getProxyUserId(){
		return proxyUserId;
	}
	public void setOrderDate(LocalDate orderDate){
		this.orderDate = orderDate;
	}
	public LocalDate getOrderDate(){
		return orderDate;
	}
	public void setOrderTime(LocalDateTime orderTime){
		this.orderTime = orderTime;
	}
	public LocalDateTime getOrderTime(){
		return orderTime;
	}
	public void setFreezeOrderNo(String freezeOrderNo){
		this.freezeOrderNo = freezeOrderNo;
	}
	public String getFreezeOrderNo(){
		return freezeOrderNo;
	}
	public void setUnfreezeOrderNo(String unfreezeOrderNo){
		this.unfreezeOrderNo = unfreezeOrderNo;
	}
	public String getUnfreezeOrderNo(){
		return unfreezeOrderNo;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public Integer getOrderStatus(){
		return orderStatus;
	}
	public void setLoanStatus(Integer loanStatus){
		this.loanStatus = loanStatus;
	}
	public Integer getLoanStatus(){
		return loanStatus;
	}
	public void setLoanOrderNo(String loanOrderNo){
		this.loanOrderNo = loanOrderNo;
	}
	public String getLoanOrderNo(){
		return loanOrderNo;
	}
	public void setLoanTime(LocalDateTime loanTime){
		this.loanTime = loanTime;
	}
	public LocalDateTime getLoanTime(){
		return loanTime;
	}
	public void setAmt(Double amt){
		this.amt = amt;
	}
	public Double getAmt(){
		return amt;
	}
	public void setRepyedPrincipal(Double repyedPrincipal){
		this.repyedPrincipal = repyedPrincipal;
	}
	public Double getRepyedPrincipal(){
		return repyedPrincipal;
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
	public void setFromId(Integer fromId){
		this.fromId = fromId;
	}
	public Integer getFromId(){
		return fromId;
	}
	public void setFinishStatus(Integer finishStatus){
		this.finishStatus = finishStatus;
	}
	public Integer getFinishStatus(){
		return finishStatus;
	}
	public void setFinishTime(LocalDateTime finishTime){
		this.finishTime = finishTime;
	}
	public LocalDateTime getFinishTime(){
		return finishTime;
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
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =1293964679L;

}