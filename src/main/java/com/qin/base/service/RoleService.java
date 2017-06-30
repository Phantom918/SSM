package com.qin.base.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qin.base.dao.MyBatisDao;
import com.qin.base.entity.Role;

/**
 * 角色管理
 * @author tan lei
 * @date 2016年10月10日 上午11:24:57
 */
@Service
public class RoleService {
	
	Logger loggerr = Logger.getLogger(this.getClass());

	@Autowired
	private MyBatisDao myBatisDao;
	
	/**
	 * 查询所有角色
	 * @return 角色集合
	 */
	@Cacheable(value="MyCache", key="'getRoles'")
	public List<Role> getRoles() {
		loggerr.info("查询所有角色信息.............................");
		return myBatisDao.getList("roleMapper.selectByEntity");
	}
	
	/**
	 * 根据主键查询角色
	 * @param id 角色ID
	 * @return 角色VO
	 */
	public Role getRole(Serializable id) {
		return myBatisDao.get("roleMapper.selectByPrimaryKey", id);
	}
	
	/**
	 * 新增或者修改角色记录
	 * @param role 角色对象
	 * allEntries是boolean类型，表示是否需要清除缓存中的所有元素。默认为false，表示不需要。
	 * 当指定了allEntries为true时，Spring Cache将忽略指定的key。有的时候我们需要Cache一下清除所有的元素，
	 * 这比一个一个清除元素更有效率。
	 */
	@CacheEvict(value="MyCache", key="'getRoles'", allEntries=false)
	public void save(Role role){
		loggerr.info("清除缓存RoleList....................................");
		if(role.getId() == null)
			myBatisDao.save("roleMapper.insert", role);
		else
			myBatisDao.save("roleMapper.update", role);
	}
	
	/**
	 * 删除角色
	 * @param id 角色ID
	 */
	public void delete(Serializable id){
		myBatisDao.delete("roleMapper.delete", id);
	}
}
