package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

public interface HouseMapDao {

	List<SidoGugunCodeDto> getSido();
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	List<HouseInfoDto> getDongInGugun(String gugun);
	List<HouseInfoDto> getAptInDong(String dong);
	List<HouseInfoDto> getAptByName(String name);
	List<HouseDealDto> getAptDetail(String aptName, String dong);
	List<HouseDealDto> getAptByDong(String dong);
	SidoGugunCodeDto getSidoGugunName(String guguncode);
}
