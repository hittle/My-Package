package com.lzl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzl.service.CustomersService;

@Controller
public class CustomersController {

	@Autowired
	private CustomersService CustomerServiceImpl;
	
	@RequestMapping("/getCust")
	@ResponseBody
	public Object showCustomers()throws Exception{
		return CustomerServiceImpl.getAllCustomers();
	}
}
