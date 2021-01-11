package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.ScreeningDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

public interface ScreeningService {
	List<ScreeningDto> getScreeningInGugun(String gugun);
	List<ScreeningDto> getScreeningByName(String hospitalName);
}