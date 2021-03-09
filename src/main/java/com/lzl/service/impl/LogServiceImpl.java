package com.lzl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzl.entity.Log;
import com.lzl.entity.Orders;
import com.lzl.mapper.LogMapper;
import com.lzl.service.LogService;
import com.lzl.util.Formatter;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogMapper logMapper;
	
	@Override
	public List<Orders> getOrdersLog(Integer index,Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		Map map = new HashMap<String, Object>();
		Integer min = (index-1)*pageNum;
		Integer max = index * pageNum;
		Long todayNoon = Formatter.todayNoonDate();
		map.put("min", min);
		map.put("max", max);
		map.put("todayNoon", todayNoon);
		return logMapper.getOrdersLog(map); 
	}

	@Override
	public List<Log> getAllLogs() throws Exception {
		// TODO Auto-generated method stub
		return logMapper.getAllLogs();
	}
	
	
}
