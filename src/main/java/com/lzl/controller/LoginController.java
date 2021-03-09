package com.lzl.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.objenesis.ObjenesisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lzl.entity.Customers;
import com.lzl.entity.Staffs;
import com.lzl.pojo.ResultInfo;
import com.lzl.pojo.User;
import com.lzl.service.CustomersService;
import com.lzl.service.StaffService;
import com.lzl.service.UserService;
import com.lzl.util.CommonUtil;

import lombok.experimental.PackagePrivate;

@Controller
@CrossOrigin
public class LoginController {

	@Autowired
	private CustomersService customersServiceImpl;
	
	@Resource
	private StaffService staffServiceImpl;
	
	@Resource
	private UserService userServiceImpl;
	
	@Resource
    private DefaultKaptcha captchaProducer;
	

    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";
    
    /**
     * 登录验证码图片
     */
    @RequestMapping(value = {"/loginValidateCode"})
    public void loginValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        CommonUtil.validateCode(request,response,captchaProducer,LOGIN_VALIDATE_CODE);
    }
	
	@PostMapping("/login")
	@ResponseBody
	public ResultInfo Login(User user,HttpServletRequest request)throws Exception{
		ResultInfo resultInfo = new ResultInfo();
		HttpSession session = request.getSession();
		String loginValidateCode = session.getAttribute(LOGIN_VALIDATE_CODE).toString();
		if(loginValidateCode == null) {
			resultInfo = resultInfo.error("验证码过期");		
		}else if(!loginValidateCode.equals(user.getCode())) {
			resultInfo = resultInfo.error("验证码错误");
		}else if(loginValidateCode.equals(user.getCode())){
			Boolean flag = userServiceImpl.loginCheck(user);
			if(flag) {
				if(user.getIdentity().equals("staff")) {
					user = userServiceImpl.getUserIdentity(user);
				}
				session.setAttribute("user", user);
				resultInfo = resultInfo.success("登录成功");
			}else {
				resultInfo = resultInfo.error("账号或密码错误");
			}
		}
		return resultInfo;
	}
	
	@GetMapping("/check")
	@ResponseBody
	public Object Check(HttpSession session)throws Exception{
		User user = (User) session.getAttribute("user");
		Map map = new HashMap<>();
		ResultInfo resultInfo = new ResultInfo();
		if(user == null) {
			resultInfo.setCode(210);
			
		}else {
			resultInfo = resultInfo.success("成功确认");
		}
		return resultInfo;
	}
	
	@PostMapping("/logout")
	@ResponseBody
	public Object Logout(HttpSession session)throws Exception{
		session.invalidate();
		ResultInfo resultInfo = null;
		return resultInfo.success("注销成功");
	}
}
