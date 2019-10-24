package com.ulwx.filter;

import com.ulwx.tool.ArrayUtils;
import com.ulwx.tool.ObjectUtils;
import com.ulwx.tool.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccessFilter implements Filter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
	protected FilterConfig filterConfig;
	private String LoginPage;
	private String UserSeesionKey;
	private String AjaxURLSTR;
	private String MessagePage;
	private String AjaxMessagePage;
	private String NotFilterURLs;
	private String MessagePageKey;
	private String MessagePageReturnURL;

	private String accessPlugin;

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;

		accessPlugin = StringUtils.trim(config.getInitParameter("accessPlugin"));
		LoginPage = StringUtils.trim(config.getInitParameter("LoginPage"));
		UserSeesionKey = StringUtils.trim(config.getInitParameter("UserSeesionKey"));
		AjaxURLSTR = StringUtils.trim(config.getInitParameter("AjaxURLSTR"));
		MessagePage = StringUtils.trim(config.getInitParameter("MessagePage"));
		AjaxMessagePage = StringUtils.trim(config.getInitParameter("AjaxMessagePage"));
		NotFilterURLs = StringUtils.trim(config.getInitParameter("NotFilterURLs"));
		MessagePageKey = StringUtils.trim(config.getInitParameter("MessagePageKey"));
		MessagePageReturnURL = StringUtils.trim(config.getInitParameter("MessagePageReturnURL"));
		if (LoginPage == null) {
			log.error("loginPage init param missing!");
			// throw new ServletException("loginPage init param missing");
		}
	}

	public void doFilter(final ServletRequest req, final ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hres = (HttpServletResponse) res;
		Object user = hreq.getSession().getAttribute(UserSeesionKey);
		String context = hreq.getContextPath();
		log.debug("context=" + context);
		Object userInfo = (Object) hreq.getSession().getAttribute(UserSeesionKey);

		String ruri = hreq.getRequestURI();
		// String rur2=hreq.getRequestURL().toString();
		String rur3 = hreq.getContextPath();

		if (StringUtils.hasText(NotFilterURLs)) {
			String[] strs = StringUtils.split(NotFilterURLs, ",");
			if (ArrayUtils.isNotEmpty(strs)) {
				for (int i = 0; i < strs.length; i++) {
					if (strs[i].startsWith("/")) {
						if (ruri.startsWith(rur3 + strs[i])) {
							chain.doFilter(req, res);
							return;
						}
					} else {
						if (StringUtils.endsWith(ruri, strs[i], false)) {
							chain.doFilter(req, res);
							return;
						}
					}
				}
			}

		}

		if (userInfo != null) {
			if (StringUtils.hasText(accessPlugin)) {
				String[] plugins = accessPlugin.split(",");
				for (int i = 0; i < plugins.length; i++) {
					AccessPlugin plugin = null;
					AccessBean ab = null;
					try {
						plugin = (AccessPlugin) Class.forName(plugins[i]).newInstance();
						ab = plugin.doVerify(hreq, hres,this);
					} catch (Exception e) {
						log.error(e + "", e);
						ab = new AccessBean();
						ab.setStatus(0);
						ab.setMessage("服务器内部处理错误，请联系管理员！" + e + "");
					}
					if (ab.getStatus() == 1) {//
						///
					} else {
						if (isAjax(hreq)) {
							log.debug("JSON request");
							hres.setHeader("sessionstatus", "control");
							Map<String, Object> rj = new HashMap<String, Object>();
							rj.put("code", 0);
							rj.put("content", ab.getMessage());
							rj.put("login", hreq.getContextPath() + "/" + LoginPage);
							rj.put("exit", ab.getIsExit());
							
							String result = ObjectUtils.toJsonString(rj);
							hreq.setAttribute("json", result);
							RequestDispatcher rd = hreq.getRequestDispatcher("/" + AjaxMessagePage);
							rd.forward(hreq, hres);

							return;
						} else {
							if(ab.getIsExit()==1) {
								String login = "";
								hreq.setAttribute(MessagePageKey, ab.getMessage());
								login = hreq.getContextPath() + "/" + LoginPage;
								hreq.setAttribute(MessagePageReturnURL, login);
								RequestDispatcher rd = hreq.getRequestDispatcher("/" + MessagePage);
								rd.forward(hreq, hres);
							}else {
								hreq.setAttribute(MessagePageKey, ab.getMessage());
								hreq.setAttribute(MessagePageReturnURL, "");
								RequestDispatcher rd = hreq.getRequestDispatcher("/" + MessagePage);
								rd.forward(hreq, hres);
								
							}
							return;
						}

					}

				}
			}

			chain.doFilter(req, res);
			return;

		} else { //session为空
			if (isAjax(hreq)) {// 如果是json请求，跳转到json出错页面

				log.debug("JSON request");
				hres.setHeader("sessionstatus", "timeout");
				Map<String, Object> rj = new HashMap<String, Object>();
				rj.put("code", 0);
				rj.put("content", "您已经超时，请重新登陆！");
				rj.put("login", hreq.getContextPath() + "/" + LoginPage);
				String result = ObjectUtils.toJsonString(rj);
				hreq.setAttribute("json", result);
				RequestDispatcher rd = hreq.getRequestDispatcher("/" + AjaxMessagePage);
				rd.forward(hreq, hres);

				return;
			}
	
			hreq.setAttribute(MessagePageKey, "您还没有登录或者您长时间没有使用登录系统，请重新登录系统！");
			String login = hreq.getContextPath() + "/" + LoginPage;
			hreq.setAttribute(MessagePageReturnURL, login);
			RequestDispatcher rd = hreq.getRequestDispatcher("/" + MessagePage);
			rd.forward(hreq, hres);
			return;
		}

	}

	public boolean isAjax(HttpServletRequest hreq) {
		String ruri = hreq.getRequestURI();
		if ((StringUtils.hasText(AjaxURLSTR) && ruri.contains(AjaxURLSTR))
				|| (hreq.getHeader("x-requested-with") != null
						&& hreq.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))) {
			return true;
		}
		return false;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void setFilterConfig(final FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public static void main(String[] args) {

	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public String getLoginPage() {
		return LoginPage;
	}

	public String getUserSeesionKey() {
		return UserSeesionKey;
	}

	public String getAjaxURLSTR() {
		return AjaxURLSTR;
	}

	public String getMessagePage() {
		return MessagePage;
	}

	public String getAjaxMessagePage() {
		return AjaxMessagePage;
	}

	public String getNotFilterURLs() {
		return NotFilterURLs;
	}

	public String getMessagePageKey() {
		return MessagePageKey;
	}

	public String getMessagePageReturnURL() {
		return MessagePageReturnURL;
	}

	public String getAccessPlugin() {
		return accessPlugin;
	}
	
	
}
