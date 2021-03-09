package com.lzl.service;

import java.util.List;
import java.util.Map;

import com.lzl.entity.Orders;
import com.lzl.pojo.HomeData;
import com.lzl.pojo.OrderInfo;
import com.lzl.pojo.Page;
import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

public interface OrderService {

	/**
	 * 获取所有订单信息
	 * select * from orders
	 * @return
	 * @throws Exception
	 */
	public List<Orders> getAllOrder()throws Exception;
	
	/**
	 * 根据属性获取订单信息
	 * "script>"
			+ "select * from orders"
			+ "where>"
			+ "if test = 'orderState != null' > and orderstate = #{orderState} /if>"
			+ "if test = 'orderDate > 0 '> and orderdate < #{orderDate} /if>"
			+ "if test = 'DateTerm >0 '> and orderdate > #{dateTerm} /if>"
			+ "/where>"
			+ "/script>"
	 * @param orders
	 * @return
	 * @throws Exception
	 */
	public List<Orders> getOrderByAttr(Orders orders) throws Exception;
	
	/**
	 * 添加订单
	 * insert into orders values(default,#{roomObj},"
			+ "#{roomTypeObj},#{userObj},#{liveDate},#{days},"
			+ "#{totalMoney},#{orderMemo},#{orderState},#{orderDate})
	 * @param orders
	 * @throws Exception
	 */
	public void addOrder(Orders orders)throws Exception;
	
	public List<HomeData> getNewOrders()throws Exception;
	/**
	 * 修改订单信息
	 * "script>"
			+ "update orders"
			+ "set>"
			+ "if test = 'liveDate > 0'> livedate = #{liveDate} /if>"
			+ "if test = 'days > 0'> days = #{days} /if>"
			+ "if test = 'orderState != null' > orderstate = #{orderState} /if>"
			+ "/set>"
			+ "where id = #{id}"
			+ "/script>"
	 * @param orders
	 * @throws Exception
	 */
	public void updateOrderInfo(Orders orders)throws Exception;
	
	
	public Integer getTodayCust()throws Exception;
	
	public Integer getTodayRoom()throws Exception;
	
	public Double getProfitToday()throws Exception;
	
	public List<OrderInfo> getSevenDay()throws Exception;
	
	public List<OrderInfo> getHistory(Page page) throws Exception;
	
	public Integer getHistoryLength()throws Exception;
	
	public List<OrderInfo> getSearchHistory(Map map)throws Exception;
}
