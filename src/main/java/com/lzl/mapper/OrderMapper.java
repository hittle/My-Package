package com.lzl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lzl.entity.Orders;
import com.lzl.pojo.HomeData;
import com.lzl.pojo.OrderInfo;

public interface OrderMapper {

	/**
	 * 获取所有订单信息
	 * @return
	 * @throws Exception
	 */
	@Select("select * from orders")
	public List<Orders> getAllOrder()throws Exception;
	
	@Select("select count(*) from orders where orderstate='complete' "
			+ "and livedate+days*24*3600*1000<unix_timestamp(NOW())")
	public Integer getHistoryLength()throws Exception;
	
	@Select("select r.roomno,rt.roomtypename roomtype,o.totalmoney,o.livedate,o.leavedate,"
			+ "c.name,c.sex,c.cardnum from orders o inner join "
			+ "rooms r on o.roomobj=r.roomno inner join roomtype rt "
			+ "on r.roomtypeobj=rt.id\r\n" + 
			"inner join customers c on o.userobj=c.id where c.name =#{name} "
			+ "and o.livedate<#{thatDay} and o.livedate>#{thisDay}")
	public List<OrderInfo> getSearchHistory(Map map)throws Exception;
	
	@Select("select r.roomno,rt.roomtypename roomtype,o.totalmoney,o.livedate,o.leavedate,"
			+ "c.name,c.sex,c.cardnum from orders o inner join rooms r "
			+ "on o.roomobj=r.roomno inner join roomtype rt on r.roomtypeobj=rt.id\r\n" + 
			"inner join customers c on o.userobj=c.id where o.orderstate='complete' limit #{min},#{max}")
	public List<OrderInfo> getOrdersHistory(Map map) throws Exception;
	
	/**
	 * 根据属性获取订单信息
	 * @param orders
	 * @return
	 * @throws Exception
	 */
	@Select("<script>"
			+ "select * from orders"
			+ "<where>"
			+ "<if test = 'orderState != null' > and orderstate = #{orderState} </if>"
			+ "<if test = 'orderDate != null '> and orderdate &lt; #{orderDate} </if>"
			+ "<if test = 'DateTerm != null '> and orderdate &gt; #{dateTerm} </if>"
			+ "</where>"
			+ "</script>")
	public List<Orders> getOrderByAttr(Orders orders) throws Exception;
	
	@Select("select o.roomobj roomNum,c.name,c.sex,o.orderdate date from orders o inner join "
			+ "customers c on o.userobj = c.id where o.orderdate<#{sevenDay} and o.orderdate>#{today}")
	public List<HomeData> getNewOrder(Map<String, Object> map)throws Exception;
	
	@Select("select count(*) from orders where "
			+ "orderstate='book' and livedate <=#{thisTime} and orderTerm>=#{thisTime}")
	public Integer getTodayCust(Map map)throws Exception;
	
	@Select("select count(*) from orders where livedate <#{thisTime} and orderTerm>=#{thisTime} and "
			+ " orderstate='book'")
	public Integer getTodayRoom(Map map)throws Exception;
	
	@Select("select sum(totalmoney) from orders where orderstate='complete' and livedate < #{thisTime} and leavedate>#{today}")
	public Double getProfitToday(Map map)throws Exception;
	/**
	 * 添加订单
	 * @param orders
	 * @throws Exception
	 */
	@Insert("insert into orders values(default,#{roomObj},"
			+ "#{userObj},#{liveDate},#{leaveDate},#{days},"
			+ "#{totalMoney},#{orderMemo},#{orderState},#{orderDate},#{orderTerm})")
	public Integer addOrder(Orders orders)throws Exception;
	
	/**
	 * 修改订单信息
	 * @param orders
	 * @throws Exception
	 */
	@Update("<script>"
			+ "update orders"
			+ "<set>"
			+ "<if test = 'liveDate > 0'> livedate = #{liveDate} </if>"
			+ "<if test = 'days != 0'> days = #{days} </if>"
			+ "<if test = 'orderState != null' > orderstate = #{orderState} </if>"
			+ "</set>"
			+ "where id = #{id}"
			+ "</script>")
	public void updateOrderInfo(Orders orders)throws Exception;
	
	@Select("select o.livedate,o.leavedate,o.totalmoney,rt.roomtypename roomtype from orders o "
			+ "inner join rooms r on o.roomobj=r.roomno "
			+ "inner join roomtype rt on r.roomtypeobj=rt.id "
			+ " where orderstate='complete' and o.livedate>=#{sevenDayNoon} and o.leavedate<=#{todayEven}")
	public List<OrderInfo> getSevenDayData(Map map)throws Exception;
}
