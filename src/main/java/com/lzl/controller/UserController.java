package com.lzl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.pojo.ResultInfo;
import com.lzl.pojo.User;
import com.lzl.service.UserService;
@SuppressWarnings({ "unchecked", "unused", "static-access","rawtypes" })
@RestController
public class UserController {

	@Resource
	private UserService userServiceImpl;
	
	@GetMapping("/getAllUserInfo")
	public Object getUserInfo(String identity)throws Exception{
		ResultInfo resultInfo = null;
		if(identity.equals("customer")) {
			resultInfo = resultInfo.success("成功",userServiceImpl.getAllCust());
		}else if(identity.equals("staff")) {
			resultInfo = resultInfo.success("成功", userServiceImpl.getAllStaffs());
		}
		return resultInfo;
	}
	
	@GetMapping("/getCurrentUser")
	public Object getCurrentUser(HttpSession session)throws Exception{
		ResultInfo resultInfo = null;
		User user = (User) session.getAttribute("user");
		Map map = new HashMap<String, Object>();
		map.put("account", user.getAccount());
		map.put("identity", user.getIdentity());
		if(user != null) {
			resultInfo = resultInfo.success("成功",map);
		}else {
			resultInfo = resultInfo.error("未登录");
		}
		return resultInfo;
	}
	@GetMapping("/getUserInfo")
	public Object getUserInfo(HttpSession session)throws Exception{
		ResultInfo resultInfo = null;
		User user = (User) session.getAttribute("user");
		return resultInfo.success("获取成功", userServiceImpl.getUserInfo(user));
	}
	@PostMapping("/changeUserInfo")
	public Object changeUserInfo(@RequestParam Map params,HttpSession session)throws Exception{
		ResultInfo resultInfo = null;
		User user = (User) session.getAttribute("user");
		String identity = user.getIdentity();
		Boolean flag = userServiceImpl.changeUserInfo(params, identity);
		if(flag)
			return resultInfo.success("修改成功");
		else
			return resultInfo.error("修改失败");
	}
	@PostMapping("/changePassword")
	public Object changePassword(@RequestParam Map params,HttpSession session)throws Exception {
		ResultInfo resultInfo = null;
		User user = (User) session.getAttribute("user");
		String identity = user.getIdentity();
		Boolean flag = userServiceImpl.changePassword(params, identity);
		if(flag) {
			user.setPassword((String)params.get("newPass"));
			session.setAttribute("user", user);
			return resultInfo.success("修改成功");
		}
		else {
			return resultInfo.error(210,"修改失败");
		}
	}
}
