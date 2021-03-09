package com.lzl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lzl.pojo.ResultInfo;
import com.lzl.service.OpenService;

@RestController
public class OpenRoomController {

	@Resource
	private OpenService openServiceImpl;
	
	@PostMapping("/getOpen")
	public Object getOpen(@RequestParam Map<String,Object> parms)throws Exception{
		Map map = new HashMap<String, Object>();
		ResultInfo resultInfo = null;
		map.put("open", openServiceImpl.getOpenRoom(parms));
		return resultInfo.success("成功", map);
	}
	
	@PostMapping("/getNotOpen")
	public Object getNotOpen(@RequestParam Map<String,Object> parms)throws Exception{
		Map map = new HashMap<String, Object>();
		ResultInfo resultInfo = null;
		map.put("notOpen", openServiceImpl.getNotOpenRoom(parms));
		return resultInfo.success("成功", map);
	}
	@PostMapping("/checkOut")
	public Object checkOut(@RequestParam Map<String,Object> params) throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = openServiceImpl.checkOut(params);
		if(flag)
			return resultInfo.success("退房成功");
		else
			return resultInfo.error("退房失败");
	}
	
	@PostMapping("/openRoom")
	public Object openRoom(@RequestParam Map<String,Object> params) throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = openServiceImpl.openRoom(params);
		if(flag)
			return resultInfo.success("开房成功");
		else
			return resultInfo.error(210,"该段时间已开了房");
	}
	@PostMapping("/changeRoom")
	public Object changeRoom(@RequestParam Map<String,Object> params) throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = openServiceImpl.changeRoom(params);
		if(flag)
			return resultInfo.success("换房成功");
		else 
			return resultInfo.error("换房失败");
	}
	
	@PostMapping("/getSimpleRoom")
	public Object getSimpleRoom(@RequestParam Map<String,Object> params)throws Exception{
		ResultInfo resultInfo = null;
		
		return resultInfo.success("成功",openServiceImpl.getSimpleRoom(params));
	}
	@PostMapping("/cancelRoom")
	public Object cancelRoom(@RequestParam Map<String,Object> params)throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = openServiceImpl.cancelRoom(params);
		if(flag)
			return resultInfo.success("取消成功");
		else
			return resultInfo.error("取消失败");
	}
	@PostMapping("/continueRoom")
	public Object continueRoom(@RequestParam Map<String,Object> params)throws Exception{
		ResultInfo resultInfo = null;
		Boolean flag = openServiceImpl.continueRoom(params);
		if(flag)
			return resultInfo.success("续期成功");
		else
			return resultInfo.error("续期失败");
	}
}
