package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.BizCategoryDto;
import com.ssafy.happyhouse.model.dto.BizInfoDto;

public interface BizInfoService {
	List<BizCategoryDto> getLargeCategory();

	List<BizCategoryDto> getMidCategory(String large_code);

	List<BizCategoryDto> getSmallCategory(String mid_code);

	List<BizInfoDto> getBizList(String dong_name, String small_code);

	List<BizInfoDto> getBizListByDong(String dong_name);

	List<BizInfoDto> getBizListByCategory(String small_code);
}
