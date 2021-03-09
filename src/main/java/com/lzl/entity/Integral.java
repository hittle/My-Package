package com.lzl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Integral implements Serializable{

	@ApiModelProperty(value = "编号")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@ApiModelProperty(value = "用户id")
	private Integer cid;
	
	@ApiModelProperty(value = "修改时间")
	private Long changeTime;
	
	@ApiModelProperty(value = "数量")
	private Integer number;
}
