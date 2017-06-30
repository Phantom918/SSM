package com.qin.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qin.base.dao.MyBatisDao;
import com.qin.base.entity.User;

@Service
public class UserService {

	@Autowired
	private MyBatisDao myBatisDao;
	
	/**
	 * 根据条件查询
	 */
	public List<User> queryResult(User user){
		return myBatisDao.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return myBatisDao.get("userMapper.selectByPrimaryKey",id);
	}
}
