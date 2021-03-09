package com.lzl.entity;

import com.lzl.util.Formatter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Log {

	private Integer id;
	private String text;
	private Long times;
	private String timesView;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getTimes() {
		return times;
	}
	public void setTimes(Long times) {
		this.times = times;
		this.timesView=Formatter.toLongDateString(times);
	}
	public String getTimesView() {
		return timesView;
	}
	
}
