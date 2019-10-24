package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JUsers implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private String username;/*用户名;len:20*/
	private String password;/*登陆密码;len:200*/
	private Integer type;/*categroy=7,类型：15投资人;len:5*/
	private Integer userType;/*1:自然人 2：企业;len:3*/
	private Integer submited;/*0：未开通存管 1：已经成功开通存管;len:3*/
	private String realname;/*姓名;len:30*/
	private Integer sex;/*性别 0：未知  8:女  9:男;len:3*/
	private String idcard;/*身份证号;len:50*/
	private String mobile;/*手机号码;len:13*/
	private Integer province;/*省code，对应j_province里的code;len:10*/
	private Integer city;/*城市code，对应j_city里的code;len:10*/
	private String address;/*地址;len:200*/
	private String income;/*月收入;len:30*/
	private Integer source;/*用户注册来源，对应j_dic_category=34;len:5*/
	private String email;/*邮箱;len:50*/
	private LocalDate birthday;/*出生日期;len:10*/
	private Integer marryCondition;/*婚姻 0:未婚 1:已婚;len:5*/
	private String houseCondition;/*房产;len:30*/
	private String remark;/*备注;len:60*/
	private Integer status;/*状态;len:5*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	public void setType(Integer type){
		this.type = type;
	}
	public Integer getType(){
		return type;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	public Integer getUserType(){
		return userType;
	}
	public void setSubmited(Integer submited){
		this.submited = submited;
	}
	public Integer getSubmited(){
		return submited;
	}
	public void setRealname(String realname){
		this.realname = realname;
	}
	public String getRealname(){
		return realname;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public Integer getSex(){
		return sex;
	}
	public void setIdcard(String idcard){
		this.idcard = idcard;
	}
	public String getIdcard(){
		return idcard;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return mobile;
	}
	public void setProvince(Integer province){
		this.province = province;
	}
	public Integer getProvince(){
		return province;
	}
	public void setCity(Integer city){
		this.city = city;
	}
	public Integer getCity(){
		return city;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	public void setIncome(String income){
		this.income = income;
	}
	public String getIncome(){
		return income;
	}
	public void setSource(Integer source){
		this.source = source;
	}
	public Integer getSource(){
		return source;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	public void setBirthday(LocalDate birthday){
		this.birthday = birthday;
	}
	public LocalDate getBirthday(){
		return birthday;
	}
	public void setMarryCondition(Integer marryCondition){
		this.marryCondition = marryCondition;
	}
	public Integer getMarryCondition(){
		return marryCondition;
	}
	public void setHouseCondition(String houseCondition){
		this.houseCondition = houseCondition;
	}
	public String getHouseCondition(){
		return houseCondition;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
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

	private static final long serialVersionUID =-164185608L;

}