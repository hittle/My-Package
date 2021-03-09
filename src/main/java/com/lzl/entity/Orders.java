package com.lzl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lzl.util.Formatter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@JsonIgnoreProperties(value = "handler")
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@ApiModelProperty(value = "订单号")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@ApiModelProperty(value="预订房间")
	private String roomObj;
	
	@ApiModelProperty(value="客户类型")
	private Integer userObj;
	
	@ApiModelProperty(value="入住日期")
	private Long liveDate;
	
	private String liveDateView;
	
	@ApiModelProperty(value="离开日期")
	private Long leaveDate;
	
	private String leaveDateView;
	
	@ApiModelProperty(value="入住天数")
	private Integer days;
	
	@ApiModelProperty(value="总价格")
	private Double totalMoney;
	
	@ApiModelProperty(value="预订日期")
	private Long orderDate;
	
	@ApiModelProperty(value="订单状态")
	private String orderState;
	
	@ApiModelProperty(value="订单备注")
	private Double orderMemo;
	
	@ApiModelProperty(value = "到期时间")
	private Long orderTerm;

	private String orderTermView;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomObj() {
		return roomObj;
	}

	public void setRoomObj(String roomObj) {
		this.roomObj = roomObj;
	}

	public Integer getUserObj() {
		return userObj;
	}

	public void setUserObj(Integer userObj) {
		this.userObj = userObj;
	}

	public Long getLiveDate() {
		return liveDate;
	}

	public void setLiveDate(Long liveDate) {
		this.liveDate = liveDate;
		this.liveDateView = Formatter.toLongDateString(liveDate);
	}

	public Long getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Long leaveDate) {
		this.leaveDate = leaveDate;
		this.leaveDateView = Formatter.toLongDateString(leaveDate);
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Long getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Long orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Double getOrderMemo() {
		return orderMemo;
	}

	public void setOrderMemo(Double orderMemo) {
		this.orderMemo = orderMemo;
	}



	public String getLiveDateView() {
		return liveDateView;
	}

	public String getLeaveDateView() {
		return leaveDateView;
	}

	public Long getOrderTerm() {
		return orderTerm;
	}

	public void setOrderTerm(Long orderTerm) {
		this.orderTerm = orderTerm;
		this.orderTermView = Formatter.toLongDateString(orderTerm);
	}

	public String getOrderTermView() {
		return orderTermView;
	}
	
	
}
