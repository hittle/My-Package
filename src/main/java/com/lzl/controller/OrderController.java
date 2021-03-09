package com.lzl.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.pojo.ResultInfo;
import com.lzl.service.OrderService;

@RestController
public class OrderController {

	@Resource
	private OrderService orderServiceImpl;
	
	@GetMapping("/getStatistic")
	public Object getStatistic()throws Exception{
		ResultInfo resultInfo = null;
		return resultInfo.success("成功获取", orderServiceImpl.getSevenDay());
	}
	@GetMapping("/getAllOrder")
	public Object getAllOrders()throws Exception{
		ResultInfo resultInfo=null;
		return resultInfo.success("成功获取",orderServiceImpl.getAllOrder());
	}
}
