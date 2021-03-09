package com.lzl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lzl.entity.Rooms;
import com.lzl.mapper.RoomMapper;
import com.lzl.service.RoomService;
import com.lzl.util.Formatter;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomMapper roomMapper;

	@Override
	public List<Rooms> getAllRoom() throws Exception {
		Map map = new HashMap<String, Object>();
		Long today = Formatter.todayDateString();
		map.put("today", today);
		Long tomorrow = Formatter.tomorrowDateString();
		map.put("tomorrow", tomorrow);
		return roomMapper.getAllRoom(map);
	}

//	@Override
//	public List<Rooms> getAllRoomInfo() throws Exception {
//		// TODO Auto-generated method stub
//		return roomMapper.getRoomInfo();
//	}
	@Override
	public Rooms getOneRoom(Rooms rooms) throws Exception {
		// TODO Auto-generated method stub
		return roomMapper.getOneRoom(rooms);
	}

	@Override
	public List<Rooms> getRoomByAttr(Rooms rooms) throws Exception {
		// TODO Auto-generated method stub
		return roomMapper.getRoomByAttr(rooms);
	}

	@Override
	public Boolean updateRoomInfo(Rooms rooms) throws Exception {
		// TODO Auto-generated method stub
		if(rooms.getRoomPrice()>0) {
			Long updateDate = Formatter.thisTimeString();
			rooms.setUpdateDate(updateDate);
			return roomMapper.updateRoomInfo(rooms)>0;
		}
		else
			return false;
	}

	@Override
	public Boolean addRoom(Rooms rooms) throws Exception {
		Long createDate = Formatter.thisTimeString();
		rooms.setCreateDate(createDate);
		return roomMapper.addRoom(rooms)>0;
	}

	@Override
	public Integer getRoomNum() throws Exception {
		return roomMapper.getAllRoomNum();
	}
	@Override
	public Boolean delRoom(String roomNo) throws Exception {
		// TODO Auto-generated method stub
		return roomMapper.delRoom(roomNo)>0;
	}
	@Override
	public Boolean roomFind(String roomNo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(roomMapper.roomFind(roomNo));
		return roomMapper.roomFind(roomNo)>0;
	}
}
