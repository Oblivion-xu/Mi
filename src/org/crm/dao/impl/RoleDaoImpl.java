package org.crm.dao.impl;

import java.util.List;

import org.crm.dao.BaseDao;
import org.crm.dao.RoleDao;
import org.crm.pojo.SysRole;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class RoleDaoImpl extends BaseDao implements RoleDao {

	@Override
	public List<SysRole> roleList() {
		return getHibernateTemplate().find("from SysRole");
	}

}
