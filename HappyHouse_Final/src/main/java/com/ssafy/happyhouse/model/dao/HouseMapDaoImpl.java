package com.ssafy.happyhouse.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

@Repository
public class HouseMapDaoImpl implements HouseMapDao {

	private SqlSession sqlSession;
	private static final String ns = "com.ssafy.happyhouse.model.dao.HouseMapDao";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<SidoGugunCodeDto> getSido() {
		return sqlSession.selectList(ns + ".getSido");
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) {
		return sqlSession.selectList(ns + ".getGugunInSido", sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) {
		return sqlSession.selectList(ns + ".getDongInGugun", gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) {
		return sqlSession.selectList(ns + ".getAptInDong", dong);
	}

	@Override
	public List<HouseInfoDto> getAptByName(String name) {
		return sqlSession.selectList(ns + ".getAptByName", '%' + name + '%');
	}

	@Override
	public List<HouseDealDto> getAptDetail(String aptName, String dong) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("aptName", aptName);
		map.put("dong", dong);
		return sqlSession.selectList(ns + ".getAptDetail", map);
	}

	@Override
	public SidoGugunCodeDto getSidoGugunName(String guguncode) {
		return sqlSession.selectOne(ns + ".getSidoGugunName", '%' + guguncode + '%');
	}

	@Override
	public List<HouseDealDto> getAptByDong(String dong) {
		return sqlSession.selectList(ns + ".getAptByDong",'%' + dong + '%');
	}
}
