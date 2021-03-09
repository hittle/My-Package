package com.lzl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzl.entity.Customers;
import com.lzl.entity.Orders;
import com.lzl.entity.Rooms;
import com.lzl.mapper.CustomerMapper;
import com.lzl.mapper.OpenRoomMapper;
import com.lzl.mapper.OrderMapper;
import com.lzl.pojo.RoomInfo;
import com.lzl.service.OpenService;
import com.lzl.util.Formatter;

@Service
public class OpenServiceImpl implements OpenService{

	@Autowired
	private OpenRoomMapper openRoomMapper;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<RoomInfo> getOpenRoom(Map map) throws Exception {
		// TODO Auto-generated method stub
		Map map1 = new HashMap<String, Object>();
//		String thisDate = (String) map.get("thisDate");
//		String thatDate = (String) map.get("thatDate");
//		System.out.println(map.get("thisDate"));
//		System.out.println(map.get("thatDate"));
		Long todayNoon = Long.parseLong((String)map.get("thisDate"))+12*3600*1000;
		Long tomorrow = Long.parseLong((String)map.get("thatDate"));
//		System.out.println(today);
//		System.out.println(tomorrowEven);
		map1.put("todayNoon", todayNoon);
		map1.put("tomorrow", tomorrow);
		return openRoomMapper.getOpenRoom(map1);
	}

	@Override
	public List<Rooms> getNotOpenRoom(Map map) throws Exception {
		// TODO Auto-generated method stub
		Map map1 = new HashMap<String, Object>();
//		String thisDate = (String) map.get("thisDate");
//		String thatDate = (String) map.get("thatDate");
//		System.out.println(map.get("thisDate"));
//		System.out.println(map.get("thatDate"));
		Long todayNoon = Long.parseLong((String)map.get("thisDate"))+12*3600*1000;
		Long tomorrow = Long.parseLong((String)map.get("thatDate"));
//		System.out.println(today);
//		System.out.println(tomorrowEven);
		map1.put("todayNoon", todayNoon);
		map1.put("tomorrow", tomorrow);
		return openRoomMapper.getNotOpenRoom(map1);
	}

	@Override
	public Boolean checkOut(Map map) throws Exception {
		Long leaveDate = Formatter.thisTimeString();
		map.put("leaveDate", leaveDate);
		return openRoomMapper.checkOut(map)>0;
	}
	
	@Override
	public Boolean openRoom(Map map) throws Exception {
		Customers customers = Customers.builder()
				.name((String)map.get("name"))
				.cardNum((String)map.get("cardNum"))
				.sex((String)map.get("sex"))
				.regTime(Formatter.thisTimeString())
				.build();
		Integer isCust = customerMapper.findUser((String)map.get("cardNum"));
		if(isCust == 0) {
			customerMapper.addCust(customers);
		}
		Orders orders =Orders.builder()
				.roomObj((String)map.get("roomObj"))
				.userObj(customerMapper.getCustId((String)map.get("cardNum")))
				.liveDate(Formatter.dateToLongStamp((String)map.get("liveDate")))
				.days(Integer.parseInt((String)map.get("days")))
				.totalMoney(Double.parseDouble((String)map.get("totalMoney")))
				.orderMemo(Double.parseDouble((String)map.get("orderMemo")))
				.orderState("book")
				.orderDate(Formatter.thisTimeString())
				.orderTerm(Formatter.dateToLongStamp((String)map.get("leaveDate")))
				.build();
		Integer isOrder = orderMapper.addOrder(orders);
		
		return isOrder>0;
	}

	@Override
	public List<String> getSimpleRoom(Map map) throws Exception {
		// TODO Auto-generated method stub
		map.put("liveDate", Formatter.thisTimeString());
		return openRoomMapper.getSimpleRoom(map);
	}
	@Override
	public Boolean changeRoom(Map map) throws Exception {
		return openRoomMapper.changeRoom(map)>0;
	}

	@Override
	public Boolean continueRoom(Map map) throws Exception {
		Map mapCon = new HashMap<String,Object>();
		mapCon.put("roomNo", map.get("roomNo"));
		mapCon.put("liveDate", Long.parseLong((String)map.get("liveDate")));
		mapCon.put("leaveDate", Long.parseLong((String)map.get("leaveDate")));
		if(openRoomMapper.continueRoom(mapCon)==1) {
			mapCon.put("days", map.get("days"));	
			mapCon.put("totalMoney", map.get("totalMoney"));
			mapCon.put("orderMemo", map.get("orderMemo"));
			mapCon.put("orderId", map.get("orderId"));
			mapCon.put("orderTerm", Long.parseLong((String)map.get("leaveDate"))+12*3600*1000);
			return openRoomMapper.checkContinue(mapCon)>0;
		}
		else 
			return false;
	}

	@Override
	public Boolean cancelRoom(Map map) throws Exception {
		return openRoomMapper.cancelOrder(map)>0;
	}
}
