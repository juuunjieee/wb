package com.yscf.admin.domain.db.yscfmdb;
import java.util.*;
import java.sql.*;
import java.time.*;
import com.ulwx.tool.ObjectUtils;

/*********************************************

***********************************************/
public class JProductType implements java.io.Serializable {

	private Integer id;/*流水号;len:10*/
	private String name;/*产品类型名称;len:30*/
	private Integer assetType;/*资产类型  category=92;len:5*/
	private Integer productMode;/*产品模式 category=91， 600 ：有限合伙， 601：私募，602：保险  603：信托 604：公募 等;len:3*/
	private Integer productIssuerId;/*产品发行方id，对应j_product_issuer表id;len:10*/
	private String serviceDescripHtml;/*此类别产品业务描述,html格式，用富文本编辑;len:1000*/
	private String contractThymeleafTplUrl;/*合同模板的url地址，合同模板使用thymeleaf模板;len:128*/
	private String defaultRiskStep;/*风控措施;len:300*/
	private String defaultGuardStep;/*保障错误;len:300*/
	private String extConfig;/*扩展配置信息，扩展字段;len:100*/

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
	public void setAssetType(Integer assetType){
		this.assetType = assetType;
	}
	public Integer getAssetType(){
		return assetType;
	}
	public void setProductMode(Integer productMode){
		this.productMode = productMode;
	}
	public Integer getProductMode(){
		return productMode;
	}
	public void setProductIssuerId(Integer productIssuerId){
		this.productIssuerId = productIssuerId;
	}
	public Integer getProductIssuerId(){
		return productIssuerId;
	}
	public void setServiceDescripHtml(String serviceDescripHtml){
		this.serviceDescripHtml = serviceDescripHtml;
	}
	public String getServiceDescripHtml(){
		return serviceDescripHtml;
	}
	public void setContractThymeleafTplUrl(String contractThymeleafTplUrl){
		this.contractThymeleafTplUrl = contractThymeleafTplUrl;
	}
	public String getContractThymeleafTplUrl(){
		return contractThymeleafTplUrl;
	}
	public void setDefaultRiskStep(String defaultRiskStep){
		this.defaultRiskStep = defaultRiskStep;
	}
	public String getDefaultRiskStep(){
		return defaultRiskStep;
	}
	public void setDefaultGuardStep(String defaultGuardStep){
		this.defaultGuardStep = defaultGuardStep;
	}
	public String getDefaultGuardStep(){
		return defaultGuardStep;
	}
	public void setExtConfig(String extConfig){
		this.extConfig = extConfig;
	}
	public String getExtConfig(){
		return extConfig;
	}

	public String toString(){
		return  ObjectUtils.toString(this);
	}

	private static final long serialVersionUID =1669934660L;

}