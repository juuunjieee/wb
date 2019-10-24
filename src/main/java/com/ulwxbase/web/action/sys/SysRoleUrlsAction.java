package com.ulwxbase.web.action.sys;

import com.ulwx.tool.ObjectUtils;
import com.ulwx.tool.PageBean;
import com.ulwx.tool.RequestUtils;
import com.ulwx.tool.StringUtils;
import com.ulwxbase.domain.cus.CbEasyUICombobox;
import com.ulwxbase.domain.cus.CbEasyUIGridModel;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.domain.db.sys.SysRole;
import com.ulwxbase.domain.db.sys.SysRoleUrls;
import com.ulwxbase.utils.CbConstants;
import com.ulwxbase.web.action.CbBaseAction;
import com.ulwxbase.web.action.sys.domain.SysRoleUrlsVo;
import com.ulwxbase.web.action.sys.services.service.SysRoleUrlsService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SysRoleUrlsAction extends CbBaseAction {
	
	private static final long serialVersionUID = 5500766020226211517L;
	// 跳转页面指向，即从当前页面跳转到指定的页面
	private static Logger logger = Logger.getLogger(SysRoleUrlsAction.class);
	HttpSession session = this.getRequest().getSession();
	
	/**
	 * 查询URL信息
	 * 
	 * @return
	 */
	public String getJProjectList() {
		RequestUtils ru = this.getRequestUtils();

		//分页信息
		Integer pageNum = ru.getInt("page");
		Integer perPage = ru.getInt("rows");
		PageBean pb = new PageBean();
		CbEasyUIGridModel<SysRoleUrlsVo> model = new CbEasyUIGridModel<SysRoleUrlsVo>();

		//查询条件
		String roleId = ru.getTrimString("roleId");
		List<SysRoleUrlsVo> urlList = null;
		try {
			urlList = SysRoleUrlsService.instance.getSysRoleUrlsList(roleId,pageNum, perPage, pb);
			model.setRows(urlList);
			model.setTotal(pb.getTotal());
			return this.SUC(model);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
		}
		return this.ERR("无法获取URL信息");
	}
	
	
	/**
	 * 删除角色菜单
	 * @return
	 */
	public String delRoleUrls() {
		RequestUtils ru = this.getRequestUtils();
		UserInfo userInfo = (UserInfo)session.getAttribute(CbConstants.SessionKey.USER);
		
		try {
			
			String id = ru.getTrimString("id");
			
			SysRoleUrlsService.instance.delRoleUrlsById(id);
			log(this.getRequest(), userInfo, 3, "删除角色菜单 [菜单ID:"+id+"]", "系统管理");
			
			return this.SUC("操作成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
		
		return this.ERR("操作失败!");
	}


	/**
	 * 新增角色URL
	 * @return
	 */
	public String addRoleUrls() {
		RequestUtils ru = this.getRequestUtils();
		SysRoleUrls roleUrls = new SysRoleUrls();
		UserInfo userInfo = (UserInfo)session.getAttribute(CbConstants.SessionKey.USER);
		LocalDateTime createTime = LocalDateTime.now();
		LocalDateTime updateTIme = createTime;
		
		roleUrls = ObjectUtils.fromMapToJavaBean(roleUrls,ru.getrParms());
		/*if(roleUrls.getRoleId()==null) {
			return this.ERR("角色不能为空!");
		} */
		
		if(StringUtils.isEmpty(roleUrls.getUrlMatch())) {
			return this.ERR("URL不能为空!");
		} 
		
		try {
			
			List<SysRoleUrlsVo> urlList = SysRoleUrlsService.instance.getSysRoleUrlsList(String.valueOf(roleUrls.getRoleId()));
			if(urlList.size() > 0) {
				return this.ERR("角色类型已存在!");
			}
			
			SysRoleUrls rUrls = new SysRoleUrls();
			rUrls.setRoleId(Integer.parseInt(String.valueOf(roleUrls.getRoleId())));
			rUrls.setUrlMatch(roleUrls.getUrlMatch());
			rUrls.setUpdatime(updateTIme);
			
			SysRoleUrlsService.instance.addRoleUrls(rUrls);
			log(this.getRequest(), userInfo, 1, "新增角色菜单 [菜单ID:"+roleUrls.getId()+"]", "系统管理");
			
			return this.SUC("操作成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
		
		return this.ERR("操作失败!");
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String updateRoleUrlsById() {
		RequestUtils ru = this.getRequestUtils();
		SysRoleUrls roleUrls = new SysRoleUrls();
		UserInfo userInfo = (UserInfo)session.getAttribute(CbConstants.SessionKey.USER);
		
		try {
			roleUrls = ObjectUtils.fromMapToJavaBean(roleUrls,ru.getrParms());
			SysRoleUrlsService.instance.updateRoleUrlsById(roleUrls);
			
			log(this.getRequest(), userInfo, 2, "修改角色菜单  [菜单ID:"+roleUrls.getId()+"]", "系统管理");
			return this.SUC("更新成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
		
		return this.ERR("更新失败!");
	}
	
	//获取角色Combobox
	public String getRoleList() {
		RequestUtils ru = this.getRequestUtils();
		List<CbEasyUICombobox> roleList = new ArrayList<>();
		
		try {
			String roleId = ru.getTrimString("id");
			List<SysRole> roles =  SysRoleUrlsService.instance.getRoleList(roleId);
			
			for (SysRole r : roles) {
				CbEasyUICombobox item = new CbEasyUICombobox();
				item.setId(r.getSysRoleSno()+"");
				item.setText(r.getRoleName());
				roleList.add(item);
			}
			
			return this.SUC(roleList);
		} catch (Exception e) {
			logger.error("", e);
		}
		
		return this.ERR("无法获取角色信息！");
	}
	
	
}
