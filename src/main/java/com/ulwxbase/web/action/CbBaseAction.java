package com.ulwxbase.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ulwx.tool.ArrayUtils;
import com.ulwx.tool.ObjectUtils;
import com.ulwx.tool.RequestUtils;
import com.ulwx.tool.StringUtils;
import com.ulwxbase.domain.cus.UserInfo;
import com.ulwxbase.domain.db.sys.SysUserOperLog;
import com.ulwxbase.services.utils.OperLogUtils;
import com.ulwxbase.utils.CbConstants;
import com.ulwxbase.web.action.utils.CbActionError;
import com.ulwxbase.web.action.utils.CbResultJson;
import com.ulwxbase.web.action.utils.CbResultJson.STATUS;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;
import org.apache.struts2.dispatcher.multipart.StrutsUploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class CbBaseAction extends ActionSupport {

	private static final long serialVersionUID = 4940622306144757620L;
	static Logger log = LoggerFactory.getLogger(CbBaseAction.class);

	private String next;

	protected final String JSON = "json";
	protected final String OK = "ok";
	protected final String SUCCESS = "success";
	protected final String MAIN = "main";
	protected final String NEXT = "next";
	protected final String STREAM = "stream";
	protected final String FORWARD = "forward";
	protected final String REDIRECT = "redirect";
	protected final String DOWNLOAD = "download";
	protected final String ERROR = "error";

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public UserInfo getUserInfo() {

		return (UserInfo) this.getSession().getAttribute(CbConstants.SessionKey.USER);
	}

	/**
	 * 是否是管理员账号
	 * 
	 * @return
	 */
	public boolean isAdminUser() {
		return ArrayUtils.contains(this.getUserInfo().getRoleTypes(), 0);
	}

	/**
	 * 
	 * @param OperaType   操作类型 1：增加数据 2：修改数据 3：删除数据 4：审批数据 5：查看数据 6：登录与退出
	 * @param OperaDetail 操作的详细描述
	 */
	public void log(HttpServletRequest request, UserInfo userInfo, int OperaType, String OperaDetail) {
		try {
			// 插入数据
			log(request, userInfo, OperaType, OperaDetail, null);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * @param request     httpservletRequest
	 * @param userInfo    用户信息
	 * @param OperaType   操作类型 1：增加数据 2：修改数据 3：删除数据 4：审批数据 5：查看数据 6：登录与退出
	 * @param OperaDetail 操作的详细描述
	 * @param rightName   模板名称
	 */
	public void log(HttpServletRequest request, UserInfo userInfo, int OperaType, String OperaDetail,
			String rightName) {
		try {
			// 插入数据
			SysUserOperLog operLog = new SysUserOperLog();
			if (StringUtils.isEmpty(rightName)) {
				operLog.setRightName("系统模块");
			} else {
				operLog.setRightName(rightName);
			}
			operLog.setOperType(OperaType);
			if (OperaDetail.length() > 500) {
				OperaDetail = OperaDetail.substring(0, 500);
			}
			operLog.setDetail(OperaDetail);
			OperLogUtils.insertUserOperLogInfo(this.getRequestUtils(), request, operLog, userInfo);

		} catch (Exception e) {
			log.error("", e);
		}
	}

	public ActionContext getContext() {
		return ActionContext.getContext();
	}

	public HttpSession getSession() {
		return this.getRequest().getSession();
		// ctx.getSession().clear();
	}

	/**
	 * 获取HttpServletResponse对象
	 * 
	 * @return
	 */
	public HttpServletResponse getHttpResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();

		return response;
	}

	/**
	 * 从请求中取出参数，又将参数放回请求中
	 * 
	 * @param ctx
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public RequestUtils getRequestUtils() {
		// Map<String, Object> rParms = (Map)toMap();

		Map<String, Object[]> rParms = new HashMap<>();
		ActionContext context = ActionContext.getContext();
		HttpParameters parameters = context.getParameters();
		for (Map.Entry<String, Parameter> entry : parameters.entrySet()) {
			Object value = entry.getValue().getObject();
			// org.apache.struts2.dispatcher.multipart.StrutsUploadedFile

			if (value != null) {

				if (value.getClass().isArray()) {
					Object[] elems = (Object[]) entry.getValue().getObject();

					if (elems.length > 0) {
						if (elems[0] instanceof StrutsUploadedFile) {
							File[] fs = new File[elems.length];
							for (int i = 0; i < elems.length; i++) {
								fs[i] = ((StrutsUploadedFile) elems[i]).getContent();
							}
							rParms.put(entry.getKey(), fs);
						} else {
							rParms.put(entry.getKey(), elems);
						}
					} else {
						rParms.put(entry.getKey(), elems);
					}

				} else {
					Object elem = entry.getValue();
					if (elem instanceof StrutsUploadedFile) {
						StrutsUploadedFile sf = (StrutsUploadedFile) entry.getValue();
						rParms.put(entry.getKey(), new Object[] { sf.getContent() });
					} else {
						rParms.put(entry.getKey(), new Object[] { elem });
					}
				}
			}
			//
		}

		log.debug(ObjectUtils.toString(rParms));
		RequestUtils ru = new RequestUtils(rParms);

		return ru;
	}

	public <T> T getBean(Class<T> t) {
		Map<String, Object[]> rParms = (Map) getRequest().getParameterMap();
		try {
			log.debug(ObjectUtils.toString(rParms));
			return ObjectUtils.fromMapToJavaBean(t.newInstance(), rParms);
		} catch (Exception e) {
			return null;
		}
	}

	public String getRemoteAddr() {
		String ipAddress = this.getRequest().getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = this.getRequest().getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = this.getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = this.getRequest().getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {

					log.error(e + "", e);
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;

	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String SUC(String message, Object data) {
		CbResultJson rj = new CbResultJson();
		rj.setStatus(STATUS.SUC);
		rj.setData(data);
		rj.setError(0);
		rj.setMessage(message);
		ActionContext ctx = ActionContext.getContext();
		String ret = ObjectUtils.toJsonString(rj);

		ctx.put("json", JSONP(ret));
		log.debug("ret=" + ret);
		return "json";

	}

	public String RETURN(Map returnData) {

		String ret = ObjectUtils.toJsonString(returnData);
		ActionContext ctx = ActionContext.getContext();
		ctx.put("json", JSONP(ret));
		log.debug("ret=" + ret);
		return "json";

	}

	public String JSONP(String content) {
		RequestUtils ru = this.getRequestUtils();
		String funcName = ru.getString("callback");
		if (StringUtils.hasText(funcName)) {
			String ret = funcName + "(" + content + ")";
			return ret;
		} else {
			return content;
		}
	}

	public String SUC() {
		return SUC("成功", null);
	}

	public String SUC(Object data) {
		if (data instanceof String) {
			return SUC(data.toString(), data);
		}
		return SUC("成功", data);
	}

	public String ERR(String message) {

		CbResultJson rj = new CbResultJson();
		rj.setStatus(CbResultJson.STATUS.ERR);
		rj.setMessage(message);
		rj.setError(CbResultJson.ERROR.COMMON_ERROR);
		ActionContext ctx = ActionContext.getContext();
		String ret = ObjectUtils.toJsonString2(rj, true, true);
		ctx.put("json", JSONP(ret));
		log.debug("ret=" + ret);
		return "json";
	}

	public String ERR(Exception e, String message) {
		CbResultJson rj = new CbResultJson();
		rj.setStatus(STATUS.ERR);
		rj.setMessage("[" + message + "]" + e.toString());
		rj.setError(CbResultJson.ERROR.COMMON_ERROR);
		ActionContext ctx = ActionContext.getContext();
		String ret = ObjectUtils.toJsonString2(rj, true, true);
		ctx.put("json", JSONP(ret));
		log.debug("ret=" + ret);
		return "json";
	}

	public String ERR(Integer errorCode) {

		CbResultJson rj = new CbResultJson();
		rj.setStatus(CbResultJson.STATUS.ERR);
		rj.setData(null);
		rj.setMessage(CbActionError.errors.get(errorCode));
		rj.setError(errorCode);
		ActionContext ctx = ActionContext.getContext();
		String ret = ObjectUtils.toJsonString2(rj, true, true);
		ctx.put("json", JSONP(ret));
		log.debug("ret=" + ret);
		return "json";
	}

	public String ERR(Exception e) {
		return ERR(e, e.toString());
	}

	public String ERR(Integer errorCode, String msg) {
		CbResultJson rj = new CbResultJson();
		rj.setStatus(CbResultJson.STATUS.ERR);
		rj.setData(null);
		rj.setMessage(msg);
		rj.setError(errorCode);
		ActionContext ctx = ActionContext.getContext();
		String ret = ObjectUtils.toJsonString2(rj, true, true);
		ctx.put("json", JSONP(ret));
		log.debug("ret=" + ret);
		return "json";
	}

}
