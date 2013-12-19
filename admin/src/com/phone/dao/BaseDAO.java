package com.phone.dao;

import java.util.List;
import java.util.Map;

public interface BaseDAO<T, PK> {

	public void batchInsert(List<T> list);
	
	public void batchUpdateByPrimaryKey(List<T> list);
	
	public void batchDeleteByPrimaryKey(List<T> list);

	public List<T> selectByExample(Map<String, Object> cond);

	public T selectByPrimaryKey(T entity);

	public void deleteByPrimaryKey(T entity);

	public void deleteByExample(Map<String, Object> cond);

	public void insert(T entity);

	public void insertSelective(T entity);

	public Integer countByExample(Map<String, Object> cond);

	public void updateByExampleSelective(Map<String, Object> cond);

	public void updateByExample(Map<String, Object> cond);

	public void updateByPrimaryKeySelective(T entity);

	public void updateByPrimaryKey(T entity);

}
