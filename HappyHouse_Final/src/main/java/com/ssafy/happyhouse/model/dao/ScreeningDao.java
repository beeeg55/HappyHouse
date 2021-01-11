package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.ScreeningDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

public interface ScreeningDao {
	public List<ScreeningDto> getScreeningInGugun(String gugun);
	public List<ScreeningDto> getScreeningByName(String screeningName);
}
