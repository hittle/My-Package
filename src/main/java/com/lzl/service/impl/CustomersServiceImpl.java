package com.lzl.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzl.entity.Customers;
import com.lzl.mapper.CustomerMapper;
import com.lzl.pojo.ResultInfo;
import com.lzl.pojo.User;
import com.lzl.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService{

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customers> getAllCustomers() throws Exception {
		// TODO Auto-generated method stub
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(200);
		resultInfo.setData(customerMapper.getAllCustomers());
		return customerMapper.getAllCustomers();
	}
	@Override
	public Customers getCustInfo(User user) throws Exception {
		return customerMapper.getCustInfo(user);
	}
	@Override
	public Integer getOneCustAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.getOneCustAccount(account);
	}

	@Override
	public Integer loginCheckCust(User user) throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.loginCheckCust(user);
	}

	@Override
	public Boolean addCust(User user) throws Exception {
		// TODO Auto-generated method stub
		int accNum = customerMapper.getOneCustAccount(user.getAccount());
		
		Boolean flag = false;
		if(accNum == 0){
			System.out.println(user.getAccount());
			Customers customers = Customers.builder()
			.account(user.getAccount())
			.password(user.getPassword())
			.regTime(System.currentTimeMillis())
			.integral(0)
			.build();
			System.out.println(customers.getAccount());
			customerMapper.addCust(customers);
			flag = true;
		}
		return flag;
		
	}

	@Override
	public Boolean changeInfo(Map map) throws Exception {
		customerMapper.changeInfo(map);
		return false;
	}

	@Override
	public Boolean updateIntegral(Integer integral) throws Exception {
		// TODO Auto-generated method stub
		customerMapper.updateIntegral(integral);
		return false;
	}

}
