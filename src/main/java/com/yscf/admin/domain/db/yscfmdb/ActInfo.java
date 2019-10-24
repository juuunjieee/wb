package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class ActInfo implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private String activeIdStr;/*活动ID标识，手工输入的，格式年月日，如：20190902;len:30*/
	private String smallPicUrl;/*小图片URL;len:150*/
	private String activeTitle;/*活动标题;len:50*/
	private String descrip;/*活动描述;len:500*/
	private Integer type;/*j_dic_category=93;len:10*/
	private String contentUrl;/*PC内容URL，即点击活动的内容URL地址;len:150*/
	private String mobileContentUrl;/*微站内容URL，即点击活动的内容URL地址;len:150*/
	private String appContentUrl;/*APP内容URL，即点击活动的内容URL地址;len:150*/
	private LocalDate startDate;/*活动页面显示开始日期;len:10*/
	private LocalDate endDate;/*活动页面显示结束日期;len:10*/
	private Integer status;/*状态 0：未审核 1:有效  2：无效;len:10*/
	private LocalDateTime updatime;/*更新时间;len:19*/
	private String updator;/*更新人;len:10*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setActiveIdStr(String activeIdStr){
		this.activeIdStr = activeIdStr;
	}
	public String getActiveIdStr(){
		return activeIdStr;
	}
	public void setSmallPicUrl(String smallPicUrl){
		this.smallPicUrl = smallPicUrl;
	}
	public String getSmallPicUrl(){
		return smallPicUrl;
	}
	public void setActiveTitle(String activeTitle){
		this.activeTitle = activeTitle;
	}
	public String getActiveTitle(){
		return activeTitle;
	}
	public void setDescrip(String descrip){
		this.descrip = descrip;
	}
	public String getDescrip(){
		return descrip;
	}
	public void setType(Integer type){
		this.type = type;
	}
	public Integer getType(){
		return type;
	}
	public void setContentUrl(String contentUrl){
		this.contentUrl = contentUrl;
	}
	public String getContentUrl(){
		return contentUrl;
	}
	public void setMobileContentUrl(String mobileContentUrl){
		this.mobileContentUrl = mobileContentUrl;
	}
	public String getMobileContentUrl(){
		return mobileContentUrl;
	}
	public void setAppContentUrl(String appContentUrl){
		this.appContentUrl = appContentUrl;
	}
	public String getAppContentUrl(){
		return appContentUrl;
	}
	public void setStartDate(LocalDate startDate){
		this.startDate = startDate;
	}
	public LocalDate getStartDate(){
		return startDate;
	}
	public void setEndDate(LocalDate endDate){
		this.endDate = endDate;
	}
	public LocalDate getEndDate(){
		return endDate;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setUpdatime(LocalDateTime updatime){
		this.updatime = updatime;
	}
	public LocalDateTime getUpdatime(){
		return updatime;
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

	private static final long serialVersionUID =53301312L;

}