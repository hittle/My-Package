package com.lzl.service;

import java.util.List;
import java.util.Map;

import com.lzl.entity.Staffs;
import com.lzl.pojo.User;

public interface StaffService {

	/**
	 * 获取所有员工信息
	 * select * from staffs
	 * @return
	 * @throws Exception
	 */
	public List<Staffs> getAllStaffs()throws Exception;
	
	/**
	 * 获取一个用户的信息
	 * @return
	 * @throws Exception
	 */
	public Staffs getOneStaff(User user)throws Exception;
	/**
	 * 登录
	 * "select account,password from staffs "
			+ "where account = #{account} and password = #{password}"
	 * @param staffs
	 * @return
	 * @throws Exception
	 */
	public Boolean loginCheck(User user)throws Exception;
	
	/**
	 * 更新员工信息
	 * "script>"
			+ "update staffs"
			+ "set>"
			+ "if test = 'password != null'> password = #{password} /if>"
			+ "if test = 'photo != null'> photo = #{photo} /if>"
			+ "if test = 'tel != null'> tel = #{tel} /if>"
			+ "if test = 'email != null' > email = #{email} /if>"
			+ "/set>"
			+ "where id = #{id}"
			+ "/script>"
	 * @param staffs
	 * @throws Exception
	 */
	public void changeStaffInfo(Map  staffs)throws Exception;
	
	/**
	 * 注册新员工
	 * "insert into staffs values(default,#{name}，#{account},"
			+ "#{password},#{photo},#{tel},#{email},#{address},#{cardNum})"
	 * @param staffs
	 * @throws Exception
	 */
	public Boolean addStaff(User user)throws Exception;
	
	/**
	 * 删除员工
	 * delete from staffs where id = #{id}
	 * @param id
	 * @throws Exception
	 */
	public void delStaff(Integer id)throws Exception;
}
