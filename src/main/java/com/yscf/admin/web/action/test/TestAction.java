package com.yscf.admin.web.action.test;

import org.apache.log4j.Logger;

import com.ulwx.tool.ObjectUtils;
import com.ulwx.tool.RequestUtils;
import com.ulwxbase.domain.cus.UserInfo;
import com.yscf.admin.utils.MyConstants;
import com.yscf.admin.web.action.BaseAction;


public class TestAction extends BaseAction{
	private static final long serialVersionUID = -449402560791918959L;
	// 跳转页面指向，即从当前页面跳转到指定的页面
	private static Logger logger = Logger.getLogger(TestAction.class);
	
	//新增
	public String addHoliday() {
		
		return this.ERR("新增失败");
	}
	
	public String HolidayList() {
		RequestUtils ru = this.getRequestUtils();


		return this.ERR("获取列表失败");
	}
	
	public String delHoliday() {
		RequestUtils ru = this.getRequestUtils();

		UserInfo userInfo = (UserInfo) this.getUserInfo();
		try {
			////
			this.log(this.getRequest(), userInfo, 3, "删除节假日成功", "节假日管理");
			return this.SUC("删除成功");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("",e);
			this.log(this.getRequest(), userInfo, 3, "删除失败,错误["+e.getMessage()+"]", "节假日管理");
		}
		return this.ERR("删除失败");
	}
}
