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
@RequestMapping("/search")
public class HouseMapController {

	private HouseMapService houseMapService;

	@Autowired
	public void setHouseMapService(HouseMapService houseMapService) {
		this.houseMapService = houseMapService;
	}

	@GetMapping("/main")
	public String searchForm() {
		return "01_search/search";
	}
	
	@ResponseBody
	@GetMapping("/sido")
	public List<SidoGugunCodeDto> selectSido() {
		return houseMapService.getSido();
	}
	
	@ResponseBody
	@GetMapping("/gugun")
	public List<SidoGugunCodeDto> selectGugunInSido(@RequestParam String sido) {
		return houseMapService.getGugunInSido(sido);
	}
	
	@ResponseBody
	@GetMapping("/dong")
	public List<HouseInfoDto> selectDongInGugun(@RequestParam String gugun) {
		return houseMapService.getDongInGugun(gugun);
	}
	
	@ResponseBody
	@GetMapping("apt")
	public List<HouseInfoDto> selectAptInDong(@RequestParam String dong){
		return houseMapService.getAptInDong(dong);
	}
	
	@ResponseBody
	@GetMapping("aptName")
	public List<HouseInfoDto> selectAptByName(@RequestParam String aptName){
		return houseMapService.getAptByName(aptName);
	}
	
	@GetMapping("/price/main")
	public String searchPriceForm() {
		return "07_smartsearch/priceSearch";
	}
	
	
	@ResponseBody
	@GetMapping("detail")
	public List<HouseDealDto> selectAptDetail(@RequestParam("name") String aptName, @RequestParam String dong){
		return houseMapService.getAptDetail(aptName, dong);
	}
	

}