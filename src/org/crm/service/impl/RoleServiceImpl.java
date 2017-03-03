package org.crm.service.impl;

import java.util.List;

import org.crm.dao.RoleDao;
import org.crm.pojo.SysRole;
import org.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao dao;
	
	@Override
	public List<SysRole> roleList() {
		return dao.roleList();
	}

}
