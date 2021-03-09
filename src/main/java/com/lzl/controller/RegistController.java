package com.lzl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.entity.Customers;
import com.lzl.pojo.ResultInfo;
import com.lzl.pojo.User;
import com.lzl.service.CustomersService;
import com.lzl.service.StaffService;

@RestController
@CrossOrigin
public class RegistController {

	@Resource
	private CustomersService customersServiceImpl;
	
	@Resource
	private StaffService staffServiceImpl;
	
	
	
	@PostMapping("/regist")
	public ResultInfo regist(User user,HttpServletRequest request,HttpSession session)throws Exception{
		ResultInfo resultInfo = new ResultInfo();
		Boolean flag = staffServiceImpl.addStaff(user);
		if(flag) {
			resultInfo = resultInfo.success("注册成功");
		}else {
			resultInfo = resultInfo.error("注册失败");
		}
		return resultInfo;
	}
}
