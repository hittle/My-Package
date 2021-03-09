package com.lzl.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Map;

import org.mockito.internal.stubbing.defaultanswers.TriesToReturnSelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzl.entity.Customers;
import com.lzl.entity.Staffs;
import com.lzl.mapper.CustomerMapper;
import com.lzl.mapper.StaffMapper;
import com.lzl.pojo.User;
import com.lzl.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public List<Staffs> getAllStaffs() throws Exception {
		// TODO Auto-generated method stub
		return staffMapper.getAllStaffs();
	}

	@Override
	public List<Customers> getAllCust() throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.getAllCustomers();
	}

	@Override
	public String getCurrentUser() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		if(user.getIdentity().equals("customer")) {
			return customerMapper.getCustInfo(user);
		}else if(user.getIdentity().equals("staff")|| user.getIdentity().equals("admin")) {
			System.out.println(user.toString());
			return staffMapper.getOneStaff(user);
		}else {
			return null;
		}
			
	}

	@Override
	public Boolean changeUserInfo(Map map,String identity) throws Exception {
		// TODO Auto-generated method stub
		if(identity.equals("customer"))
			return customerMapper.changeInfo(map)>0;
		else if(identity.equals("staff")||identity.equals("admin")) {
			return staffMapper.changeStaffInfo(map)>0;
		}else
			return false;
	}

	@Override
	public Boolean changePassword(Map map,String identity) throws Exception {
		// TODO Auto-generated method stub
		if(identity.equals("customer")) {
			if(customerMapper.getOldPassword(map)>0)
				return customerMapper.changePassword(map)>0;
			else
				return false;
		}
		else if(identity.equals("staff")||identity.equals("admin")) {
			if(staffMapper.getOldPassword(map)>0)
				return staffMapper.changePassword(map)>0;
			else 
				return false;
		}else 
			return false;
	}

	@Override
	public Boolean loginCheck(User user) throws Exception {
		String identity = user.getIdentity();
		if(identity.equals("customer")) {
			return customerMapper.loginCheckCust(user)>0;
		}else if(identity.equals("staff")||identity.equals("admin")) {
			return staffMapper.loginCheck(user)>0;
		}else
			return false;
	}

	@Override
	public User getUserIdentity(User user) throws Exception {
		// TODO Auto-generated method stub
		if(user.getIdentity().equals("staff")) {
			return staffMapper.getUserIdentity(user);
		}else
			return user;
	}

	
}
