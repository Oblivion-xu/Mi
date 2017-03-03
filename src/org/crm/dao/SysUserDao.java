package org.crm.dao;

import org.crm.pojo.SysUser;

public interface SysUserDao {
	
    //登录
    SysUser login(SysUser user);
	
}
