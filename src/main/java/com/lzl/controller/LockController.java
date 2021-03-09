package com.lzl.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.pojo.ResultInfo;
import com.lzl.pojo.User;
import com.lzl.service.StaffService;
import com.lzl.service.UserService;

@RestController
public class LockController {

	@Resource
	private StaffService staffServiceImpl;
	
	@Resource
	private UserService userServiceImpl;
	
	@PostMapping("/unlock")
	public Object UnLock(User user,HttpSession session)throws Exception{
		User userLogin = (User) session.getAttribute("user");
		ResultInfo resultInfo = null;
		if(userLogin == null) {
			resultInfo = resultInfo.error("未登录");
		}else {
			userLogin.setPassword(user.getPassword());
			Boolean flag = userServiceImpl.loginCheck(userLogin);
			if(flag) {
				resultInfo = resultInfo.success("解锁成功");
			}else {
				resultInfo = resultInfo.error("密码错误");
			}
		}
		return resultInfo;
	}
}
