package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JBanners implements java.io.Serializable {

	private Integer id;/*id;len:10*/
	private String image;/*图片地址;len:200*/
	private String imageS;/*略缩图;len:200*/
	private String url;/*URL;len:200*/
	private Integer type;/*类型,category=5;len:10*/
	private Integer apply;/*1:PC 2:微站 3:app;len:3*/
	private Integer orderCode;/*排序码;len:10*/
	private Integer status;/*状态 0：未审核  1：有效  2：无效;len:10*/
	private String creator;/*创建者;len:11*/
	private LocalDateTime modifyTime;/*修改时间;len:19*/
	private LocalDateTime createTime;/*创建时间;len:19*/

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setImage(String image){
		this.image = image;
	}
	public String getImage(){
		return image;
	}
	public void setImageS(String imageS){
		this.imageS = imageS;
	}
	public String getImageS(){
		return imageS;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return url;
	}
	public void setType(Integer type){
		this.type = type;
	}
	public Integer getType(){
		return type;
	}
	public void setApply(Integer apply){
		this.apply = apply;
	}
	public Integer getApply(){
		return apply;
	}
	public void setOrderCode(Integer orderCode){
		this.orderCode = orderCode;
	}
	public Integer getOrderCode(){
		return orderCode;
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

	private static final long serialVersionUID =812615671L;

}