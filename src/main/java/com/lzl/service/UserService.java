package com.lzl.service;

import java.util.List;
import java.util.Map;

import com.lzl.entity.Customers;
import com.lzl.entity.Staffs;
import com.lzl.pojo.User;

public interface UserService {
	
	public List<Staffs> getAllStaffs()throws Exception;
	
	public List<Customers> getAllCust()throws Exception;
	
	public String getCurrentUser()throws Exception;
	
	public Object getUserInfo(User user)throws Exception;
	
	public Boolean changeUserInfo(Map map,String identity)throws Exception;
	
	public Boolean changePassword(Map map,String identity)throws Exception;
	
	public Boolean loginCheck(User user)throws Exception;
	
	public User getUserIdentity(User user)throws Exception;
}
