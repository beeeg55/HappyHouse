package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.service.HouseMapService;

@Controller
@RequestMapping("/smartsearch")
public class SmartSearchController {

	private HouseMapService houseMapService;

	@Autowired
	public void setHouseMapService(HouseMapService houseMapService) {
		this.houseMapService = houseMapService;
	}

	@GetMapping("/main")
	public String searchForm() {
		return "07_smartsearch/priceSearch";
	}
	@ResponseBody
	@GetMapping("/price")
	public List<HouseDealDto> selectAptByPrice(@RequestParam int start, @RequestParam int end, @RequestParam String dong){
		System.out.println(start);
		System.out.println(end);
		return houseMapService.getAptByPrice(start,end,dong);
	}
	

}