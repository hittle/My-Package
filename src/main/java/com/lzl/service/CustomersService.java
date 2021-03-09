package com.lzl.service;

import java.util.List;
import java.util.Map;

import com.lzl.entity.Customers;
import com.lzl.pojo.User;

/**
 * @author lzl
 *
 */
public interface CustomersService {

	/**
	 * 获取所有用户信息
	 * select * from customers
	 * @return
	 * @throws Exception
	 */
	public List<Customers> getAllCustomers()throws Exception;
	
	public Customers getCustInfo(User user)throws Exception;
	/**
	 * 判断是否存在同样的账号
	 * select account from customers where account = #{account} limit 0,1
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public Integer getOneCustAccount(String account)throws Exception;
	
	/**
	 * 用户登录
	 * select account,password form customers where
	 *  account = #{account} and password = #{password}
	 * @param customers
	 * @return
	 * @throws Exception
	 */
	public Integer loginCheckCust(User user)throws Exception;
	
	/**
	 * 注册用户账号
	 * insert into customers values(default,#{name},#{cardNum},#{photo},
	 * #{account},#{password},#{tel},#{email},#{regTime},#{integral})
	 * @param customers
	 * @throws Exception
	 */
	public Boolean addCust(User user)throws Exception;
	
	/**
	 * 根据条件修改用户信息
	 * "update customers"
	 * "<if test = 'photo != null'> photo = #{photo} </if>"
	 * "<if test = 'password != null'> password = #{password} </if>"
	 * "<if test = 'tel != null'> tel = #{tel} </if>"
	 * "<if test = 'email != null'> email = #{email} </if>"
	 * "where id=#{id}"
	 * @param customers
	 * @throws Exception
	 */
	public Boolean changeInfo(Map customers)throws Exception;
	
	/**
	 * 修改积分
	 * update customers set integral = #{integral} where id = #{id}
	 * @param integral
	 * @throws Exception
	 */
	public Boolean updateIntegral(Integer integral)throws Exception;
}
