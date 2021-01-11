package com.ssafy.happyhouse.model.dto;

public class BizCategoryDto {

	private String largeCode;
	private String largeName;
	private String midCode;
	private String midName;
	private String smallCode;
	private String smallName;
	

	public BizCategoryDto() {
	}


	public BizCategoryDto(String largeName, String midName) {
		this.largeName = largeName;
		this.midName = midName;
	}


	public BizCategoryDto(String largeName, String midName, String smallName) {
		this.largeName = largeName;
		this.midName = midName;
		this.smallName = smallName;
	}


	public String getLargeCode() {
		return largeCode;
	}


	public void setLargeCode(String largeCode) {
		this.largeCode = largeCode;
	}


	public String getLargeName() {
		return largeName;
	}


	public void setLargeName(String largeName) {
		this.largeName = largeName;
	}


	public String getMidCode() {
		return midCode;
	}


	public void setMidCode(String midCode) {
		this.midCode = midCode;
	}


	public String getMidName() {
		return midName;
	}


	public void setMidName(String midName) {
		this.midName = midName;
	}


	public String getSmallCode() {
		return smallCode;
	}


	public void setSmallCode(String smallCode) {
		this.smallCode = smallCode;
	}


	public String getSmallName() {
		return smallName;
	}


	public void setSmallName(String smallName) {
		this.smallName = smallName;
	}	

}
