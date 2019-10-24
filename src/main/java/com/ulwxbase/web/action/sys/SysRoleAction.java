package com.ulwxbase.web.action.sys;

import com.opensymphony.xwork2.ActionContext;
import com.ulwx.tool.RequestUtils;
import com.ulwx.type.TInteger;
import com.ulwxbase.domain.cus.CbEasyUICombobox;
import com.ulwxbase.domain.cus.CbEasyUIComboboxTree;
import com.ulwxbase.domain.cus.CbEasyUIGridModel;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.domain.db.sys.SysRight;
import com.ulwxbase.domain.db.sys.SysRole;
import com.ulwxbase.domain.db.sys.SysRoleRight;
import com.ulwxbase.utils.CbConstants;
import com.ulwxbase.web.action.CbBaseAction;
import com.ulwxbase.web.action.sys.domain.SysRoleInfo;
import com.ulwxbase.web.action.sys.services.dao.sys.SysRightDao;
import com.ulwxbase.web.action.sys.services.dao.sys.SysRoleDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 接口或类的说明:
 * 
 * 
 * @开发：linrb
 * @版本：1.0
 * @创建时间：2011-10-19
 */
public class SysRoleAction extends CbBaseAction {
	
	private static final long serialVersionUID = 5500766020226211517L;
	// 跳转页面指向，即从当前页面跳转到指定的页面
	private String next;
	private static Logger logger = Logger.getLogger(SysRoleAction.class);
	public void setNext(String next) {
		this.next = next;
	}

	public String getNext() {
		return next;
	}

	public String ListData() throws Exception {
		return "ok";
	}

	/**
	 * 返回列表数据
	 */
	public String list() {
		ActionContext ctx = ActionContext.getContext();
		RequestUtils ru = this.getRequestUtils();
		Integer pageNum = ru.getInt("page");
		Integer pageSize = ru.getInt("rows");

		String RoleName = ru.getTrimString("sRoleName");
		CbEasyUIGridModel<SysRoleInfo> model = new CbEasyUIGridModel<SysRoleInfo>();
		try {
			SysRoleDao.getData(RoleName,  pageNum, pageSize,
					model);
		} catch (Exception e) {
			logger.error("" + e);
			return this.ERR("获取数据失败！");
		}

		/*UserInfo userInfo=(UserInfo)ctx.getSession().get(MyConstants.SessionKey.USER);
		this.log(this.getRequest(),userInfo,
				5,
				"查看角色表管理数据,用户为"
						+ userInfo.getUser()
								.getName());*/
		return this.SUC(model);
	}

	/**
	 * 新增数据
	 */
	public String insert() {
		ActionContext ctx = ActionContext.getContext();
		RequestUtils ru = this.getRequestUtils();
		SysRole entity = new SysRole();
		SysRoleRight srr = new SysRoleRight();
		// 获取参数值
		entity.setRoleName(ru.getString("roleName").trim());
		String description = ru.getString("description");
		String[] rights = ru.getStrings("sysRight");
		if(StringUtils.isEmpty(ru.getString("roleName").trim())) {
			return this.ERR("角色名称必填");
		}else {
			if(ru.getString("roleName").trim().length()>20) {
				return this.ERR("角色名称最大输入20个字符！");
			}
		}
		if(rights==null) {
			return this.ERR("功能菜单必选");
		}else {
			if(rights.length==0) {
				return this.ERR("功能菜单必选");
			}
		}
		if (description != null && !"".equals(description)) {
			if(description.trim().length()>300) {
				return this.ERR("说明内容最大300个字符");
			}else {
				entity.setDescription(description.trim());
			}
			
		}
			
		
			
		entity.setUpdateTime(LocalDateTime.now());
		String updator = ((UserInfo)ctx.getSession().get(
				CbConstants.SessionKey.USER)).getUser().getName();
		entity.setUpdator(updator);
		srr.setUpdateTime(LocalDateTime.now());
		srr.setUpdator(updator);
		
		Set<String> rightSet = new HashSet<String>();
		for (String r : rights) {
			if (!rightSet.contains(r.substring(0, 2) + "000"))
				rightSet.add(r.substring(0, 2) + "000");
			rightSet.add(r);
		}
		try {
			int ID = SysRoleDao.insertData(entity, srr,
					rightSet.toArray(new String[0]));
			UserInfo userInfo=(UserInfo)ctx.getSession().get(CbConstants.SessionKey.USER);
			this.log(this.getRequest(),userInfo,1, "添加角色表管理数据,ID为" + ID);
		} catch (Exception e) {
			logger.error("" , e);
			return this.ERR("插入失败！");
		}
		return this.SUC("插入成功！");
	}

	/**
	 * 修改数据
	 */
	public String update() {
		ActionContext ctx = ActionContext.getContext();
		RequestUtils ru = this.getRequestUtils();
		SysRole entity = new SysRole();
		
		Integer sno = ru.getInt("sno");
		entity.setSysRoleSno(sno);
		// 获取参数值
		entity.setRoleName(ru.getString("roleName").trim());

		String[] rights = ru.getStrings("sysRight");
		
		if(StringUtils.isEmpty(ru.getString("roleName").trim())) {
			return this.ERR("角色名称必填");
		}else {
			if(ru.getString("roleName").trim().length()>20) {
				return this.ERR("角色名称最大输入20个字符！");
			}
		}
		if(rights==null) {
			return this.ERR("功能菜单必选");
		}else {
			if(rights.length==0) {
				return this.ERR("功能菜单必选");
			}
		}
		
		
		String Description = ru.getString("description");
		if (Description != null && !"".equals(Description)) {
			if(Description.trim().length()>300) {
				return this.ERR("说明内容最大300个字符");
			}else {
				entity.setDescription(Description.trim());
			}
			
		}
		entity.setUpdateTime(LocalDateTime.now());
		String updator = ((UserInfo)ctx.getSession().get(
				CbConstants.SessionKey.USER)).getUser().getName();
		entity.setUpdator(updator);
		SysRoleRight srr = new SysRoleRight();
		srr.setUpdateTime(LocalDateTime.now());
		srr.setUpdator(updator);
		srr.setSysRoleId(sno);
		// 功能菜单
		
		Set<String> rightSet = new HashSet<String>();
		for (String r : rights) {
			if (!rightSet.contains(r.substring(0, 2) + "000")) {//检测是否为一级菜单
				rightSet.add(r.substring(0, 2) + "000");
			}
			rightSet.add(r);
		}
		try {
			// 修改数据
			SysRoleDao.updateData(entity,  srr,
					rightSet.toArray(new String[0]));
			UserInfo userInfo=(UserInfo)ctx.getSession().get(CbConstants.SessionKey.USER);
			this.log(this.getRequest(),userInfo,2, "修改角色表数据,id为" + ru.getString("sno"));
		} catch (Exception e) {
			logger.error("" ,e);
			return this.ERR("更新失败！");
		}
		return this.SUC("更新成功！");
	}

	/**
	 * 获取单个数据 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-10-25
	 * @return
	 */
	public String getOneData() {
		RequestUtils ru = this.getRequestUtils();
		// 获取参数值
		Integer sno = ru.getInt("sno");
		try {
			
			
			SysRole entity = SysRoleDao.getOneData(sno);

			List<String> list = SysRoleDao.getSysRightByRole(sno);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("roleInfo", entity);
			map.put("rightList", list);
			return this.SUC(map);
	
		} catch (Exception e) {
			logger.error("" + e);
			return this.ERR("获取数据失败！");
		}
		
	}

	/**
	 * 删除指定数据 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-10-25
	 * @return
	 */
	public String delete() {
		ActionContext ctx = ActionContext.getContext();
		RequestUtils ru = this.getRequestUtils();
		try {

			String deleteId = ru.getString("deleteId");
			if (deleteId != null && !deleteId.equals("")) {
				String[] IDs = deleteId.split(",");
				SysRole entity = new SysRole();
				TInteger YdyRole=SysRoleDao.getYdyRoleCount(IDs);
				if(YdyRole.getValue()>0) {
					return this.ERR("预定义对象不能删除！");
				}
				for (String ID : IDs) {
					entity.setSysRoleSno(Integer.valueOf(ID));
					SysRoleDao.DeleteData(entity, "sysRoleSno");
				}
			}
			UserInfo userInfo=(UserInfo)ctx.getSession().get(CbConstants.SessionKey.USER);
			this.log(this.getRequest(),userInfo,3,
					userInfo.getUser().getName()
							+ "删除了角色表管理数据,ID为"
							+ deleteId);
			return this.SUC("删除成功！");
		} catch (Exception e) {
			logger.error("",e);
			return this.ERR("删除失败！");
		}
		
	}

	
	

	/**
	 * 返回功能菜单 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-11-10
	 * @return
	 */
	public String getSysRight() {
		ActionContext ctx = ActionContext.getContext();
		RequestUtils ru = this.getRequestUtils();
		String mainRightID = ru.getString("mainRightID");
		try {
			List<CbEasyUICombobox> res = SysRoleDao.getSysRight(mainRightID);
			return this.SUC(res);
		} catch (Exception e) {
			logger.error("" + e);
			return this.ERR("返回数据失败");
		}
	
	}

	/**
	 * 返回功能菜单 方法说明:
	 * 
	 * @开发：linrb
	 * @创建时间：2011-11-10
	 * @return
	 */
	public String getSysRights() {
		ActionContext ctx = ActionContext.getContext();
		RequestUtils ru = this.getRequestUtils();
		String RoleID = ru.getString("roleId");
		// 最终返回的结果
		List<CbEasyUIComboboxTree> res = new ArrayList<CbEasyUIComboboxTree>();
		// 保存comboboxtree下拉框的子节点对象
		List<CbEasyUIComboboxTree> children = new ArrayList<CbEasyUIComboboxTree>();
		try {
			if (RoleID != null && !"".equals(RoleID)) {

				// 获取说有的功能菜单
			} else {
				List<SysRight> list = SysRightDao.getAllRight();
				CbEasyUIComboboxTree model = null;
				String code = "";
				for (SysRight sr : list) {
					model = new CbEasyUIComboboxTree();
					// code以“000”结尾的都是父菜单
					code = sr.getSysRightCode();
					model.setId(code);
					model.setText(sr.getSysRightName());
					if (code.substring(2).equals("000")) {
						// 设置父菜单的子菜单集合
						if (children.size() > 0 && res.size()>0) {
							res.get(res.size() - 1).setChildren(
									children.toArray(new CbEasyUIComboboxTree[0]));
							children.clear();
						}
						model.setState("closed");
						res.add(model);
					} else {
						children.add(model);
					}
				}
				if (children.size() > 0) {
					res.get(res.size() - 1).setChildren(
							children.toArray(new CbEasyUIComboboxTree[0]));
				}
			}
			return this.SUC(res);
		} catch (Exception e) {
			logger.error("" ,e);
			return this.ERR("获取数据失败！");
		}
		
	}
}
