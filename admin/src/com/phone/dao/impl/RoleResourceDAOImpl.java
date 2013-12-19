package com.phone.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.phone.dao.RoleResourceDAO;
import com.phone.entity.RoleResource;

@Repository
public class RoleResourceDAOImpl extends BaseDAOImpl<RoleResource, String> implements RoleResourceDAO {
	@SuppressWarnings("deprecation")
	@Required
	@Autowired
	@Qualifier("sqlMapClient")
	public void setSqlMapClientAutowired(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
}
