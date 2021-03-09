package com.lzl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.lzl.entity.Log;
import com.lzl.entity.Orders;

public interface LogMapper {

	@Select("select * from orders where orderstate='complete' and "
	+ "livedate+days*3600*24*1000<#{todayNoon} order by livedate desc limit #{min},#{max} ")
	public List<Orders> getOrdersLog(Map map)throws Exception;
	
	@Select("select * from log")
	public List<Log> getAllLogs()throws Exception;
	
	
}
