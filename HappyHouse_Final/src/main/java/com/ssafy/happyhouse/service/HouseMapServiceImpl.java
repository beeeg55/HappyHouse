package com.ssafy.happyhouse.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.HouseMapDao;
import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

@Service
public class HouseMapServiceImpl implements HouseMapService {

	private HouseMapDao houseMapDao;

	@Autowired
	public void setHouseMapDao(HouseMapDao houseMapDao) {
		this.houseMapDao = houseMapDao;
	}

	@Override
	public List<SidoGugunCodeDto> getSido() {
		return houseMapDao.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) {
		return houseMapDao.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) {
		return houseMapDao.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) {
		return houseMapDao.getAptInDong(dong);
	}

	@Override
	public List<HouseInfoDto> getAptByName(String aptName) {
		return houseMapDao.getAptByName(aptName);
	}

	@Override
	public List<HouseDealDto> getAptDetail(String aptName, String dong) {
		return houseMapDao.getAptDetail(aptName, dong);
	}

	@Override
	public SidoGugunCodeDto getSidoGugunName(String guguncode) {
		return houseMapDao.getSidoGugunName(guguncode);
	}

	@Override
	public List<HouseDealDto> getAptByPrice(int start, int end, String dong) {
		List<HouseDealDto> allList =  houseMapDao.getAptByDong(dong);
		List<HouseDealDto> priceList = new LinkedList<HouseDealDto>();
		Iterator<HouseDealDto> iter = allList.iterator();
		while(iter.hasNext()) {
			HouseDealDto house = iter.next();
			int price = Integer.parseInt(house.getDealAmount().replace(",", "").trim());
			System.out.println(price);
			if(start<=price&&price<=end) {
				priceList.add(house);
			}
			if(price>end) {
				break;
			}
		}
		return priceList;
	}

}
