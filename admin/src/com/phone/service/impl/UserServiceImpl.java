package com.phone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.phone.dao.BaseDAO;
import com.phone.dao.UserDAO;
import com.phone.entity.Users;
import com.phone.service.UserService;

@Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ)
@Service
public class UserServiceImpl extends BaseServiceImpl<Users, String> implements
		UserService {
	@Autowired
	private UserDAO userDao;

	public BaseDAO<Users, String> getDAO() {
		return userDao;
	}

}
