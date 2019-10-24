package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JPlatformAccount implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private String platformUserNo;/*平台用户编号;len:20*/
	private String name;/*名称;len:20*/
	private String cardNo;/*银行卡号;len:50*/
	private String mobile;/*手机号码;len:20*/
	private String contactor;/*联系人;len:10*/
	private String bankCode;/*银行编码;len:10*/
	private Integer bandcard;/*是否绑卡  1：已绑卡  0：未绑卡;len:5*/
	private Integer status;/*状态;len:5*/
	private LocalDateTime mofityTime;/*更新时间;len:19*/
	private String alterOrderNo;/*修改订单号;len:30*/
	private Integer alertStatus;/*23:失败  24：成功 134：处理中;len:5*/
	private String updator;/*更新人;len:10*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setPlatformUserNo(String platformUserNo){
		this.platformUserNo = platformUserNo;
	}
	public String getPlatformUserNo(){
		return platformUserNo;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setCardNo(String cardNo){
		this.cardNo = cardNo;
	}
	public String getCardNo(){
		return cardNo;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return mobile;
	}
	public void setContactor(String contactor){
		this.contactor = contactor;
	}
	public String getContactor(){
		return contactor;
	}
	public void setBankCode(String bankCode){
		this.bankCode = bankCode;
	}
	public String getBankCode(){
		return bankCode;
	}
	public void setBandcard(Integer bandcard){
		this.bandcard = bandcard;
	}
	public Integer getBandcard(){
		return bandcard;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setMofityTime(LocalDateTime mofityTime){
		this.mofityTime = mofityTime;
	}
	public LocalDateTime getMofityTime(){
		return mofityTime;
	}
	public void setAlterOrderNo(String alterOrderNo){
		this.alterOrderNo = alterOrderNo;
	}
	public String getAlterOrderNo(){
		return alterOrderNo;
	}
	public void setAlertStatus(Integer alertStatus){
		this.alertStatus = alertStatus;
	}
	public Integer getAlertStatus(){
		return alertStatus;
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

	private static final long serialVersionUID =-752390757L;

}