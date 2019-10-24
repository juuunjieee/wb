package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JArticles implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private String title;/*标题;len:200*/
	private String keyword;/*关键字;len:200*/
	private Integer type;/*文章类型 category=6;len:10*/
	private String content;/*文章内容;len:7000*/
	private String remark;/*摘要;len:60*/
	private String fileUrl;/*图片URL;len:200*/
	private String jumpUrl;/*文章特定跳转路径url,一般用于活动指定跳转路径用;len:200*/
	private Integer isHot;/*是否是热门问题？0:否 1：是 默认0否;len:3*/
	private Integer status;/*状态 0：未审核  1：有效 2：无效;len:10*/
	private String updator;/*创建者;len:10*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private Integer sortCode;/*排序码;len:10*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
	public String getKeyword(){
		return keyword;
	}
	public void setType(Integer type){
		this.type = type;
	}
	public Integer getType(){
		return type;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return content;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setFileUrl(String fileUrl){
		this.fileUrl = fileUrl;
	}
	public String getFileUrl(){
		return fileUrl;
	}
	public void setJumpUrl(String jumpUrl){
		this.jumpUrl = jumpUrl;
	}
	public String getJumpUrl(){
		return jumpUrl;
	}
	public void setIsHot(Integer isHot){
		this.isHot = isHot;
	}
	public Integer getIsHot(){
		return isHot;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
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
	public void setSortCode(Integer sortCode){
		this.sortCode = sortCode;
	}
	public Integer getSortCode(){
		return sortCode;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =20209271L;

}