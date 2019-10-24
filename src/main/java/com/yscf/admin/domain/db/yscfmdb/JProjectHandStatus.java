package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JProjectHandStatus implements java.io.Serializable {

	private Integer id;/*流水;len:10*/
	private Integer projectId;/*项目id;len:10*/
	private String matchId;/*扩展匹配id，比如项目期数;len:60*/
	private Integer htype;/*1：自动放款 3：自动还款;len:10*/
	private String orderno;/*订单号;len:30*/
	private Integer step;/*步骤号，代码执行点标示，根据htype不同含义不同。;len:10*/
	private String stepStatusInf;/*代码执行点的状态信息;len:300*/
	private LocalDateTime startime;/*开始时间;len:19*/
	private LocalDateTime endtime;/*结束时间;len:19*/
	private Integer handleSec;/*处理的秒数;len:10*/
	private LocalDateTime versionTime;/*版本更新时间，用于乐观锁机制;len:19*/
	private Integer handStatus;/*0:初始 , 24：处理完成(不可重复执行）,25：处理完成（可重复执行），23：执行失败, 134：处理中;len:10*/

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
	public void setMatchId(String matchId){
		this.matchId = matchId;
	}
	public String getMatchId(){
		return matchId;
	}
	public void setHtype(Integer htype){
		this.htype = htype;
	}
	public Integer getHtype(){
		return htype;
	}
	public void setOrderno(String orderno){
		this.orderno = orderno;
	}
	public String getOrderno(){
		return orderno;
	}
	public void setStep(Integer step){
		this.step = step;
	}
	public Integer getStep(){
		return step;
	}
	public void setStepStatusInf(String stepStatusInf){
		this.stepStatusInf = stepStatusInf;
	}
	public String getStepStatusInf(){
		return stepStatusInf;
	}
	public void setStartime(LocalDateTime startime){
		this.startime = startime;
	}
	public LocalDateTime getStartime(){
		return startime;
	}
	public void setEndtime(LocalDateTime endtime){
		this.endtime = endtime;
	}
	public LocalDateTime getEndtime(){
		return endtime;
	}
	public void setHandleSec(Integer handleSec){
		this.handleSec = handleSec;
	}
	public Integer getHandleSec(){
		return handleSec;
	}
	public void setVersionTime(LocalDateTime versionTime){
		this.versionTime = versionTime;
	}
	public LocalDateTime getVersionTime(){
		return versionTime;
	}
	public void setHandStatus(Integer handStatus){
		this.handStatus = handStatus;
	}
	public Integer getHandStatus(){
		return handStatus;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-1414237620L;

}