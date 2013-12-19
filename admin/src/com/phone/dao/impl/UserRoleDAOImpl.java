package com.phone.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.phone.dao.UserRoleDAO;
import com.phone.entity.UserRole;

@Repository
public class UserRoleDAOImpl extends BaseDAOImpl<UserRole, String> implements UserRoleDAO {
	@SuppressWarnings("deprecation")
	@Required
	@Autowired
	@Qualifier("sqlMapClient")
	public void setSqlMapClientAutowired(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
}
