package com.lzl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzl.entity.Staffs;
import com.lzl.mapper.StaffMapper;
import com.lzl.pojo.User;
import com.lzl.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffMapper staffMapper;

	@Override
	public List<Staffs> getAllStaffs() throws Exception {
		// TODO Auto-generated method stub
		return staffMapper.getAllStaffs();
	}
	@Override
	public Staffs getOneStaff(User user) throws Exception {
		// TODO Auto-generated method stub
		return staffMapper.getOneStaff(user);
	}

	@Override
	public Boolean loginCheck(User user) throws Exception {
		// TODO Auto-generated method stub
		return staffMapper.loginCheck(user)==1;
	}

	@Override
	public void changeStaffInfo(Map staffs) throws Exception {
		// TODO Auto-generated method stub
		staffMapper.changeStaffInfo(staffs);
	}

	@Override
	public Boolean addStaff(User user) throws Exception {
		// TODO Auto-generated method stub
		int accNum = staffMapper.getOneStaffAccount(user.getAccount());
		Boolean flag = false;
		if(accNum != 1) {
			flag =false;
		}else {
			Staffs staffs = Staffs.builder()
							.account(user.getAccount())
							.password(user.getPassword())
							.build();
			staffMapper.addStaff(staffs);
			flag = true;
		}
		return flag;
		
	}

	@Override
	public void delStaff(Integer id) throws Exception {
		// TODO Auto-generated method stub
		staffMapper.delStaff(id);
	}
	
	
}
