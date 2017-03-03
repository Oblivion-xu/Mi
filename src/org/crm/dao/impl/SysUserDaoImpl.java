package org.crm.dao.impl;

import java.util.List;

import org.crm.dao.BaseDao;
import org.crm.dao.SysUserDao;
import org.crm.pojo.SysUser;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public SysUser login(SysUser user) {
	String hql = "FROM SysUser where userName= ? and userPassword=?";
	Query query = getSession().createQuery(hql);
	query.setString(0, user.getUserName());
	query.setString(1, user.getUserPassword());
	List<SysUser> users = query.list();
	SysUser sysUser = null;
	if (users != null & users.size() > 0) {
	    sysUser = users.get(0);
	}
	return sysUser;
    }

}
