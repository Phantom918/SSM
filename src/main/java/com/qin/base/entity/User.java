package com.qin.base.entity;

/**
 * 人员管理
 * @author tan lei
 */
public class User {

	private Integer id; //主键
	
	private String username; //登录用户
	
	private String password; //登录密码
	
	private Role role;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
