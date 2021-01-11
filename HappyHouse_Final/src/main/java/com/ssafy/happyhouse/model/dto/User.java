package com.ssafy.happyhouse.model.dto;

// Model : Data Transfer Object,Value Object,Domain Object
public class User {
	
	private String userid;
	private String userpwd;
	private String username;
	private String email;
	private String interest;
	private String joinDate;
	private int useage; // 관리자:100, 회원:0, 탈퇴회원:-1
	
	public User() {	}
	
	public User(String id, String pwd, String name, String email, String interest, String joinDate) {
		this(id, pwd, name, email, interest);
		this.joinDate = joinDate;
	}
	public User(String id, String pwd, String name, String email, String interest,String joinDate,int useage) {
		this(id, pwd, name, email, interest);
		this.joinDate= joinDate;
		this.useage = useage;
	}

	public User(String id, String pwd, String name, String email, String interest) {
		super();
		this.userid = id;
		this.userpwd = pwd;
		this.username = name;
		this.email = email;
		this.interest = interest;
	}
	

	public String getId() {
		return userid;
	}

	public void setId(String id) {
		this.userid = id;
	}

	public String getPwd() {
		return userpwd;
	}

	public void setPwd(String pwd) {
		this.userpwd = pwd;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public int getUseage() {
		return useage;
	}

	public void setUseage(int useage) {
		this.useage = useage;
	}

	@Override
	public String toString() {
		return "User [id=" + userid + ", pwd=" + userpwd + ", name=" + username + ", email=" + email + ", interest=" + interest
				+ ", joinDate=" + joinDate + ", useage=" + useage + "]";
	}

	

}
