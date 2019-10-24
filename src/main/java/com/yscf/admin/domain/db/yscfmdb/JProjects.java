package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JProjects implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private String projectTitle;/*项目标题;len:100*/
	private Integer productType;/*产品类型，对应j_product_type表id;len:10*/
	private Integer timeDayLimit;/*期数，以天为单位;len:5*/
	private Double amt;/*项目最小募集金额;len:15*/
	private Double apr;/*年利率，给投资人的收益;len:10*/
	private String onCode;/*挂牌代码;len:20*/
	private Integer repaymentType;/*还款方式，类别15;len:5*/
	private LocalDate finalRepyDt;/*最后还款日期;len:10*/
	private Double tenderAmt;/*已投金额，实时计算的;len:15*/
	private LocalDateTime fullTime;/*满标时间;len:19*/
	private Double userSingleMinPostAmt;/*用户单笔最低投资限额;len:10*/
	private Double serviceFeeRate;/*平台收取的佣金费率，保留字段;len:10*/
	private String description;/*项目描述;len:600*/
	private Integer collectDys;/*募集天数，保留字段;len:3*/
	private Integer projectStatus;/*项目状态（对应字典表catagory的13）;len:5*/
	private Integer status;/*状态，1：有效 2：无效;len:5*/
	private Integer extStatus;/* 0:正常 1：提前还款 2：流标  ，大于13400的都是处理中的状态。13400:流标处理中   13500: 投标处理中（13501-自动投标，13502-手动投标） 13700：项目还款操作处理中（13701-手动还款， 13702-提前还款， 13703-自动还款 13704-自动提前还款）;len:5*/
	private String creator;/*创建者姓名;len:10*/
	private String updator;/*更改者姓名;len:10*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private LocalDateTime pubTime;/*发布时间，即审核成功时间;len:19*/
	private LocalDateTime loanTime;/*放款时间（一般封闭日放款）;len:19*/
	private String loanStatus;/*放款状态，0：未放款  23：放款失败  24：放款成功;len:30*/
	private String pjSafeLevel;/*安全等级：A，B，C;len:1*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setProjectTitle(String projectTitle){
		this.projectTitle = projectTitle;
	}
	public String getProjectTitle(){
		return projectTitle;
	}
	public void setProductType(Integer productType){
		this.productType = productType;
	}
	public Integer getProductType(){
		return productType;
	}
	public void setTimeDayLimit(Integer timeDayLimit){
		this.timeDayLimit = timeDayLimit;
	}
	public Integer getTimeDayLimit(){
		return timeDayLimit;
	}
	public void setAmt(Double amt){
		this.amt = amt;
	}
	public Double getAmt(){
		return amt;
	}
	public void setApr(Double apr){
		this.apr = apr;
	}
	public Double getApr(){
		return apr;
	}
	public void setOnCode(String onCode){
		this.onCode = onCode;
	}
	public String getOnCode(){
		return onCode;
	}
	public void setRepaymentType(Integer repaymentType){
		this.repaymentType = repaymentType;
	}
	public Integer getRepaymentType(){
		return repaymentType;
	}
	public void setFinalRepyDt(LocalDate finalRepyDt){
		this.finalRepyDt = finalRepyDt;
	}
	public LocalDate getFinalRepyDt(){
		return finalRepyDt;
	}
	public void setTenderAmt(Double tenderAmt){
		this.tenderAmt = tenderAmt;
	}
	public Double getTenderAmt(){
		return tenderAmt;
	}
	public void setFullTime(LocalDateTime fullTime){
		this.fullTime = fullTime;
	}
	public LocalDateTime getFullTime(){
		return fullTime;
	}
	public void setUserSingleMinPostAmt(Double userSingleMinPostAmt){
		this.userSingleMinPostAmt = userSingleMinPostAmt;
	}
	public Double getUserSingleMinPostAmt(){
		return userSingleMinPostAmt;
	}
	public void setServiceFeeRate(Double serviceFeeRate){
		this.serviceFeeRate = serviceFeeRate;
	}
	public Double getServiceFeeRate(){
		return serviceFeeRate;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public void setCollectDys(Integer collectDys){
		this.collectDys = collectDys;
	}
	public Integer getCollectDys(){
		return collectDys;
	}
	public void setProjectStatus(Integer projectStatus){
		this.projectStatus = projectStatus;
	}
	public Integer getProjectStatus(){
		return projectStatus;
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
	public void setCreator(String creator){
		this.creator = creator;
	}
	public String getCreator(){
		return creator;
	}
	public void setUpdator(String updator){
		this.updator = updator;
	}
	public String getUpdator(){
		return updator;
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
	public void setPubTime(LocalDateTime pubTime){
		this.pubTime = pubTime;
	}
	public LocalDateTime getPubTime(){
		return pubTime;
	}
	public void setLoanTime(LocalDateTime loanTime){
		this.loanTime = loanTime;
	}
	public LocalDateTime getLoanTime(){
		return loanTime;
	}
	public void setLoanStatus(String loanStatus){
		this.loanStatus = loanStatus;
	}
	public String getLoanStatus(){
		return loanStatus;
	}
	public void setPjSafeLevel(String pjSafeLevel){
		this.pjSafeLevel = pjSafeLevel;
	}
	public String getPjSafeLevel(){
		return pjSafeLevel;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =683438260L;

}