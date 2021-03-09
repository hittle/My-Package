package com.lzl.service;

import java.util.List;

import com.lzl.entity.Rooms;


/**
 * @author lzl
 *
 */
public interface RoomService {

	/**
	 * 获取所有房间信息
	 * select * from rooms
	 * @return
	 * @throws Exception
	 */
	public List<Rooms> getAllRoom()throws Exception;
	
//	public List<Rooms> getAllRoomInfo()throws Exception;
	/**
	 * 获取一个房间信息
	 * select * from rooms where id = #{id}
	 * @param rooms
	 * @return
	 * @throws Exception
	 */
	public Rooms getOneRoom(Rooms rooms)throws Exception;
	
	/**
	 * 根据条件获取信息
	 * "script>"
			+ "select * from rooms"
			+ "where>"
			+ "if test = 'roomTypeObj != 0'> and roomTypeObj = #{roomTypeObj} /if>"
			+ "if test = 'roomPrice != 0'> and roomPrice < #{maxPrice} and roomPrice > #{minPrice} /if>"
			+ "if test = 'floorNum != 0' > and floornum = #{floorNum} /if>"
			+ "/where>"
			+ "/script>"
	 * @param rooms
	 * @return
	 * @throws Exception
	 */
	public List<Rooms> getRoomByAttr(Rooms rooms)throws Exception;
	
	/**
	 * 更新房间信息
	 * "script>"
			+ "update rooms"
			+ "set>"
			+ "if test = 'roomPrice != 0'> roomprice = #{roomPrice} /if>"
			+ "if test = 'roomDesc != null'> roomdsec = #{roomDesc} /if>"
			+ "if test = 'roomState != null'> roomstate = #{roomState} /if>"
			+ "/set>"
			+ "where id = #{id}"
			+ "/script>"
	 * @param rooms
	 * @throws Exception
	 */
	public Boolean updateRoomInfo(Rooms rooms) throws Exception;
	
	/**
	 * 添加房间
	 * insert into rooms values(default,#{roomTypeObj},#{roomPhoto},"
			+ "#{roomPrice},#{floorNum}.#{roomState},#{roomDesc})
	 * @param rooms
	 * @throws Exception
	 */
	public Boolean addRoom(Rooms rooms) throws Exception;
	
	public Integer getRoomNum()throws Exception;
	
	public Boolean delRoom(String roomNo)throws Exception;
	
	public Boolean roomFind(String roomNo)throws Exception;
}
