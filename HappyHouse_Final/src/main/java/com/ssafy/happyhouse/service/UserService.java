package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.dto.User;


// Model : Service Logic
public interface UserService {
	
	public boolean login(Map<String,String> map);
	public void register(User user);
	public User getUser(String id);
	public void updateUser(User user);
	public void updateUserUseage(Map<String,String> map);
	public List<User> getUsers();
	public List<User> getUserByName(String username);
	public int getAthority(String id);
	public User getOneUserById(String id);
	public void insertUserInterest(Map<String,String> map);
	public List<String> getUserInterest(String id);
	public void deleteInterest(Map<String,String> map);
}
















