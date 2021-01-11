package com.ssafy.happyhouse.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.dto.Hospital;
import com.ssafy.happyhouse.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping("/main")
	public String hopitalMain() {
		return "02_surround/surround";
	}
	
	@GetMapping(value="/gugun/{gugun}", headers = { "Content-type=application/json" })
	@ResponseBody
	public List<Hospital> hospitalsByGugun(@PathVariable("gugun") String gugun){
		return hospitalService.getHospitalInGugun(gugun);
	}
	
	@GetMapping(value="/sido/{sido}", headers = { "Content-type=application/json" })
	@ResponseBody
	public List<Hospital> getHospitalByName(@PathVariable("sido") String gugun){
		return hospitalService.getHospitalInGugun(gugun);
	}
}
