package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class ActZip implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private String zipName;/*名称;len:30*/
	private String fileDir;/*相对地址;len:100*/
	private String mainName;/*主入口文件名;len:50*/
	private LocalDateTime updatime;/*更新时间;len:19*/
	private String updator;/*更新人;len:10*/
	private Integer status;/*状态：1：有效，2：无效;len:10*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setZipName(String zipName){
		this.zipName = zipName;
	}
	public String getZipName(){
		return zipName;
	}
	public void setFileDir(String fileDir){
		this.fileDir = fileDir;
	}
	public String getFileDir(){
		return fileDir;
	}
	public void setMainName(String mainName){
		this.mainName = mainName;
	}
	public String getMainName(){
		return mainName;
	}
	public void setUpdatime(LocalDateTime updatime){
		this.updatime = updatime;
	}
	public LocalDateTime getUpdatime(){
		return updatime;
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

	private static final long serialVersionUID =302178809L;

}