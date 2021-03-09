package com.lzl.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.pojo.OrderInfo;
import com.lzl.pojo.Page;
import com.lzl.pojo.ResultInfo;
import com.lzl.service.LogService;
import com.lzl.service.OrderService;

@RestController
public class LogController {

	@Resource
	private LogService logServiceImpl;
	
	@Resource
	private OrderService orderServiceImpl;
	
	@GetMapping("/getLog")
	public Object getLog(Map map)throws Exception{
		ResultInfo resultInfo = null;
		
		return resultInfo.success("成功获取", logServiceImpl.getAllLogs());
	}
	@PostMapping("/getHistory")
	public Object getHistory(Page page)throws Exception{
		ResultInfo resultInfo = null;
		return resultInfo.success("成功获取", orderServiceImpl.getHistory(page));
	}
	@GetMapping("/getHistoryLength")
	public Object getHistoryLength()throws Exception{
		ResultInfo resultInfo = null;
		return resultInfo.success("成功获取",orderServiceImpl.getHistoryLength());
	}
	
	@PostMapping("/searchHistory")
	public Object searchHistory(@RequestParam Map<String,Object> params)throws Exception{
		ResultInfo resultInfo=null;
		List<OrderInfo> orderInfos = orderServiceImpl.getSearchHistory(params);
		if(orderInfos != null)
		return resultInfo.success("成功",orderInfos);
		else 
			return resultInfo.error("查找失败");
	}
}
