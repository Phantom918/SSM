package com.qin.base.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * MyBatis的Dao基类
 * @author tan lei
 * @date 2016年10月10日 上午12:56:38
 */
public class MyBatisDao extends SqlSessionDaoSupport {

	public void save(String key, Object object) {
		getSqlSession().insert(key, object);
	}
	
	public void delete(String key, Serializable id) {
		getSqlSession().delete(key, id);
	}

	public void delete(String key, Object object) {
		getSqlSession().delete(key, object);
	}
	
	public <T> T get(String key, Object params) {
		return getSqlSession().selectOne(key, params);
	}
	
	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}
	
	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}
	
}
