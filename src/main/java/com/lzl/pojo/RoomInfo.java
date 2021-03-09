package com.lzl.pojo;

import java.text.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lzl.util.Formatter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@JsonIgnoreProperties(value = "handler")
@NoArgsConstructor
@AllArgsConstructor
public class RoomInfo {

	private Integer id;
	private String roomNo;
	private String roomType;
	private Double roomPrice;
	private Integer roomState;
	private String name;
	private String cardNum;
	private Double totalmoney;
	private Double orderMemo;
	private Long liveDate;
	private String liveDateView;
	private Integer days;
	private Long leaveDate;
	private String leaveDateView;
	private Long orderTerm;
	private String orderTermView;
	
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Integer getRoomState() {
		return roomState;
	}
	public void setRoomState(Integer roomState) {
		this.roomState = roomState;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Double getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}
	
	public Long getLiveDate() {
		return liveDate;
	}
	public void setLiveDate(Long liveDate) {
		this.liveDate = liveDate;
		this.liveDateView =Formatter.toLongDateString(liveDate);
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Long getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Long leaveDate) throws ParseException {
		this.leaveDate = leaveDate;
		String livedate = Formatter.toShortDateString(this.liveDate);
		leaveDate = Formatter.dateToStamp(livedate)+(this.days*24+12)*3600*1000;
		this.leaveDateView = Formatter.toLongDateString(leaveDate);
	}
	public String getLiveDateView() {
		return liveDateView;
	}
	public String getLeaveDateView() {
		return leaveDateView;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getOrderMemo() {
		return orderMemo;
	}
	public void setOrderMemo(Double orderMemo) {
		this.orderMemo = orderMemo;
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
