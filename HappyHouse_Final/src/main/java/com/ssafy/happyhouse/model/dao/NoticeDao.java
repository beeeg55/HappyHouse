package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeDao {
	int writeArticle(NoticeDto noticeDto);

	List<NoticeDto> listArticle();

	NoticeDto getArticle(int id);

	int modifyArticle(NoticeDto noticeDto);

	int deleteArticle(int id);
}
