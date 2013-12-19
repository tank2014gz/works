package com.phone.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.phone.dao.ResourceDAO;
import com.phone.entity.Resource;

@Repository
public class ResourceDAOImpl extends BaseDAOImpl<Resource, String> implements ResourceDAO{
   
	@SuppressWarnings("deprecation")
	@Required
	@Autowired
	@Qualifier("sqlMapClient")
	public void setSqlMapClientAutowired(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
}
