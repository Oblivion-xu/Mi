package org.crm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.crm.pojo.SysUser;
import org.crm.service.SysUserService;
import org.crm.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("userAction")
public class UserAction extends ActionSupport implements ModelDriven<SysUser> {

	private static final long serialVersionUID = 1342800547393847716L;
	
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private SysUserService userService;
	
	private SysUser user = new SysUser();
	
	public void getCode() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		Util.getCode(response, session);
	}
	
	public String login(){
		SysUser sysUser = userService.login(user);
		if(sysUser==null){
			request.setAttribute("errInfo", "用户名或者密码错误");
			return INPUT;
		}else{
			String imgCode = (String) session.getAttribute("code");
			String code = request.getParameter("code");
			if(imgCode.equals(code)){
				session.setAttribute("sysUser", sysUser);
				return SUCCESS;
			}else{
				request.setAttribute("errInfo", "验证码错误");
				return INPUT;
			}
		}
		
	}

	@Override
	public SysUser getModel() {
		return user;
	}
}
