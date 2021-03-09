package com.lzl.service.impl;

import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzl.entity.Orders;
import com.lzl.mapper.OrderMapper;
import com.lzl.mapper.RoomMapper;
import com.lzl.pojo.HomeData;
import com.lzl.pojo.OrderInfo;
import com.lzl.pojo.Page;
import com.lzl.service.OrderService;
import com.lzl.util.Formatter;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private RoomMapper roomMapper;

	@Override
	public List<Orders> getAllOrder() throws Exception {
		return orderMapper.getAllOrder();
	}

	@Override
	public List<Orders> getOrderByAttr(Orders orders) throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.getOrderByAttr(orders);
	}

	@Override
	public void addOrder(Orders orders) throws Exception {
		// TODO Auto-generated method stub
		orderMapper.addOrder(orders);
	}

	@Override
	public void updateOrderInfo(Orders orders) throws Exception {
		// TODO Auto-generated method stub
		orderMapper.updateOrderInfo(orders);
	}

	@Override
	public List<HomeData> getNewOrders() throws Exception {
		// TODO Auto-generated method stub
		Map map = new HashMap<String, Object>();
		Long today = Formatter.todayDateString();
		map.put("today", today);
		Long sevenDay = Formatter.sevenDayAfterDateString();
		map.put("sevenDay", sevenDay);
		return orderMapper.getNewOrder(map);
	}

	@Override
	public Integer getTodayCust() throws Exception {
		// TODO Auto-generated method stub
		Map map=new HashMap<String,Object>();
		Long thisTime = Formatter.thisTimeString();
		map.put("thisTime", thisTime);
		return orderMapper.getTodayCust(map);
	}

	@Override
	public Integer getTodayRoom() throws Exception {
		// TODO Auto-generated method stub
		Map map=new HashMap<String,Object>();
		Long thisTime = Formatter.thisTimeString();
		map.put("thisTime", thisTime);
		return orderMapper.getTodayRoom(map);
	}

	@Override
	public Double getProfitToday() throws Exception {
		Map map = new HashMap<String,Object>();
		Long thisTime = Formatter.thisTimeString();
		map.put("thisTime", thisTime);
		Long today = Formatter.todayDateString();
		map.put("today", today);
		return orderMapper.getProfitToday(map);
	}
	@Override
	public List<OrderInfo> getSevenDay() throws Exception {
		// TODO Auto-generated method stub
		Map map = new HashMap<String,Object>();
		Long sevenDayNoon=Formatter.sevenDayFrontDateString();
		map.put("sevenDayNoon", sevenDayNoon);
		Long todayEven = Formatter.tomorrowDateString();
		map.put("todayEven", todayEven);
		return orderMapper.getSevenDayData(map);
	}
	
	@Override
	public List<OrderInfo> getHistory(Page page) throws Exception {
		// TODO Auto-generated method stub
		int index = page.getIndex();
		int pageNum = page.getPageNum();
		Map pageMap = new HashMap<String,Object>();
		Integer min = (index-1)*pageNum;
		Integer max = index*pageNum;
		pageMap.put("min", min);
		pageMap.put("max", max);
		return orderMapper.getOrdersHistory(pageMap);
	}
	
	@Override
	public Integer getHistoryLength() throws Exception {
		// TODO Auto-generated method stub
		return orderMapper.getHistoryLength();
	}

	@Override
	public List<OrderInfo> getSearchHistory(Map map) throws Exception {
		// TODO Auto-generated method stub
		
		String date = (String) map.get("date");
		Long thatDay = Formatter.dateToStamp(date)+24*3600*1000;
		Long thisDay = Formatter.dateToStamp(date);
		map.put("thatDay", thatDay);
		map.put("thisDay", thisDay);
		System.out.println(map.toString());
		return orderMapper.getSearchHistory(map);
	}
}
