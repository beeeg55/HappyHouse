package com.ssafy.happyhouse.util;

public class PageInfo {
	private String url;
	private boolean isForward;
	
	public PageInfo(String url, boolean isForward) {
		this.url = url;
		this.isForward = isForward;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isForward() {
		return isForward;
	}
	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}
	@Override
	public String toString() {
		return "PageInfo [url=" + url + ", isForward=" + isForward + "]";
	}
	

	
}
