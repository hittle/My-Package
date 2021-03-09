package com.lzl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(value = "handler")
@NoArgsConstructor
@AllArgsConstructor
public class Staffs {

	@ApiModelProperty(value = "id")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@ApiModelProperty(value="用户名")
	private String name;
	
	@ApiModelProperty(value="账号")
	private String account;
	
	@ApiModelProperty(value="密码")
	private String password;
	
	@ApiModelProperty(value="身份证号")
	private String cardNum;
	
	@ApiModelProperty(value="头像")
	private String photo;
	
	@ApiModelProperty(value="电话")
	private String tel;
	
	@ApiModelProperty(value="邮箱")
	private String email;
	
	@ApiModelProperty(value="身份")
	private String identity;
	
	private String sex;
	
}
