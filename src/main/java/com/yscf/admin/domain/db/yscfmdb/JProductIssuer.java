package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JProductIssuer implements java.io.Serializable {

	private Integer id;/*;len:10*/
	private String name;/*发行方名称;len:30*/
	private Integer type;/*1：个人  2：企业;len:3*/
	private String address;/*地址;len:50*/
	private String contactMan;/*联系人姓名;len:20*/
	private String contactMobile;/*联系人手机号码;len:20*/
	private String fileZipUrl;/*资质证明文件zip包，可以浏览里面的文件;len:120*/
	private LocalDateTime creatime;/*创建时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setType(Integer type){
		this.type = type;
	}
	public Integer getType(){
		return type;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	public void setContactMan(String contactMan){
		this.contactMan = contactMan;
	}
	public String getContactMan(){
		return contactMan;
	}
	public void setContactMobile(String contactMobile){
		this.contactMobile = contactMobile;
	}
	public String getContactMobile(){
		return contactMobile;
	}
	public void setFileZipUrl(String fileZipUrl){
		this.fileZipUrl = fileZipUrl;
	}
	public String getFileZipUrl(){
		return fileZipUrl;
	}
	public void setCreatime(LocalDateTime creatime){
		this.creatime = creatime;
	}
	public LocalDateTime getCreatime(){
		return creatime;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-1558075261L;

}