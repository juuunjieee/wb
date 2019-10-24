package com.ulwxbase.web.interceptor;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ulwxbase.web.action.utils.CbResultJson;
import org.apache.log4j.Logger;

public class ExceptionInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ExceptionInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = invocation.getInvocationContext();
		String result = "";
		String actionName = ctx.getName();

		try {
			result = invocation.invoke();
			return result;
		} catch (Exception ex) {
			// ex.printStackTrace();
			log.error("", ex);
			if (actionName.endsWith("JSON")) {// 如果是json请求，跳转到json出错页面
	
				ctx.put("json", CbResultJson.ERR(ex, "异常"));

				return "json";
			} else {
				throw ex;
			}
		}

	}

}
