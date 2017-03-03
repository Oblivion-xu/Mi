package org.crm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.crm.pojo.SysUser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session.getAttribute("sysUser");
		if (user==null){
			request.setAttribute("errInfo", "请先登录！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}else{
			return super.preHandle(request, response, handler);
		}	
	}
}
