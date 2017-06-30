package com.qin.base.controller;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qin.base.entity.Role;
import com.qin.base.service.RoleService;

/**
 * 角色管理
 * @author tan lei
 * @date 2016年10月12日 上午2:19:52
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	Logger logger = Logger.getLogger(this.getClass());
	
	private Integer ddd;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, String parameter1, String parameter2, String parameter3, String parameter4, String parameter5, String parameter6, HttpServletRequest request) {
		logger.info("进入oleController --> list..........................");
		logger.info("parameter1:"+parameter1+"-------"+request.getParameter("parameter1"));
		logger.info("parameter2:"+parameter2+"-------"+request.getParameter("parameter2"));
		logger.info("parameter3:"+parameter3+"-------"+request.getParameter("parameter3"));
		logger.info("parameter4:"+parameter4+"-------"+request.getParameter("parameter4"));
		logger.info("parameter5:"+parameter5+"-------"+request.getParameter("parameter5"));
		logger.info("parameter6:"+parameter6+"-------"+request.getParameter("parameter6"));
		
		model.addAttribute("parameter1", parameter1);
		model.addAttribute("parameter2", parameter2);
		model.addAttribute("parameter3", parameter3);
		model.addAttribute("parameter4", parameter4);
		model.addAttribute("parameter5", parameter5);
		model.addAttribute("parameter6", parameter6);
		model.addAttribute("roleList", roleService.getRoles());
		
		return "base/role_manage";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String create(Model model, Role role) {
		model.addAttribute("entity", role);
		return "base/role_edit";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id){
		model.addAttribute("entity", roleService.getRole(id));
		return "base/role_edit";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Model model, Role role){
		roleService.save(role);
		return "redirect:/role";
	}
	
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable Integer id){
		model.addAttribute("entity", roleService.getRole(id));
		return "base/role_view";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable Integer id){
		roleService.delete(id);
		return "redirect:/role";
	}
	
	/**
	 * 转到UserController
	 */
	@RequestMapping(value="/redirect_user", method = RequestMethod.GET)
	public String redirectUser(){
		return "redirect:/user";
	}
	
	@ModelAttribute("allRoles")
	public List<Role> preperList() {
		System.out.println("执行了preperList()。。。。。");
		return roleService.getRoles();
	}
	
	public static void main(String[] args) {
		
		System.out.println(isInteger("30980014"));
		RoleController dd = new RoleController();
		System.out.println(dd.getDdd());
		System.out.println(dd.getDdd() == 0);
	}
	
	/**
	 * 判断是否为整数
	 * @param str 传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	
}
