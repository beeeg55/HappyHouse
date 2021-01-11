package com.ssafy.happyhouse.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.User;

public interface UserDAO {
	public List<User> selectUserByName(String username);
	public User selectOneUserById(String userid);
	public List<User> selectUsers();
	public User selectUser(Map<String,String> map);
	public void insert(User user);
	public User selectUserById(String id);
	public void update(User user);
	public void updateUseage(Map<String,String> map);
	public void insertInterest(Map<String,String> map);
	/** 현재 사용자의 관심지역들을 list로 반환한다.*/
	public List<String> selectInterest(String id);
	/** 선택 주소와 일치하는 주소를 관심지역 테이블에서 삭제한다.*/
	public void deleteInterest(Map<String,String> map);
}

















