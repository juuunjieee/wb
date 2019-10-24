package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JDic implements java.io.Serializable {

	private Integer id;/*id;len:5*/
	private Integer category;/*类别id;len:10*/
	private String dicName;/*名称;len:20*/
	private String remark;/*备注;len:50*/
	private Integer sort;/*排序;len:5*/
	private Integer value;/*值(如果category为29，-1表示出，1表示入);len:5*/
	private Integer status;/*1:有效  2：无效;len:3*/
	private Integer display;/*0:不展示 1：展示;len:3*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setCategory(Integer category){
		this.category = category;
	}
	public Integer getCategory(){
		return category;
	}
	public void setDicName(String dicName){
		this.dicName = dicName;
	}
	public String getDicName(){
		return dicName;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setSort(Integer sort){
		this.sort = sort;
	}
	public Integer getSort(){
		return sort;
	}
	public void setValue(Integer value){
		this.value = value;
	}
	public Integer getValue(){
		return value;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setDisplay(Integer display){
		this.display = display;
	}
	public Integer getDisplay(){
		return display;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =1183799086L;

}