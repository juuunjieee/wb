package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JPayOrder implements java.io.Serializable {

	private Long id;/*id;len:19*/
	private String orderNo;/*订单号;len:30*/
	private LocalDate orderDate;/*订单日期;len:10*/
	private Double transAmt;/*交易金额;len:15*/
	private Integer userId;/*用户id;len:10*/
	private Integer payType;/*支付公司，对应category=95，针对充值才有效果;len:5*/
	private Integer payWay;/*支付方式  1；快捷 2：网银;len:5*/
	private Integer orderStatus;/*订单状态,对应category=11;len:5*/
	private Integer orderType;/*订单类型， 对应j_dic_category的id=12;len:5*/
	private Integer grantStatus;/*0：不需要审核。财务独立发放模式：3=待财务审核 ,2=财务已审核（待财务发放），1=财务已发放 。财务审核用户收取模式： 13=待财务审核，12=财务已审核（待用户收取） 11=用户已收取;len:5*/
	private String sceneIdStr;/*场景标识（例如为活动标识），根据order_type不同含义不同;len:30*/
	private String forDetailTbName;/*查询详情的表名，根据order_type不同，访问的表不同;len:20*/
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
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return userId;
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
	public void setSceneIdStr(String sceneIdStr){
		this.sceneIdStr = sceneIdStr;
	}
	public String getSceneIdStr(){
		return sceneIdStr;
	}
	public void setForDetailTbName(String forDetailTbName){
		this.forDetailTbName = forDetailTbName;
	}
	public String getForDetailTbName(){
		return forDetailTbName;
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

	private static final long serialVersionUID =131809127L;

}