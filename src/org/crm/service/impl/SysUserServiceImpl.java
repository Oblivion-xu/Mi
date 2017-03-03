package org.crm.service.impl;

import org.crm.dao.SysUserDao;
import org.crm.pojo.SysUser;
import org.crm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao userDao ;

	@Override
	public SysUser login(SysUser user) {
		return userDao.login(user);
	}

}
