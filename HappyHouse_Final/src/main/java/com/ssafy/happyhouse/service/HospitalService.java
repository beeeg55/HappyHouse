package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Hospital;

public interface HospitalService {
	public List<Hospital> getHospitalInGugun(String gugun);
	public List<Hospital> getHospitalByName(String hospitalName);
}
