package com.phone.service.impl;

import java.util.List;
import java.util.Map;

import com.phone.dao.BaseDAO;
import com.phone.service.BaseService;

public abstract class BaseServiceImpl<T, PK> implements BaseService<T, PK> {
	public abstract BaseDAO<T, PK> getDAO();

	public void batchInsert(List<T> list) {
		getDAO().batchInsert(list);
	}

	public void batchUpdateByPrimaryKey(List<T> list) {
		getDAO().batchUpdateByPrimaryKey(list);
	}

	public void batchDeleteByPrimaryKey(List<T> list) {
		getDAO().batchDeleteByPrimaryKey(list);
	}

	public List<T> selectByExample(Map<String, Object> cond) {
		return getDAO().selectByExample(cond);
	}

	public T selectByPrimaryKey(T entity) {
		return getDAO().selectByPrimaryKey(entity);
	}

	public void deleteByPrimaryKey(T entity) {
		getDAO().deleteByPrimaryKey(entity);
	}

	public void deleteByExample(Map<String, Object> cond) {
		getDAO().deleteByExample(cond);
	}

	public void insert(T entity) {
		getDAO().insert(entity);
	}

	public void insertSelective(T entity) {
		getDAO().insertSelective(entity);
	}

	public Integer countByExample(Map<String, Object> cond) {
		return getDAO().countByExample(cond);
	}

	public void updateByExampleSelective(Map<String, Object> cond) {
		getDAO().updateByExampleSelective(cond);
	}

	public void updateByExample(Map<String, Object> cond) {
		getDAO().updateByExample(cond);
	}

	public void updateByPrimaryKeySelective(T entity) {
		getDAO().updateByPrimaryKeySelective(entity);
	}

	public void updateByPrimaryKey(T entity) {
		getDAO().updateByPrimaryKey(entity);
	}

}
