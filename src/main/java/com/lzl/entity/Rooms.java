package com.lzl.entity;

import java.io.Serializable;
import java.text.Normalizer.Form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lzl.util.Formatter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@Builder
@JsonIgnoreProperties(value = "handler")
@NoArgsConstructor
@AllArgsConstructor
public class Rooms implements Serializable{

	@ApiModelProperty(value = "房间号")
	private String roomNo;
	
	@ApiModelProperty(value = "房间类型号")
	private Integer roomTypeObj;
	
	@ApiModelProperty(value = "房间图片")
	private String roomPhoto;
	
	@ApiModelProperty(value = "价格")
	private Double roomPrice;
	
	@ApiModelProperty(value = "楼层")
	private String floorNum;
	
	@ApiModelProperty(value = "占用状态")
	private Integer roomState;
	
	@ApiModelProperty(value = "描述")
	private String roomDesc;
	
	@ApiModelProperty(value = "房间类型")
	private String roomType;
	
	private Long createDate;
	
	private String createDateView;
	
	private Long updateDate;
	
	private String updateDateView;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Integer getRoomTypeObj() {
		return roomTypeObj;
	}

	public void setRoomTypeObj(Integer roomTypeObj) {
		this.roomTypeObj = roomTypeObj;
	}

	public String getRoomPhoto() {
		return roomPhoto;
	}

	public void setRoomPhoto(String roomPhoto) {
		this.roomPhoto = roomPhoto;
	}

	public Double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(String floorNum) {
		this.floorNum = floorNum;
	}

	public Integer getRoomState() {
		return roomState;
	}

	public void setRoomState(Integer roomState) {
		this.roomState = roomState;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
		this.createDateView = Formatter.toLongDateString(createDate);
	}

	public Long getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Long updateDate) {
		this.updateDate = updateDate;
		this.updateDateView = Formatter.toLongDateString(updateDate);
	}

	public String getCreateDateView() {
		return createDateView;
	}

	public String getUpdateDateView() {
		return updateDateView;
	}

	@Override
	public String toString() {
		return "Rooms [roomNo=" + roomNo + ", roomTypeObj=" + roomTypeObj + ", roomPhoto=" + roomPhoto + ", roomPrice="
				+ roomPrice + ", floorNum=" + floorNum + ", roomState=" + roomState + ", roomDesc=" + roomDesc
				+ ", roomType=" + roomType + ", createDate=" + createDate + ", createDateView=" + createDateView
				+ ", updateDate=" + updateDate + ", updateDateView=" + updateDateView + "]";
	}
	
	
}
