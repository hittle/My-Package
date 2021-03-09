package com.lzl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.pojo.ResultInfo;
import com.lzl.service.OrderService;
import com.lzl.service.RoomService;

@RestController
public class HomeController {

	@Resource
	private OrderService orderServiceImpl;
	@Resource
	private RoomService roomServiceImpl;
	
	@GetMapping("/getHomeData")
	public Object getHomeData()throws Exception{
		Map map = new HashMap<String, Object>();
		ResultInfo resultInfo=null;
		map.put("newOrder", orderServiceImpl.getNewOrders());
		map.put("users", orderServiceImpl.getTodayCust());
		int roomNum = orderServiceImpl.getTodayRoom();
		map.put("rooms", roomNum);
		map.put("surplusRooms", roomServiceImpl.getRoomNum()-roomNum);
		double money = 0;
		if(orderServiceImpl.getProfitToday()!=null) {
			money = orderServiceImpl.getProfitToday();
		};
		map.put("money",money);
		return resultInfo.success("成功获取", map);
	}
}
