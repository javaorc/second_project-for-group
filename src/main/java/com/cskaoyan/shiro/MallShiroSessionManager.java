package com.cskaoyan.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class MallShiroSessionManager extends DefaultWebSessionManager {

	public static final String LOGIN_TOKEN_KEY = "X-Litemall-Admin-Token";
	private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String id = servletRequest.getHeader(LOGIN_TOKEN_KEY);

		if (!StringUtils.isEmpty(id)){

			return id;
		}


		return super.getSessionId(request, response);
	}


}
