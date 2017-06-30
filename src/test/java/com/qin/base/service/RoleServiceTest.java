package com.qin.base.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qin.base.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-service.xml")
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;
	
	@Test
	public void getRolesTest(){
		List<Role> list = roleService.getRoles();
		System.out.println("list:"+list.size());
		//Assert.assertEquals(2, list.size());
		System.out.println("list:"+list.size());
	}
	
	@Test
	public void getRoleTest(){
		Role role = roleService.getRole(1000);
		System.out.println("名称："+role.getName());
		//Assert.assertEquals("超级管理员", role.getName());
		System.out.println("名称："+role.getName());
	}
	
}
