package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.UserDAO;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	private static final String ns = "com.ssafy.happyhouse.model.dao.HouseMapDao";

	@Override
	public boolean login(Map<String, String> map) {
		return sqlSession.getMapper(UserDAO.class).selectUser(map) != null;
	}

	@Override
	public void register(User user) {
		sqlSession.getMapper(UserDAO.class).insert(user);
	}

	@Override
	public User getUser(String id) {
		return sqlSession.getMapper(UserDAO.class).selectUserById(id);
	}

	@Override
	public void updateUser(User user) {
		sqlSession.getMapper(UserDAO.class).update(user);
	}

	@Override
	public void updateUserUseage(Map<String, String> map) {
		sqlSession.getMapper(UserDAO.class).updateUseage(map);
	}

	@Override
	public List<User> getUsers() {
		return sqlSession.getMapper(UserDAO.class).selectUsers();
	}

	@Override
	public List<User> getUserByName(String username) {
		return sqlSession.getMapper(UserDAO.class).selectUserByName(username);
	}

	@Override
	public int getAthority(String id) {
		return sqlSession.getMapper(UserDAO.class).selectUserById(id).getUseage();
	}

	@Override
	public User getOneUserById(String id) {
		return sqlSession.getMapper(UserDAO.class).selectOneUserById(id);
	}

	@Override
	public void insertUserInterest(Map<String, String> map) {
		sqlSession.getMapper(UserDAO.class).insertInterest(map);
	}

	@Override
	public List<String> getUserInterest(String id) {
		return sqlSession.getMapper(UserDAO.class).selectInterest(id);
	}

	@Override
	public void deleteInterest(Map<String, String> map) {
		sqlSession.getMapper(UserDAO.class).deleteInterest(map);
	}

}
