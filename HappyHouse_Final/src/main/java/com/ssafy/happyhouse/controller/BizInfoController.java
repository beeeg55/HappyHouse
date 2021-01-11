package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.dto.BizCategoryDto;
import com.ssafy.happyhouse.model.dto.BizInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.dto.UserInterestDto;
import com.ssafy.happyhouse.service.BizInfoService;

@RequestMapping("/biz")
@Controller
public class BizInfoController {

	private BizInfoService bizInfoService;

	@Autowired
	public void setBizInfoService(BizInfoService bizInfoService) {
		this.bizInfoService = bizInfoService;
	}

	@RequestMapping("/main")
	public String bizForm() {
		return "03_interest/interest";
	}

	@ResponseBody
	@RequestMapping("/large")
	public List<BizCategoryDto> getLargeCategory() {
		return bizInfoService.getLargeCategory();
	}

	@ResponseBody
	@RequestMapping("/mid")
	public List<BizCategoryDto> getMidCategory(String large_code) {
		return bizInfoService.getMidCategory(large_code);
	}

	@ResponseBody
	@RequestMapping("/small")
	public List<BizCategoryDto> getSmallCategory(String mid_code) {
		return bizInfoService.getSmallCategory(mid_code);
	}

	@ResponseBody
	@RequestMapping("/bizList")
	public List<BizInfoDto> getBizList(String dong_name, String small_code) {
		return bizInfoService.getBizList(dong_name, small_code);
	}
	
	@PostMapping("/insertInterest")
	public String insertInterest(SidoGugunCodeDto sido) {
		return "/03_interest/interest";
	}
}
