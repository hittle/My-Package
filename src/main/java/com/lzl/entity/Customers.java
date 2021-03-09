package com.lzl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lzl.util.CardFormat;
import com.lzl.util.Formatter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Customers implements Serializable{

	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@ApiModelProperty(value = "用户名")
	private String name;
	
	@ApiModelProperty(value = "账号")
	private String account;
	
	@ApiModelProperty(value = "密码")
	private String password;
	
	@ApiModelProperty(value = "身份证号")
	private String cardNum;
	
	@ApiModelProperty(value = "头像")
	private String photo;
	
	@ApiModelProperty(value = "电话")
	private String tel;
	
	@ApiModelProperty(value = "邮箱")
	private String email;
	
	@ApiModelProperty(value = "注册时间")
	private Long regTime;
	
	private String regTimeView;
	
	@ApiModelProperty(value = "性别")
	private String sex;
	
	@ApiModelProperty(value = "积分")
	private Integer integral;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = CardFormat.numberFormat(cardNum) ;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRegTime() {
		return regTime;
	}

	public void setRegTime(Long regTime) {
		this.regTime = regTime;
		this.regTimeView = Formatter.toLongDateString(regTime);
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getRegTimeView() {
		return regTimeView;
	}
	
}
