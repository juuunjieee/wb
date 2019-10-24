package com.ulwxbase.domain.db.sys;

import com.ulwx.tool.ObjectUtils;

import java.time.LocalDateTime;

/*********************************************
后台用户错误次数限制表格
***********************************************/
public class SysUsersLock implements java.io.Serializable {

	private Integer sysUserId;/*后台用户id;len:10*/
	private Integer passCnt;/*密码输入错误的次数;len:10*/
	private LocalDateTime lastTime;/*最后一次输入错误时间;len:19*/
	private LocalDateTime firstTime;/*密码输入错误的第一次时间;len:19*/

	public void setSysUserId(Integer sysUserId){
		this.sysUserId = sysUserId;
	}
	public Integer getSysUserId(){
		return sysUserId;
	}
	public void setPassCnt(Integer passCnt){
		this.passCnt = passCnt;
	}
	public Integer getPassCnt(){
		return passCnt;
	}
	public void setLastTime(LocalDateTime lastTime){
		this.lastTime = lastTime;
	}
	public LocalDateTime getLastTime(){
		return lastTime;
	}
	public void setFirstTime(LocalDateTime firstTime){
		this.firstTime = firstTime;
	}
	public LocalDateTime getFirstTime(){
		return firstTime;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-1382224157L;

}