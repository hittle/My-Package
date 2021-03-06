package com.lzl.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lzl.util.CommonUtil;
import com.lzl.util.QRCodeUtil;

@Controller
@CrossOrigin
public class MainController {
 
    @Resource
    private DefaultKaptcha captchaProducer;
 
    @RequestMapping(value = {"/"})
    public String index() {
        return "/index";
    }
 
    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";
    /**
     * 登录验证码图片
     */
    @RequestMapping(value = {"/loginCode"})
    public void loginValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
//        CommonUtil.validateCode(request,response,captchaProducer,LOGIN_VALIDATE_CODE);
        QRCodeUtil.encode("192.168.1.107:81", "C:\\Users\\Administrator\\Desktop\\img\\test1.jpg", response.getOutputStream(), true);
    }
 
    /**
     * 检查验证码是否正确
     */
    @RequestMapping("/checkLoginValidateCode")
    @ResponseBody
    public HashMap checkLoginValidateCode(HttpServletRequest request,@RequestParam("validateCode")String validateCode) {
        String loginValidateCode = request.getSession().getAttribute(LOGIN_VALIDATE_CODE).toString();
        HashMap<String,Object> map = new HashMap<String,Object>();
        if(loginValidateCode == null){
            map.put("status",null);//验证码过期
        }else if(loginValidateCode.equals(validateCode)){
            map.put("status",true);//验证码正确
        }else if(!loginValidateCode.equals(validateCode)){
            map.put("status",false);//验证码不正确
        }
        map.put("code",200);
        return map;
    }
}