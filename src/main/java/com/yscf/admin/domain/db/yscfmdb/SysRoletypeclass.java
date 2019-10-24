package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SysRoletypeclass implements java.io.Serializable {

	private Integer code;/*id;len:3*/
	private String className;/*类别名称;len:40*/

	public void setCode(Integer code){
		this.code = code;
	}
	public Integer getCode(){
		return code;
	}
	public void setClassName(String className){
		this.className = className;
	}
	public String getClassName(){
		return className;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =-1550824229L;

}