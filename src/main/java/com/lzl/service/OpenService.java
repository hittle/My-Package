package com.lzl.service;

import java.util.List;
import java.util.Map;

import com.lzl.entity.Rooms;
import com.lzl.pojo.RoomInfo;

public interface OpenService {

	public List<RoomInfo> getOpenRoom(Map map)throws Exception;
	
	public List<Rooms> getNotOpenRoom(Map map)throws Exception;
	
	public Boolean checkOut(Map map)throws Exception;
	
	public Boolean openRoom(Map map)throws Exception;
	
	public List<String> getSimpleRoom(Map map)throws Exception;
	
	public Boolean changeRoom(Map map)throws Exception;
	
	public Boolean continueRoom(Map map)throws Exception;
	
	public Boolean cancelRoom(Map map)throws Exception;
}
