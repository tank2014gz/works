package com.phone.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.phone.dao.BaseDAO;

@SuppressWarnings("deprecation")
public abstract class BaseDAOImpl<T, PK> extends SqlMapClientDaoSupport
		implements BaseDAO<T, PK> {
	public static final int BATCH_MAX_SIZE = 500;
	
	private final static Logger logger = Logger.getLogger(BaseDAOImpl.class);

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		if(logger.isDebugEnabled()){
			logger.debug(persistentClass);
		}
	}

	private String getNameSpace() {
		return persistentClass.getName();
	}

	@SuppressWarnings("unchecked")
	public void batchInsert(final List<T> list) {
		if(logger.isDebugEnabled()){
			logger.debug("batchInsert list size="+list.size());
		}
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				int count = 0;
				for (T record : list) {
					executor.insert(getNameSpace() + ".insert", record);
					if (++count % BATCH_MAX_SIZE == 0) {
						executor.executeBatch();
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public void batchUpdateByPrimaryKey(final List<T> list) {
		if(logger.isDebugEnabled()){
			logger.debug("batchUpdateByPrimaryKey list size="+list.size());
		}
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				int count = 0;
				for (T record : list) {
					executor.update(getNameSpace() + ".updateByPrimaryKey", record);
					if (++count % BATCH_MAX_SIZE == 0) {
						executor.executeBatch();
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}
	
	
	@SuppressWarnings("unchecked")
	public void batchDeleteByPrimaryKey(final List<T> list) {
		if(logger.isDebugEnabled()){
			logger.debug("batchDeleteByPrimaryKey list size="+list.size());
		}
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				int count = 0;
				for (T record : list) {
					executor.delete(getNameSpace() + ".deleteByPrimaryKey", record);
					if (++count % BATCH_MAX_SIZE == 0) {
						executor.executeBatch();
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}

	public Integer countByExample(Map<String, Object> cond) {
		if(logger.isDebugEnabled()){
			logger.debug("countByExample conditions="+cond);
		}
		return (Integer) getSqlMapClientTemplate().queryForObject(
				getNameSpace() + ".countByExample", cond);
	}

	public void deleteByExample(Map<String, Object> cond) {
		if(logger.isDebugEnabled()){
			logger.debug("deleteByExample conditions="+cond);
		}
		getSqlMapClientTemplate().delete(getNameSpace() + ".deleteByExample",
				cond);
	}

	public void deleteByPrimaryKey(T entity) {
		if(logger.isDebugEnabled()){
			logger.debug("deleteByPrimaryKey entity="+entity);
		}
		getSqlMapClientTemplate().delete(
				getNameSpace() + ".deleteByPrimaryKey", entity);
	}

	public void insert(T entity) {
		if(logger.isDebugEnabled()){
			logger.debug("insert entity="+entity);
		}
		getSqlMapClientTemplate().insert(getNameSpace() + ".insert", entity);
	}

	public void insertSelective(T entity) {
		if(logger.isDebugEnabled()){
			logger.debug("insertSelective entity="+entity);
		}
		getSqlMapClientTemplate().insert(getNameSpace() + ".insertSelective",
				entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> selectByExample(Map<String, Object> cond) {
		if(logger.isDebugEnabled()){
			logger.debug("selectByExample conditions="+cond);
		}
		return (List<T>) getSqlMapClientTemplate().queryForList(
				getNameSpace() + ".selectByExample", cond);
	}

	@SuppressWarnings("unchecked")
	public T selectByPrimaryKey(T entity) {
		if(logger.isDebugEnabled()){
			logger.debug("selectByPrimaryKey entity="+entity);
		}
		return (T) getSqlMapClientTemplate().queryForObject(
				getNameSpace() + ".selectByPrimaryKey", entity);
	}

	public void updateByExample(Map<String, Object> cond) {
		if(logger.isDebugEnabled()){
			logger.debug("updateByExample conditions="+cond);
		}
		getSqlMapClientTemplate().update(getNameSpace() + ".updateByExample",
				cond);
	}

	public void updateByExampleSelective(Map<String, Object> cond) {
		if(logger.isDebugEnabled()){
			logger.debug("updateByExampleSelective conditions="+cond);
		}
		getSqlMapClientTemplate().update(
				getNameSpace() + ".updateByExampleSelective", cond);
	}

	public void updateByPrimaryKey(T entity) {
		if(logger.isDebugEnabled()){
			logger.debug("updateByPrimaryKey entity="+entity);
		}
		getSqlMapClientTemplate().update(
				getNameSpace() + ".updateByPrimaryKey", entity);
	}

	public void updateByPrimaryKeySelective(T entity) {
		if(logger.isDebugEnabled()){
			logger.debug("updateByPrimaryKeySelective entity="+entity);
		}
		getSqlMapClientTemplate().update(
				getNameSpace() + ".updateByPrimaryKeySelective", entity);
	}

}
