package com.ssafy.happyhouse.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	private SqlSession sqlSession;
	private static final String ns = "com.ssafy.happyhouse.model.dao.NoticeDao";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int writeArticle(NoticeDto noticeDto) {
		return sqlSession.insert(ns + ".writeArticle", noticeDto);
	}

	@Override
	public List<NoticeDto> listArticle() {
		return sqlSession.selectList(ns + ".listArticle");
	}

	@Override
	public NoticeDto getArticle(int id) {
		return sqlSession.selectOne(ns + ".getArticle", id);
	}

	@Override
	public int modifyArticle(NoticeDto noticeDto) {
		return sqlSession.update(ns + ".modifyArticle", noticeDto);
	}

	@Override
	public int deleteArticle(int id) {
		return sqlSession.delete(ns + ".deleteArticle", id);
	}

}
