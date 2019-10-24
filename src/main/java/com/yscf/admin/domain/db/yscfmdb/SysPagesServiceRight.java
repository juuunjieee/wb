package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SysPagesServiceRight implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private Integer pageId;/*页面id;len:10*/
	private Integer serviceRightCode;/*权限点code，对应sys_service_right的right_code;len:10*/
	private LocalDateTime updatime;/*;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setPageId(Integer pageId){
		this.pageId = pageId;
	}
	public Integer getPageId(){
		return pageId;
	}
	public void setServiceRightCode(Integer serviceRightCode){
		this.serviceRightCode = serviceRightCode;
	}
	public Integer getServiceRightCode(){
		return serviceRightCode;
	}
	public void setUpdatime(LocalDateTime updatime){
		this.updatime = updatime;
	}
	public LocalDateTime getUpdatime(){
		return updatime;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =418055786L;

}