package com.ulwxbase.web.action.sys;

import com.ulwx.tool.ObjectUtils;
import com.ulwx.tool.PageBean;
import com.ulwx.tool.RequestUtils;
import com.ulwxbase.domain.cus.CbEasyUICombobox;
import com.ulwxbase.domain.cus.CbEasyUIGridModel;
import com.ulwxbase.domain.db.sys.*;
import com.ulwxbase.web.action.CbBaseAction;
import com.ulwxbase.web.action.sys.domain.SysPagesAdminVo;
import com.ulwxbase.web.action.sys.domain.SysPagesVo;
import com.ulwxbase.web.action.sys.services.service.SysPagesService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SysPagesAction extends CbBaseAction{
	private static final long serialVersionUID = -1672970955045193907L;
	// 跳转页面指向，即从当前页面跳转到指定的页面
	private static Logger logger = Logger.getLogger(SysPagesAction.class);
	
	//获取页面列表
	public String getPageList() {
		RequestUtils ru = this.getRequestUtils();
		// 分页
		Integer pageNum = ru.getInt("page");
		Integer perPage = ru.getInt("rows");
		PageBean pb = new PageBean();
		
		String pageName = ru.getTrimString("pageName");
		
		CbEasyUIGridModel<SysPagesVo> model = new CbEasyUIGridModel<SysPagesVo>();
		List<SysPagesVo> pages = null;
		try {
			pages = SysPagesService.instance.getPageList(pageName, pageNum, perPage, pb);
			model.setRows(pages);
			model.setTotal(pb.getTotal());
			return this.SUC(model);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		return this.ERR("获取失败");
	}
	
	//新增权限页面
	public String AddPage() {
		RequestUtils ru = this.getRequestUtils();
		SysPages page = new SysPages();
		page = ObjectUtils.fromMapToJavaBean(page, ru.getrParms());
		int status = ru.getInt("statusName");
		page.setStatus(status);
		try {
			SysPagesService.instance.AddPage(page);
			return this.SUC("添加成功");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		return this.ERR("添加失败");
	}
	
	//修改
	public String updatePage() {
		RequestUtils ru = this.getRequestUtils();
		SysPages page = new SysPages();
		page = ObjectUtils.fromMapToJavaBean(page, ru.getrParms());
		int status = ru.getInt("statusName");
		page.setStatus(status);
		try {
			SysPagesService.instance.updatePage(page);
			return this.SUC("修改成功");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		return this.ERR("修改失败");
	}
	
	//获取用户和分配的页面
	public String getPageAdminList() {
		RequestUtils ru = this.getRequestUtils();
		// 分页
		Integer pageNum = ru.getInt("page");
		Integer perPage = ru.getInt("rows");
		PageBean pb = new PageBean();
		
		String name = ru.getTrimString("name");
		
		CbEasyUIGridModel<SysPagesAdminVo> model = new CbEasyUIGridModel<SysPagesAdminVo>();
		List<SysPagesAdminVo> admin = null;
		try {
			admin = SysPagesService.instance.getPageAdminList(name, pageNum, perPage, pb);
			model.setRows(admin);
			model.setTotal(pb.getTotal());
			return this.SUC(model);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		return this.ERR("获取失败");
	}
	
	//获取所有系统用户
	public String getSysload() {
		RequestUtils ru = this.getRequestUtils();
		String name = ru.getTrimString("q");
		List<SysUser> users = null;
		List<CbEasyUICombobox> retList = new ArrayList<>();
		try {
			users = SysPagesService.instance.getSysload();
			for (SysUser user : users) {
				CbEasyUICombobox item = new CbEasyUICombobox();
				item.setId(user.getSysUserSno() + "");
				item.setText(user.getName());
				retList.add(item);
			}
			return this.SUC(retList);
		}catch (Exception e) {
			logger.error("",e);
		}
		return this.ERR("获取失败");
	}
	
	//取得数据加载进下拉框
	public String getloadDicStatus() {
		List<JDic> dics = null;
		List<CbEasyUICombobox> retList = new ArrayList<>();
		try {

			
			CbEasyUICombobox item = new CbEasyUICombobox();
			item.setId(1 + "");
			item.setText("有效");
			retList.add(item);
			
			item = new CbEasyUICombobox();
			item.setId(2 + "");
			item.setText("无效");
			retList.add(item);
			
			return this.SUC(retList);
		}catch (Exception e) {
			logger.error("",e);
		}
		return this.ERR("获取失败");
	}
	
	//取得数据加载进下拉框
	public String getloadPageName() {
		List<SysPages> pages = null;
		List<CbEasyUICombobox> retList = new ArrayList<>();
		try {
			pages = SysPagesService.instance.getloadPageName();
			for (SysPages page : pages) {
				CbEasyUICombobox item = new CbEasyUICombobox();
				item.setId(page.getId() + "");
				item.setText(page.getPageName());
				retList.add(item);
			}
			return this.SUC(retList);
		}catch (Exception e) {
			logger.error("",e);
		}
		return this.ERR("获取失败");
	}
	
	//取得数据加载进下拉框
	public String getloadRightName() {
		List<SysServiceRight> right = null;
		List<CbEasyUICombobox> retList = new ArrayList<>();
		try {
			right = SysPagesService.instance.getloadRightName();
			for (SysServiceRight page : right) {
				CbEasyUICombobox item = new CbEasyUICombobox();
				item.setId(page.getRightCode() + "");
				item.setText(page.getRightName());
				retList.add(item);
			}
			return this.SUC(retList);
		}catch (Exception e) {
			logger.error("",e);
		}
		return this.ERR("获取失败");
	}
	
	//添加用户拥有哪些页面的导出权限
	public String addPagesServiceRightUser()  {
		RequestUtils ru = this.getRequestUtils();
		Integer[] names = ru.getInts("name");
		int rightCode = ru.getInt("rightName");
		int pageId = ru.getInt("pageName");
		try {
			for(int i=0;i<names.length;i++) {
				int num = SysPagesService.instance.countUserById(names[i],pageId,rightCode).getValue();
				if(num>0) {
					return this.ERR("您所选用户已拥有该页面权限，请不要重复操作");
				}
			}
			SysPagesService.instance.addRigthUser(pageId,rightCode,names);	
			return this.SUC("新增成功");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		return this.ERR("新增失败");
	}
	
	//删除数据
	public String delete() {
		RequestUtils ru = this.getRequestUtils();
		int id = ru.getInt("id");
		try {
			SysPagesServiceRightUser serviceRightUser = new SysPagesServiceRightUser();
			serviceRightUser.setId(id);
			SysPagesService.instance.deleteServiceRightUser(serviceRightUser);
			return this.SUC("删除成功");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		return this.ERR("删除失败");
	}
	
}
