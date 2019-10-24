package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JFriendlink implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private String name;/*友情链接名称;len:200*/
	private String url;/*友情链接地址;len:100*/
	private Integer status;/*状态;len:10*/
	private String creator;/*创建人;len:10*/
	private String modifier;/*修改人;len:10*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/

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
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return url;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setCreator(String creator){
		this.creator = creator;
	}
	public String getCreator(){
		return creator;
	}
	public void setModifier(String modifier){
		this.modifier = modifier;
	}
	public String getModifier(){
		return modifier;
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

	private static final long serialVersionUID =258564754L;

}