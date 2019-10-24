package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JPlatformPayOrder implements java.io.Serializable {

	private Long id;/*id;len:19*/
	private String orderNo;/*订单号;len:30*/
	private LocalDate orderDate;/*订单日期;len:10*/
	private Double transAmt;/*交易金额;len:15*/
	private Integer inOrOut;/*0：此笔交易不会导致余额会增减 ，1:收入（导致余额增加）， -1：支出（导致余额减少）;len:3*/
	private String platformUserId;/*目的平台账户;len:20*/
	private Double balance;/*目标账户余额，-1表示余额未知;len:15*/
	private String srcPlatformUserId;/*源平台账户;len:20*/
	private Integer payType;/*支付公司，对应category=95，针对充值才有效果;len:5*/
	private Integer payWay;/*支付方式 0：初始 1；快捷 2：网银;len:5*/
	private Integer orderStatus;/*订单状态;len:5*/
	private Integer orderType;/*  订单类型 对应j_dic_category的id=36;len:5*/
	private Integer grantStatus;/*发放状态:1=已发放,2=已审核（待发放）,3=待审核 ，0=不需要审核。如果需要审核，从3开始;len:5*/
	private Integer status;/*状态,对应j_dic_category的1;len:5*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private String updator;/*更新人;len:10*/

	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return id;
	}
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	public String getOrderNo(){
		return orderNo;
	}
	public void setOrderDate(LocalDate orderDate){
		this.orderDate = orderDate;
	}
	public LocalDate getOrderDate(){
		return orderDate;
	}
	public void setTransAmt(Double transAmt){
		this.transAmt = transAmt;
	}
	public Double getTransAmt(){
		return transAmt;
	}
	public void setInOrOut(Integer inOrOut){
		this.inOrOut = inOrOut;
	}
	public Integer getInOrOut(){
		return inOrOut;
	}
	public void setPlatformUserId(String platformUserId){
		this.platformUserId = platformUserId;
	}
	public String getPlatformUserId(){
		return platformUserId;
	}
	public void setBalance(Double balance){
		this.balance = balance;
	}
	public Double getBalance(){
		return balance;
	}
	public void setSrcPlatformUserId(String srcPlatformUserId){
		this.srcPlatformUserId = srcPlatformUserId;
	}
	public String getSrcPlatformUserId(){
		return srcPlatformUserId;
	}
	public void setPayType(Integer payType){
		this.payType = payType;
	}
	public Integer getPayType(){
		return payType;
	}
	public void setPayWay(Integer payWay){
		this.payWay = payWay;
	}
	public Integer getPayWay(){
		return payWay;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public Integer getOrderStatus(){
		return orderStatus;
	}
	public void setOrderType(Integer orderType){
		this.orderType = orderType;
	}
	public Integer getOrderType(){
		return orderType;
	}
	public void setGrantStatus(Integer grantStatus){
		this.grantStatus = grantStatus;
	}
	public Integer getGrantStatus(){
		return grantStatus;
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
	public void setUpdator(String updator){
		this.updator = updator;
	}
	public String getUpdator(){
		return updator;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =737378853L;

}