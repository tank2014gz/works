package com.phone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.dao.BaseDAO;
import com.phone.dao.RequestLogDAO;
import com.phone.entity.RequestLog;
import com.phone.service.RequestLogService;

@Service
public class RequestLogServiceImpl extends
		BaseServiceImpl<RequestLog, String> implements RequestLogService {
	@Autowired
	private RequestLogDAO dao;

	public BaseDAO<RequestLog, String> getDAO() {
		return dao;
	}

}
