package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.BizInfoDao;
import com.ssafy.happyhouse.model.dto.BizCategoryDto;
import com.ssafy.happyhouse.model.dto.BizInfoDto;

@Service
public class BizInfoServiceImpl implements BizInfoService{
	
	private BizInfoDao bizInfoDao;
	
	@Autowired
	public void setBizInfoDao(BizInfoDao bizInfoDao) {
		this.bizInfoDao = bizInfoDao;
	}	
	
	@Override
	public List<BizCategoryDto> getLargeCategory() {
		return bizInfoDao.getLarge();
	}

	@Override
	public List<BizCategoryDto> getMidCategory(String large_code) {
		return bizInfoDao.getMidInLarge(large_code);
	}

	@Override
	public List<BizCategoryDto> getSmallCategory(String mid_code) {
		return bizInfoDao.getSmallInMid(mid_code);
	}

	@Override
	public List<BizInfoDto> getBizList(String dong_name,String small_code) {
		return bizInfoDao.getBizList(dong_name, small_code);
	}

	@Override
	public List<BizInfoDto> getBizListByDong(String dong_name) {
		return bizInfoDao.getBizListByDong(dong_name);
	}

	@Override
	public List<BizInfoDto> getBizListByCategory(String small_code) {
		return bizInfoDao.getBizListByCategory(small_code);
	}
}
