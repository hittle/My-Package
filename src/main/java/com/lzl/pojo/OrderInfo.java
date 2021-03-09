package com.lzl.pojo;

import com.lzl.util.Formatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderInfo {

	private String 	roomNo;
	private String 	roomType;
	private Double 	totalMoney;
	private Long 	liveDate;
	private String 	liveDateView;
	private Integer	days;
	private Long 	leaveDate;
	private String 	leaveDateView;
	private String 	name;
	private String 	sex;
	private String 	cardNum;
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
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Long getLiveDate() {
		return liveDate;
	}
	public void setLiveDate(Long liveDate) {
		this.liveDate = liveDate;
		this.liveDateView = Formatter.toLongDateString(liveDate);
	}
	public Long getLeaveDate() {
		return this.leaveDate;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public void setLeaveDate(Long leaveDate) {
		this.leaveDate = leaveDate;
		this.leaveDateView = Formatter.toLongDateString(leaveDate);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getLiveDateView() {
		return liveDateView;
	}
	public String getLeaveDateView() {
		return this.leaveDateView;
	}
	
	
	
}
