package com.lzl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.entity.Rooms;
import com.lzl.pojo.ResultInfo;
import com.lzl.service.RoomService;

@RestController
@CrossOrigin
public class RoomController {

	@Resource
	private RoomService roomServiceImpl;
	
	@GetMapping("/getAllRoom")
	public Object getAllRoom(HttpSession session)throws Exception{
		ResultInfo resultInfo = null;
		if(session.getAttribute("user") == null)
			return resultInfo.error("请先登录");
		else 
			return resultInfo.success("获取成功",roomServiceImpl.getAllRoom());
	}
	
	@GetMapping("/deleteRoom")
	public Object delRoom(String roomNo)throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag =roomServiceImpl.delRoom(roomNo);
		if(flag)
			return resultInfo.success("删除成功");
		else {
			return resultInfo.error("删除失败");
		}
	}
	
	@PostMapping("/addRoom")
	public Object addRoom(Rooms rooms)throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = roomServiceImpl.addRoom(rooms);
		if(flag)
			return resultInfo.success("添加成功");
		else {
			return resultInfo.error("添加失败");
		}
	}
	@PostMapping("/modifyRoom")
	public Object modifyRoom(Rooms rooms)throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = roomServiceImpl.updateRoomInfo(rooms);
		if(flag)
			return resultInfo.success("修改成功");
		else {
			return resultInfo.error("修改失败");
		}
	}
	@GetMapping("/roomFind")
	public Object roomFind(String roomNo)throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = roomServiceImpl.roomFind(roomNo);
		System.out.println(roomNo);
		System.out.println(flag);
		if(flag)
			return resultInfo.error("该房间存在");
		else {
			return resultInfo.success("该房间不存在");
		}
	}
}
