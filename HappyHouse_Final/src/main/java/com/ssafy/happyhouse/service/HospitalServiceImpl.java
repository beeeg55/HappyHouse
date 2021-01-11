package com.ssafy.happyhouse.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.HospitalDao;
import com.ssafy.happyhouse.model.dto.Hospital;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Hospital> getHospitalInGugun(String gugun) {
		System.out.println(gugun);
		return sqlSession.getMapper(HospitalDao.class).getHospitalInGugun(gugun);
	}

	@Override
	public List<Hospital> getHospitalByName(String hospitalName) {
		return sqlSession.getMapper(HospitalDao.class).getHospitalByName(hospitalName);
	}

}
