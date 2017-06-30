package com.qin.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 欢迎页面
 * @author tan lei
 * @date 2016年10月13日 上午12:59:38
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
}
