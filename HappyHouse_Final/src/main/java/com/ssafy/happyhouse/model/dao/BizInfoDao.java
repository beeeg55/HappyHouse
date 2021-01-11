package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.BizCategoryDto;
import com.ssafy.happyhouse.model.dto.BizInfoDto;

public interface BizInfoDao {
	List<BizCategoryDto> getLarge();

	List<BizCategoryDto> getMidInLarge(String large_code);

	List<BizCategoryDto> getSmallInMid(String mid_code);

	List<BizInfoDto> getBizList(String dong_name, String small_code);

	List<BizInfoDto> getBizListByDong(String dong_name);

	List<BizInfoDto> getBizListByCategory(String small_code);
}
