package com.phone.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;

import com.phone.dao.UserDAO;
import com.phone.entity.Users;

@Repository
public class UserDAOImpl extends BaseDAOImpl<Users, String> implements UserDAO {

	@SuppressWarnings("deprecation")
	@Required
    @Autowired
    @Qualifier("sqlMapClient")
    public void setSqlMapClientAutowired(SqlMapClient sqlMapClient) {
       setSqlMapClient( sqlMapClient );
    }
}
