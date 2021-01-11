package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.NoticeDao;
import com.ssafy.happyhouse.model.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao;

	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public boolean writeArticle(NoticeDto noticeDto) {
		return noticeDao.writeArticle(noticeDto) > 0;
	}

	@Override
	public List<NoticeDto> listArticle() {
		return noticeDao.listArticle();
	}

	@Override
	public NoticeDto getArticle(int id) {
		return noticeDao.getArticle(id);
	}

	@Override
	public boolean modifyArticle(NoticeDto noticeDto) {
		return noticeDao.modifyArticle(noticeDto) > 0;
	}

	@Override
	public boolean deleteArticle(int id) {
		return noticeDao.deleteArticle(id) > 0;
	}
	
}
