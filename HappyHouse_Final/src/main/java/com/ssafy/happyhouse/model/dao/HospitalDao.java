package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Hospital;

public interface HospitalDao {
	public List<Hospital> getHospitalInGugun(String gugun);
	public List<Hospital> getHospitalByName(String hospitalName);
}
