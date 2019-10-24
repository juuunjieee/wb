package com.ulwxbase.domain.db.sys;

import com.ulwx.tool.ObjectUtils;

import java.time.LocalDateTime;

/*********************************************

***********************************************/
public class SysRight implements java.io.Serializable {

	private String sysRightCode;/*权限编码;len:60*/
	private String sysRightName;/*权限名称;len:90*/
	private String sysRightUrl;/*URL;len:240*/
	private String icon;/*icon;len:120*/
	private Integer enable;/*是否有效 0：无效  1：有效;len:10*/
	private Integer orderCode;/*排序码;len:10*/
	private LocalDateTime updateTime;/*更新时间;len:19*/
	private String updator;/*更新人;len:90*/

	public void setSysRightCode(String sysRightCode){
		this.sysRightCode = sysRightCode;
	}
	public String getSysRightCode(){
		return sysRightCode;
	}
	public void setSysRightName(String sysRightName){
		this.sysRightName = sysRightName;
	}
	public String getSysRightName(){
		return sysRightName;
	}
	public void setSysRightUrl(String sysRightUrl){
		this.sysRightUrl = sysRightUrl;
	}
	public String getSysRightUrl(){
		return sysRightUrl;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
	public String getIcon(){
		return icon;
	}
	public void setEnable(Integer enable){
		this.enable = enable;
	}
	public Integer getEnable(){
		return enable;
	}
	public void setOrderCode(Integer orderCode){
		this.orderCode = orderCode;
	}
	public Integer getOrderCode(){
		return orderCode;
	}
	public void setUpdateTime(LocalDateTime updateTime){
		this.updateTime = updateTime;
	}
	public LocalDateTime getUpdateTime(){
		return updateTime;
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

	private static final long serialVersionUID =-22363175L;

}