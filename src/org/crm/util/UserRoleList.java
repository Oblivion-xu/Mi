package org.crm.util;

import java.util.List;

import org.crm.pojo.SysRole;
import org.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleList {
	
	@Autowired
	private RoleService roleService;
	
	public List<SysRole> getRoles(){
		return roleService.roleList();
	}
}
