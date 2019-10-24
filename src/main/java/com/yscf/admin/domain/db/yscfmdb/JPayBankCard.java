package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JPayBankCard implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer userId;/*用户id;len:10*/
	private String cardNo;/*银行卡卡号;len:50*/
	private String bankCode;/*银行卡代码;len:10*/
	private String phone;/*手机号码(银行预留手机号);len:50*/
	private String realName;/*实名认证的名字;len:30*/
	private Integer bandcard;/*是否绑卡  1：已绑卡  0：未绑卡;len:5*/
	private Integer payType;/*存管类型，对应j_dic_categoy=94;len:10*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间(也为存管实名注册时间);len:19*/
	private String updator;/*更新人姓名;len:10*/
	private Integer status;/*状态 1:有效 2:无效 0:初始;len:10*/

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
	public void setCardNo(String cardNo){
		this.cardNo = cardNo;
	}
	public String getCardNo(){
		return cardNo;
	}
	public void setBankCode(String bankCode){
		this.bankCode = bankCode;
	}
	public String getBankCode(){
		return bankCode;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setRealName(String realName){
		this.realName = realName;
	}
	public String getRealName(){
		return realName;
	}
	public void setBandcard(Integer bandcard){
		this.bandcard = bandcard;
	}
	public Integer getBandcard(){
		return bandcard;
	}
	public void setPayType(Integer payType){
		this.payType = payType;
	}
	public Integer getPayType(){
		return payType;
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
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-1498256052L;

}