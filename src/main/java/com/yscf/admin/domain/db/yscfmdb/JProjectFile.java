package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JProjectFile implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer projectId;/*项目id;len:10*/
	private Integer fileType;/*项目文件类型，category=18;len:10*/
	private String fileUrl;/*文件路径（有可能是图片路径）;len:200*/
	private Integer showType;/*1:网站显示 2：网站不显示;len:3*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private String creator;/*创建者姓名;len:10*/
	private String updator;/*更改者姓名;len:10*/
	private Integer status;/*状态 1：有效 2：无效（假删除）;len:10*/

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
	public void setFileType(Integer fileType){
		this.fileType = fileType;
	}
	public Integer getFileType(){
		return fileType;
	}
	public void setFileUrl(String fileUrl){
		this.fileUrl = fileUrl;
	}
	public String getFileUrl(){
		return fileUrl;
	}
	public void setShowType(Integer showType){
		this.showType = showType;
	}
	public Integer getShowType(){
		return showType;
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
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =2146107548L;

}