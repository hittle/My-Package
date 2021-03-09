package com.lzl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lzl.util.Formatter;

import lombok.Data;

@JsonIgnoreProperties(value = "handler")
public class HomeData {

	private String roomNum;
	private String name;
	private String sex;
	private Long date;
	private String dateView;
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date =date;
		this.dateView=Formatter.toLongDateString(date);
	}
	
	public String getDateView() {
		return dateView;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
