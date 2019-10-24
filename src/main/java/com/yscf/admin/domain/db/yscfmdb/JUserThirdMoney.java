package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JUserThirdMoney implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer userId;/*用户id;len:10*/
	private Double amt;/*可用余额，等于third_avail_amt-lock_amt;len:15*/
	private Double freezeAmt;/*冻结金额（third_freeze_amt+lock_amt);len:15*/
	private Double lockAmt;/*锁定金额（系统）;len:15*/
	private Double thirdAvailAmt;/*可用余额（第三方）;len:15*/
	private Double thirdFreezeAmt;/*冻结金额（第三方）;len:15*/
	private Integer status;/*状态 1:有效  2：无效;len:0*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private Integer sync;/*0:不同步  1:同步;len:3*/
	private LocalDateTime syncTime;/*同步时间;len:19*/

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
	public void setAmt(Double amt){
		this.amt = amt;
	}
	public Double getAmt(){
		return amt;
	}
	public void setFreezeAmt(Double freezeAmt){
		this.freezeAmt = freezeAmt;
	}
	public Double getFreezeAmt(){
		return freezeAmt;
	}
	public void setLockAmt(Double lockAmt){
		this.lockAmt = lockAmt;
	}
	public Double getLockAmt(){
		return lockAmt;
	}
	public void setThirdAvailAmt(Double thirdAvailAmt){
		this.thirdAvailAmt = thirdAvailAmt;
	}
	public Double getThirdAvailAmt(){
		return thirdAvailAmt;
	}
	public void setThirdFreezeAmt(Double thirdFreezeAmt){
		this.thirdFreezeAmt = thirdFreezeAmt;
	}
	public Double getThirdFreezeAmt(){
		return thirdFreezeAmt;
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
	public void setSync(Integer sync){
		this.sync = sync;
	}
	public Integer getSync(){
		return sync;
	}
	public void setSyncTime(LocalDateTime syncTime){
		this.syncTime = syncTime;
	}
	public LocalDateTime getSyncTime(){
		return syncTime;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =353828014L;

}