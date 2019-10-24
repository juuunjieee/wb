package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SlSaleUsersFrom implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private Integer investNetUserId;/*推荐的投资客户网站id;len:10*/
	private String investNetUserName;/*推荐的投资客户姓名;len:10*/
	private String investNetUserPhone;/*推荐的投资客户的手机号码;len:13*/
	private LocalDate investNetUserBirth;/*投资客户年龄;len:10*/
	private String investNetUserSex;/*男，女，未知;len:2*/
	private Integer recmdNetUserId;/*推荐人（理财人员）网站用户id;len:10*/
	private Integer recmdFinSysUserId;/*推荐人员（理财人员）系统id，可能是理财主管，理财总监;len:10*/
	private Integer recmdFinRoletype;/*推荐人员（理财人员）角色类型;len:10*/
	private Integer finZgUserId;/*理财主管id;len:10*/
	private Integer finJlSysUserId;/*理财总监id;len:10*/
	private Integer finDepartId;/*理财部id;len:10*/
	private Integer status;/*1:有效  2:无效;len:3*/
	private LocalDateTime createTime;/*建立时间;len:19*/
	private LocalDateTime updateTime;/*更新时间;len:19*/

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
	public void setInvestNetUserName(String investNetUserName){
		this.investNetUserName = investNetUserName;
	}
	public String getInvestNetUserName(){
		return investNetUserName;
	}
	public void setInvestNetUserPhone(String investNetUserPhone){
		this.investNetUserPhone = investNetUserPhone;
	}
	public String getInvestNetUserPhone(){
		return investNetUserPhone;
	}
	public void setInvestNetUserBirth(LocalDate investNetUserBirth){
		this.investNetUserBirth = investNetUserBirth;
	}
	public LocalDate getInvestNetUserBirth(){
		return investNetUserBirth;
	}
	public void setInvestNetUserSex(String investNetUserSex){
		this.investNetUserSex = investNetUserSex;
	}
	public String getInvestNetUserSex(){
		return investNetUserSex;
	}
	public void setRecmdNetUserId(Integer recmdNetUserId){
		this.recmdNetUserId = recmdNetUserId;
	}
	public Integer getRecmdNetUserId(){
		return recmdNetUserId;
	}
	public void setRecmdFinSysUserId(Integer recmdFinSysUserId){
		this.recmdFinSysUserId = recmdFinSysUserId;
	}
	public Integer getRecmdFinSysUserId(){
		return recmdFinSysUserId;
	}
	public void setRecmdFinRoletype(Integer recmdFinRoletype){
		this.recmdFinRoletype = recmdFinRoletype;
	}
	public Integer getRecmdFinRoletype(){
		return recmdFinRoletype;
	}
	public void setFinZgUserId(Integer finZgUserId){
		this.finZgUserId = finZgUserId;
	}
	public Integer getFinZgUserId(){
		return finZgUserId;
	}
	public void setFinJlSysUserId(Integer finJlSysUserId){
		this.finJlSysUserId = finJlSysUserId;
	}
	public Integer getFinJlSysUserId(){
		return finJlSysUserId;
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
	public void setCreateTime(LocalDateTime createTime){
		this.createTime = createTime;
	}
	public LocalDateTime getCreateTime(){
		return createTime;
	}
	public void setUpdateTime(LocalDateTime updateTime){
		this.updateTime = updateTime;
	}
	public LocalDateTime getUpdateTime(){
		return updateTime;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-844526440L;

}