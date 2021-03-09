package com.lzl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.One;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lzl.entity.Rooms;


public interface RoomMapper {

	/**
	 * 获取所有房间信息
	 * @return
	 * @throws Exception
	 */
	@Results({
		@Result(property="roomNo",id=true,column="roomno"),
		@Result(property="roomTypeObj",column="roomtypeobj"),
		@Result(property="roomPhoto",column="roomphoto"),
		@Result(property="roomPrice",column="roomprice"),
		@Result(property="floorNum",column="floornum"),
		@Result(property="roomDesc",column="roomdesc"),
		@Result(property="roomType",column="roomtype"),
		@Result(property="createDate",column="createdate"),
		@Result(property="updateDate",column="updateDate"),
		@Result(property="roomState",column="{roomNo=roomNo,today=today,tomorrow=tomorrow}",one=@One(select="com.lzl.mapper.RoomMapper.getOneOrder",fetchType=FetchType.LAZY)),
	})
	@Select("select r.*,rt.roomtypename roomtype, #{today} as today ,#{tomorrow} as tomorrow from rooms r inner join roomtype rt on r.roomtypeobj=rt.id")
	public List<Rooms> getAllRoom(Map<String, Object> map)throws Exception;
	
//	@Select("select r.roomno,rt.roomtypename roomtype,r.price,r.updatedate,r.createdate"
//			+ " from rooms r inner join roomtype rt on r.roomtyoeobj=rt.id")
//	public List<Rooms> getRoomInfo()throws Exception;
	
	@Select("select count(*) from rooms")
	public Integer getAllRoomNum()throws Exception;
	
	@Select("select count(*) from orders where roomobj=#{roomNo} and livedate <= #{tomorrow} and livedate >= #{today}")
	public Integer getOneOrder(Map<String, Object> map)throws Exception;
	
	@Select("select roomtypename from roomtype where id=#{id}")
	public String getRoomType(Integer id)throws Exception;
	/**
	 * 获取一个房间信息
	 * @param rooms
	 * @return
	 * @throws Exception
	 */
	@Select("select * from rooms where id = #{id}")
	public Rooms getOneRoom(Rooms rooms)throws Exception;
	
	/**
	 * 根据条件获取信息
	 * @param rooms
	 * @return
	 * @throws Exception
	 */
	@Select("<script>"
			+ "select * from rooms"
			+ "<where>"
			+ "<if test = 'roomTypeObj != 0'> and roomTypeObj = #{roomTypeObj} </if>"
			+ "<if test = 'roomPrice != 0'> and roomPrice &lt; #{maxPrice} and roomPrice &gt; #{minPrice} </if>"
			+ "<if test = 'floorNum != 0' > and floornum = #{floorNum} </if>"
			+ "</where>"
			+ "</script>")
	public List<Rooms> getRoomByAttr(Rooms rooms)throws Exception;
	
	/**
	 * 更新房间信息
	 * @param rooms
	 * @throws Exception
	 */
	@Update("<script>"
			+ "update rooms"
			+ "<set>"
			+ "<if test = 'roomPrice &gt; 0'> roomprice = #{roomPrice} ,</if>"
			+ "<if test = 'roomDesc != null'> roomdsec = #{roomDesc}, </if>"
			+ "<if test = 'roomTypeObj != null'> roomtypeobj = #{roomTypeObj}, </if>"
			+ "<if test = 'roomState != null'> roomstate = #{roomState}, </if>"
			+ "<if test = 'updateDate != null'> updatedate = #{updateDate} </if>"
			+ "</set>"
			+ "where roomno = #{roomNo}"
			+ "</script>")
	public Integer updateRoomInfo(Rooms rooms) throws Exception;
	
	/**
	 * 添加房间
	 * @param rooms
	 * @throws Exception
	 */
	@Insert("insert into rooms values(#{roomNo},#{roomTypeObj},#{roomPhoto},"
			+ "#{roomPrice},#{floorNum},#{roomDesc},#{updateDate},#{createDate})")
	public Integer addRoom(Rooms rooms) throws Exception;
	
	@Delete("delete from rooms where roomno=#{roomNo}")
	public Integer delRoom(String roomNo)throws Exception;
	
	@Select("select count(*) from rooms where roomno=#{roomNo}")
	public Integer roomFind(String roomNo)throws Exception;
}
