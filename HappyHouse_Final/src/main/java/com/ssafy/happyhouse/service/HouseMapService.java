package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

public interface HouseMapService {
	
	List<SidoGugunCodeDto> getSido();
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	List<HouseInfoDto> getDongInGugun(String gugun);
	List<HouseInfoDto> getAptInDong(String dong);
	List<HouseInfoDto> getAptByName(String aptName);
	List<HouseDealDto> getAptByPrice(int start, int end, String dong);
	List<HouseDealDto> getAptDetail(String aptName, String dong);
	SidoGugunCodeDto getSidoGugunName(String guguncode);  
}
