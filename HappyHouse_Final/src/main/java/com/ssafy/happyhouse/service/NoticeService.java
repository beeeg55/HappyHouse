package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeService {
	boolean writeArticle(NoticeDto noticeDto);

	List<NoticeDto> listArticle();

	NoticeDto getArticle(int id);

	boolean modifyArticle(NoticeDto noticeDto);

	boolean deleteArticle(int id);
}
