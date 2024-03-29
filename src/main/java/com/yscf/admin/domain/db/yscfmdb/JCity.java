package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JCity implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private Integer code;/*城市代码;len:10*/
	private String name;/*城市名称;len:200*/
	private Integer provinceCode;/*省份代码;len:10*/
	private Integer state;/*状态：1=活动、2=非活动;len:0*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setCode(Integer code){
		this.code = code;
	}
	public Integer getCode(){
		return code;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setProvinceCode(Integer provinceCode){
		this.provinceCode = provinceCode;
	}
	public Integer getProvinceCode(){
		return provinceCode;
	}
	public void setState(Integer state){
		this.state = state;
	}
	public Integer getState(){
		return state;
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

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-22130651L;

}