package com.lzl.service;

import java.util.List;

import com.lzl.entity.Log;
import com.lzl.entity.Orders;

public interface LogService {

	public List<Orders> getOrdersLog(Integer index,Integer pageNum)throws Exception;
	
	public List<Log> getAllLogs() throws Exception;
	
	
}
