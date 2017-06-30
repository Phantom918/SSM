package com.qin.base.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qin.base.entity.User;
import com.qin.base.service.UserService;

/**
 * 用户管理
 * @author tan lei
 * @date 2016年10月12日 上午2:40:24
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	/**
	 * 日志
	 */
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, User user) {
		model.addAttribute("list", userService.queryResult(user));
		model.addAttribute("entity", user);
		return "base/user_list";
	}
	
	@RequestMapping("/forTest")
	public String forTest() {
		
		logger.info("=============进入方法......");
		System.out.println("=============进入方法.....");
		
		return "base/user_list";
	}

	@ResponseBody
	@RequestMapping(value = "/validateName", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public Map<String, Object> validateName(@RequestParam String name) {
		
		logger.info("name:"+name);
		List<User> list = new ArrayList<User>();  
	    User um = new User();
	    um.setId(1000);
	    um.setUsername("小明");
	    um.setPassword("xiaoming");
	    list.add(um);
	    
	    User um1 = new User();
	    um1.setId(2000);
	    um1.setUsername("小雨");
	    um1.setPassword("xiaoyu");
	    list.add(um1);
	    
	    Map<String, Object> modelMap = new HashMap<String, Object>();
	    modelMap.put("total", list.size());
	    modelMap.put("data", list);
	    modelMap.put("success", "true");
	    modelMap.put("specialPeople","苏羽瓷");
		
		return modelMap;
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, 
    		ModelMap model, String specialName) {  
		
		logger.info("进入文件上传.......................specialName:"+specialName);
		logger.info("进入文件上传.......................file:"+file);
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        logger.info("文件名："+fileName);
        logger.info("path："+path);
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        model.addAttribute("parameter1", request.getContextPath()+"/upload/"+fileName);  
        
        return "redirect:/role";
    }
	
	@RequestMapping(value="/uploadkm", method = RequestMethod.POST)
	public String uploadkm(Model model, User user,ModelMap modelMap){
		 
		logger.info("进入页面参数绑定......................");
		logger.info("user......................:"+user.getId());
		logger.info("user......................:"+user.getUsername());
		logger.info("user......................:"+user.getPassword());
		logger.info("user......................:"+user.getRole());
		logger.info("user......................:"+user.getRole().getId());
		logger.info("user......................:"+user.getRole().getName());
		model.addAttribute("parameter1", "d1");
		model.addAttribute("parameter2", "d2");
		modelMap.put("parameter3", "d3");
		modelMap.put("parameter4", "d4");
		modelMap.addAttribute("parameter5", "d5");
		modelMap.addAttribute("parameter6", "d6");
		
		return "redirect:/role";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/**
	 * * 将需要的内容编码
	 * @param content 需要编码的内容
	 * @return 编码后的内容
	 */
	public static String utf8Encode(String content) {
		String result = "";
		try {
			result = URLEncoder.encode(content, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    
	    return result;
	}
	
}
