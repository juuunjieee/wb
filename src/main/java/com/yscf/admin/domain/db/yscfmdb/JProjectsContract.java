package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JProjectsContract implements java.io.Serializable {

	private Integer id;/*流水号id;len:10*/
	private Integer projectId;/*项目id;len:10*/
	private Integer contractStatus;/*合同项目状态：1.签订完成，2.未签订完成;len:3*/
	private LocalDateTime createTime;/*创建时间;len:19*/
	private Integer createId;/*创建人;len:10*/
	private LocalDateTime updateTime;/*更新时间;len:19*/
	private Integer updateId;/*更新人;len:10*/

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
	public void setContractStatus(Integer contractStatus){
		this.contractStatus = contractStatus;
	}
	public Integer getContractStatus(){
		return contractStatus;
	}
	public void setCreateTime(LocalDateTime createTime){
		this.createTime = createTime;
	}
	public LocalDateTime getCreateTime(){
		return createTime;
	}
	public void setCreateId(Integer createId){
		this.createId = createId;
	}
	public Integer getCreateId(){
		return createId;
	}
	public void setUpdateTime(LocalDateTime updateTime){
		this.updateTime = updateTime;
	}
	public LocalDateTime getUpdateTime(){
		return updateTime;
	}
	public void setUpdateId(Integer updateId){
		this.updateId = updateId;
	}
	public Integer getUpdateId(){
		return updateId;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-1120650585L;

}