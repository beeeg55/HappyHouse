package com.ssafy.happyhouse.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.ScreeningDao;
import com.ssafy.happyhouse.model.dto.ScreeningDto;

@Service
public class ScreeningServiceImpl implements ScreeningService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ScreeningDto> getScreeningInGugun(String gugun) {
		return 	sqlSession.getMapper(ScreeningDao.class).getScreeningInGugun(gugun);
	}

	@Override
	public List<ScreeningDto> getScreeningByName(String screeningName) {
		return sqlSession.getMapper(ScreeningDao.class).getScreeningByName(screeningName);
	}

}
