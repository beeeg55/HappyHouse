package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.dto.ScreeningDto;
import com.ssafy.happyhouse.service.ScreeningService;

@Controller
@RequestMapping("/screening")
public class ScreeningController {

	@Autowired
	ScreeningService screeningService;
	
	@GetMapping(value="/gugun/{gugun}", headers = { "Content-type=application/json" })
	@ResponseBody
	public List<ScreeningDto> screeningsByGugun(@PathVariable("gugun") String gugun){
		return screeningService.getScreeningInGugun(gugun);
	}
}
