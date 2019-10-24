package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class SlFinanceDepart implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private String departName;/*部门名称;len:20*/
	private Integer departType;/*1：外部 2：主营 3：虚拟;len:3*/
	private Double jlRewardRate;/*理财顾问经理提成比率，百分率;len:10*/
	private Double zgRewardRate;/*理财顾问主管提成比例，百分率;len:10*/
	private Double zyRewardRate;/*理财顾问专员收益比率，百分率;len:10*/
	private LocalDateTime updatime;/*更新时间;len:19*/
	private String updator;/*更新人姓名;len:10*/
	private Integer status;/*状态：1.有效 2.无效;len:3*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setDepartName(String departName){
		this.departName = departName;
	}
	public String getDepartName(){
		return departName;
	}
	public void setDepartType(Integer departType){
		this.departType = departType;
	}
	public Integer getDepartType(){
		return departType;
	}
	public void setJlRewardRate(Double jlRewardRate){
		this.jlRewardRate = jlRewardRate;
	}
	public Double getJlRewardRate(){
		return jlRewardRate;
	}
	public void setZgRewardRate(Double zgRewardRate){
		this.zgRewardRate = zgRewardRate;
	}
	public Double getZgRewardRate(){
		return zgRewardRate;
	}
	public void setZyRewardRate(Double zyRewardRate){
		this.zyRewardRate = zyRewardRate;
	}
	public Double getZyRewardRate(){
		return zyRewardRate;
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

	private static final long serialVersionUID =684957348L;

}