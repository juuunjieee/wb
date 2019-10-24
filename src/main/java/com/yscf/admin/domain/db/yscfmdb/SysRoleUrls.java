package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SysRoleUrls implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private Integer roleId;/*角色id;len:10*/
	private String urlMatch;/*url后缀匹配，如果配置/开始的url，则表示前缀匹配；如果非/开始，则为后缀匹配，后缀匹配可以用正则。;len:1000*/
	private LocalDateTime updatime;/*更新时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	public Integer getRoleId(){
		return roleId;
	}
	public void setUrlMatch(String urlMatch){
		this.urlMatch = urlMatch;
	}
	public String getUrlMatch(){
		return urlMatch;
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

	private static final long serialVersionUID =-1967851488L;

}