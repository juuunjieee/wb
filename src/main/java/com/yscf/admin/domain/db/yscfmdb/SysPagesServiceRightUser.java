package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SysPagesServiceRightUser implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private Integer pageServiceRightId;/*页面权限点id，对应sys_pages_service_right的id;len:10*/
	private Integer sysUserId;/*系统用户id，对应sys_user表id;len:10*/
	private LocalDateTime updatime;/*;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setPageServiceRightId(Integer pageServiceRightId){
		this.pageServiceRightId = pageServiceRightId;
	}
	public Integer getPageServiceRightId(){
		return pageServiceRightId;
	}
	public void setSysUserId(Integer sysUserId){
		this.sysUserId = sysUserId;
	}
	public Integer getSysUserId(){
		return sysUserId;
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

	private static final long serialVersionUID =-1375812246L;

}