package com.lzl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lzl.entity.Rooms;
import com.lzl.pojo.RoomInfo;

public interface OpenRoomMapper {

	@Select("select o.id,o.totalmoney,o.livedate,o.days,o.leavedate,o.orderMemo,o.orderterm,c.name,c.cardnum,r.roomNo,r.roomPrice"
			+ ",rt.roomtypename as roomtype, 1 as roomstate from orders o inner join customers c on o.userobj=c.id inner join rooms r on o.roomobj=r.roomno inner join roomtype rt on r.roomtypeobj=rt.id "
			+ "where o.livedate<#{tomorrow} and o.orderterm>=#{todayNoon} and o.orderstate='book'")
	public List<RoomInfo> getOpenRoom(Map map)throws Exception;
	
	@Select("select r.*,0 as roomstate,rt.roomtypename roomtype from rooms r inner join roomtype rt on r.roomtypeobj=rt.id where r.roomno not in (select o.roomobj as roomno from "
			+ "orders o where o.livedate<#{tomorrow} and o.orderterm>=#{todayNoon} and o.orderstate='book')")
	public List<Rooms> getNotOpenRoom(Map map)throws Exception;
	
	@Select("select count(*) from orders o inner join customers c on o.userobj=c.id where c.cardnum=#{cardNum} and o.livedate<=#{liveDate} and o.orderTerm>=#{liveDate}")
	public Integer userOrder(Map map)throws Exception;
	
	@Select("select count(*) from orders where roomobj=#{roomNo} and livedate>#{liveDate} and livedate<=#{leaveDate}")
	public Integer continueRoom(Map map)throws Exception;
	
	@Update("update orders set days=#{days},orderterm=#{orderTerm},totalmoney=#{totalMoney},ordermemo=#{orderMemo} where id=#{orderId}")
	public Integer checkContinue(Map map)throws Exception;
	
	@Update("update orders set orderstate='complete' where id=#{orderId}")
	public Integer cancelOrder(Map map)throws Exception;
	
	@Update("update orders set leavedate=#{leaveDate},orderstate='complete' where id=#{orderId} and roomobj=#{roomNo}")
	public Integer checkOut(Map map)throws Exception;
	
	@Select("select r.roomno from rooms r inner join roomtype rt on r.roomtypeobj=rt.id where rt.roomtypename=#{roomType} and r.roomno not in ("
			+ "select o.roomobj as roomno from orders o where o.livedate<=#{liveDate} and o.orderterm>=#{orderTerm})")
	public List<String> getSimpleRoom(Map map)throws Exception;
	
	@Update("update orders set roomobj=#{newRoomNo} where id=#{orderId} ")
	public Integer changeRoom(Map map)throws Exception;
}
