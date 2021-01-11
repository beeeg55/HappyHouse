package com.ssafy.happyhouse.model.dto;

public class NoticeDto {
	private int id;
	private String date;
	private String title;
	private String des;

	
	public NoticeDto(int id, String date, String title, String des) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.des = des;
	}

	public NoticeDto(String title, String des) {
		super();
		this.title = title;
		this.des = des;
	}
	
	public NoticeDto(int id, String des) {
		super();
		this.id = id;
		this.des = des;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	
}
