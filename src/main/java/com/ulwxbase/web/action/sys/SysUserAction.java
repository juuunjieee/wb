package com.ulwxbase.web.action.sys;

import com.opensymphony.xwork2.ActionContext;
import com.ulwx.tool.*;
import com.ulwxbase.domain.cus.CbEasyUICombobox;
import com.ulwxbase.domain.cus.CbEasyUIGridModel;
import com.ulwxbase.domain.db.sys.SysRole;
import com.ulwxbase.domain.db.sys.SysRoletype;
import com.ulwxbase.domain.db.sys.SysUser;
import com.ulwxbase.web.action.CbBaseAction;
import com.ulwxbase.web.action.sys.domain.AdminUserInfo;
import com.ulwxbase.web.action.sys.services.dao.sys.SysRoleDao;
import com.ulwxbase.web.action.sys.services.dao.sys.SysRoletypeDao;
import com.ulwxbase.web.action.sys.services.dao.sys.SysUserDao;
import com.ulwxbase.web.action.sys.services.service.UserInfoService;
import com.ulwxbase.web.action.utils.CbConst;
import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 接口或类的说明:
 * 
 * 
 * @开发：linrb @版本：1.0 @创建时间：2011-10-19
 */
public class SysUserAction extends CbBaseAction {
	private static final long serialVersionUID = -449402560791918959L;
	// 跳转页面指向，即从当前页面跳转到指定的页面
	private static Logger logger = Logger.getLogger(SysUserAction.class);
	private String next;

	public void setNext(String next) {
		this.next = next;
	}

	public String getNext() {
		return next;
	}

	public String ListData() throws Exception {
		return "ok";
	}

	public String getSysRoletypes() {


		try {
			List<SysRoletype> list = SysRoletypeDao.getAllRoles();
			List<CbEasyUICombobox> retList = new ArrayList<>();
			for (SysRoletype roleType : list) {
				CbEasyUICombobox item = new CbEasyUICombobox();
				item.setId(roleType.getSysRoletypeCode()+ "");
				item.setText(roleType.getSysRoletypeName());
				retList.add(item);
			}

			return this.SUC(retList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("", e);
		}

		return this.ERR("无法获取角色！");

	}

	public String addUser() {
		AdminUserInfo adminUserInfo=this.getBean(AdminUserInfo.class);
		
		try {
			
			if(StringUtils.isEmpty(adminUserInfo.getAccount())) {
				return this.ERR("密码账号必填！");
			}else {
//				Pattern account = Pattern 
//						.compile("^[a-zA-Z][a-zA-Z0-9_]{5,15}$");
//				if(!account.matcher(adminUserInfo.getAccount()).matches()) {
//					return this.ERR("只允许字母开头，6-16字节，字母数字下划线!");
//				}
			}
			
			if(StringUtils.isEmpty(adminUserInfo.getPhone())) {
				return this.ERR("手机号码必填!");
			}else {
				if(!ValidationUtils.isMobile(adminUserInfo.getPhone())) {
					return this.ERR("手机号码格式错误!");
				}
			}
			if(StringUtils.isEmpty(adminUserInfo.getPassword())) {
				return this.ERR("密码必填！");
			}else {
//				Pattern password = Pattern 
//						.compile("^(?![0-9]+$)(?![a-zA-Z]+$)\\S{8,16}$");
//				boolean flag=password.matcher(adminUserInfo.getPassword()).matches();
//				if(!flag) {
//					return this.ERR("8-16位，不包含空格，不能为纯数字或纯字母！");
//				}
			}
			if(StringUtils.isEmpty(adminUserInfo.getName())) {
				return this.ERR("姓名必填！");
			}else {
				if(!ValidationUtils.isChinese(adminUserInfo.getName())) {
					return this.ERR("姓名只能为中文！");
				}else {
					if(adminUserInfo.getName().length()>6) {
						return this.ERR("姓名最大6个字节");
					}
				}
			}
			
			if(!StringUtils.isEmpty(adminUserInfo.getNikeName())) {
				if(adminUserInfo.getNikeName().length()>10) {
					return this.ERR("昵称应小于10个字符！");
				}
			}
			
			if(StringUtils.isEmpty(adminUserInfo.getSysRoleIds())) {
				return this.ERR("菜单角色必填！");
			}
				
				
			if(StringUtils.isEmpty(adminUserInfo.getSysRoleTypeCodes())) {
				return this.ERR("角色类型必填！");
			}
			
			
			
			
			logger.debug("adminUserInfo="+ObjectUtils.toString(adminUserInfo));
			SysUser userInfo = UserInfoService.instance.getAccountInfo(adminUserInfo.getAccount());
			if(userInfo!=null) {
				return this.ERR("账号已经存在");
			}
			adminUserInfo.setAddTime(LocalDateTime.now());
			adminUserInfo.setUpdateTime(LocalDateTime.now());
			adminUserInfo.setUpdator(this.getUserInfo().getUserName());
			adminUserInfo.setPassword(CbConst.getPassword(adminUserInfo.getPassword()));;
			UserInfoService.instance.addUser(adminUserInfo);
			return this.SUC("添加成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
		return this.ERR("添加失败！");
		
	}
	public String delUser() {
		//selInfos
		RequestUtils ru=this.getRequestUtils();
		try {
			AdminUserInfo[] adminUserInfos=ru.getJson("selInfos", AdminUserInfo[].class);
			for(int i=0; i<adminUserInfos.length; i++) {
				AdminUserInfo adminUserInfo=adminUserInfos[i];
				String[] strs=adminUserInfo.getSysRoleTypeCodes().split(",");
				if(ArrayUtils.indexOf(strs, "0")>=0) {
					return this.ERR("管理员不能删除!");
				}
				
			}
			UserInfoService.instance.delUser(adminUserInfos);;
			
			return this.SUC("删除成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
		return this.ERR("删除失败！");
		
	}
	public String editUser() {
		AdminUserInfo adminUserInfo=this.getBean(AdminUserInfo.class);
		
		if(StringUtils.isEmpty(adminUserInfo.getAccount())) {
			return this.ERR("密码账号必填！");
		}else {
//			Pattern account = Pattern 
//					.compile("^[a-zA-Z][a-zA-Z0-9_]{5,15}$");
//			if(!account.matcher(adminUserInfo.getAccount()).matches()) {
//				return this.ERR("只允许字母开头，6-16字节，字母数字下划线!");
//			}
		}
		
		if(StringUtils.isEmpty(adminUserInfo.getPhone())) {
			return this.ERR("手机号码必填!");
		}else {
			if(!ValidationUtils.isMobile(adminUserInfo.getPhone())) {
				return this.ERR("手机号码格式错误!");
			}
		}
		
		if(!StringUtils.isEmpty(adminUserInfo.getNikeName())) {
			if(adminUserInfo.getNikeName().length()>10) {
				return this.ERR("昵称应小于10个字符！");
			}
		}
		
		if(StringUtils.isEmpty(adminUserInfo.getName())) {
			return this.ERR("姓名必填！");
		}else {
			if(!ValidationUtils.isChinese(adminUserInfo.getName())) {
				return this.ERR("姓名只能为中文！");
			}else {
				if(adminUserInfo.getName().length()>6) {
					return this.ERR("姓名最大6个字节");
				}
			}
		}
		
		if(StringUtils.isEmpty(adminUserInfo.getPassword())) {
			return this.ERR("密码必填！");
		}else {
//			Pattern password = Pattern 
//					.compile("^(?![0-9]+$)(?![a-zA-Z]+$)\\S{8,16}$");
//			boolean flag=password.matcher(adminUserInfo.getPassword()).matches();
//			if(!flag) {
//				return this.ERR("8-16位，不包含空格，不能为纯数字或纯字母！");
//			}
		}
		
		if(StringUtils.isEmpty(adminUserInfo.getSysRoleIds())) {
			return this.ERR("菜单角色必填！");
		}
			
			
		if(StringUtils.isEmpty(adminUserInfo.getSysRoleTypeCodes())) {
			return this.ERR("角色类型必填！");
		}
		
		try {
			logger.debug("adminUserInfo="+ObjectUtils.toString(adminUserInfo));
			adminUserInfo.setUpdateTime(LocalDateTime.now());
			adminUserInfo.setUpdator(this.getUserInfo().getUserName());
			if(adminUserInfo.getPassword().equals(CbConst.NoChangedPassword)) {
				adminUserInfo.setPassword(null);
			}else {
				adminUserInfo.setPassword(CbConst.getPassword(adminUserInfo.getPassword()));
			}
			UserInfoService.instance.editUser(adminUserInfo);
			return this.SUC("更新成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
		return this.ERR("更新失败！");
		
	}
	public String getSysRoles() {


		try {
			List<SysRole> list = SysRoleDao.getAllRoles();
			List<CbEasyUICombobox> retList = new ArrayList<>();
			for (SysRole role : list) {
				CbEasyUICombobox item = new CbEasyUICombobox();
				item.setId(role.getSysRoleSno() + "");
				item.setText(role.getRoleName());
				retList.add(item);

			}

			return this.SUC(retList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("", e);
		}

		return this.ERR("无法获取角色！");

	}

	
	public String userList() {
		ActionContext ctx = ActionContext.getContext();
		// 获取页面信息
		RequestUtils ru = this.getRequestUtils();
		String userName = ru.getTrimString("userName");
		String userPhone = ru.getTrimString("userPhone");
		// 页面的分页参数
		Integer pageNum = ru.getInt("page");
		Integer perPage = ru.getInt("rows");

		PageBean pb = new PageBean();

		List<AdminUserInfo> adminUserInfos = null;
		try {
			adminUserInfos = UserInfoService.instance.getUserList(userName, userPhone, pageNum, perPage, pb);

			// 得到schoolid

			CbEasyUIGridModel<AdminUserInfo> easyUIGridModel = new CbEasyUIGridModel<>();
			easyUIGridModel.setRows(adminUserInfos);
			easyUIGridModel.setTotal(pb.getTotal());
			return this.SUC(easyUIGridModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("", e);
		}

		return this.ERR("无法获取用户信息！");
	}

	public String execModifyPass() {
		ActionContext ctx = ActionContext.getContext();
		RequestUtils ru = this.getRequestUtils();

		String originalPass = StringUtils.trim(ru.getString("OriginalPass"));
		String pass = this.getUserInfo().getPassword();
		try {
			if (!pass.equals(CbConst.getPassword(originalPass))) {
				ctx.put("json", "原始密码不正确!!");
				return "json";
			}
		} catch (Exception e) {
			logger.error("" + e);
			ctx.put("json", "error");
			return "json";
		}

		String newPass = StringUtils.trim(ru.getString("NewPass"));
		String confirmPassword = StringUtils.trim(ru.getString("VerifyPass"));

		if (StringUtils.hasText(newPass) && newPass.equals(confirmPassword)) {
			try {
				SysUserDao.changePassword(this.getUserInfo().getUserId(), CbConst.getPassword(newPass));
				ctx.put("json", "ok");

			} catch (Exception e) {
				logger.error("" + e);
				ctx.put("json", "error");
			}
			return "json";
		} else {
			ctx.put("json", "两次输入的新密码不一致!!");
			return "json";
		}

	}

}
