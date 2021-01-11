package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.BizCategoryDto;
import com.ssafy.happyhouse.model.dto.BizInfoDto;
import com.ssafy.happyhouse.util.DBUtil;

@Repository
public class BizInfoDaoImpl implements BizInfoDao {

	private SqlSession sqlSession;
	private static final String ns = "com.ssafy.happyhouse.model.dao.BizInfoDao";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<BizCategoryDto> getLarge() {
		return sqlSession.selectList(ns + ".getLarge");
	}

	@Override
	public List<BizCategoryDto> getMidInLarge(String large_code) {
		return sqlSession.selectList(ns + ".getMidInLarge", large_code);
	}

	@Override
	public List<BizCategoryDto> getSmallInMid(String mid_code) {
		return sqlSession.selectList(ns + ".getSmallInMid", mid_code);
	}

	@Override
	public List<BizInfoDto> getBizList(String dong_name, String small_code) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("dong_name", dong_name);
		map.put("small_code", small_code);
		return sqlSession.selectList(ns + ".getBizList", map);
	}

	@Override
	public List<BizInfoDto> getBizListByDong(String dong_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BizInfoDto> list = new ArrayList<BizInfoDto>();
		System.out.println("쿼리 시작");
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select biz_id, biz_name,branch_name, std_name, dong_name, lng, lat from bizinfo \n");
			sql.append("where dong_name = ?");
			sql.append("ORDER BY dong_name");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dong_name);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BizInfoDto dto = new BizInfoDto();
				dto.setBiz_id(rs.getInt("biz_id"));
				dto.setBiz_name(rs.getString("biz_name"));
				dto.setBranch_name(rs.getString("branch_name"));
				dto.setStd_name(rs.getString("std_name"));
				dto.setDong_name(rs.getString("dong_name"));
				dto.setLng(rs.getString("lng"));
				dto.setLat(rs.getString("lat"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("search 쿼리 성공");
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return list;
	}

	@Override
	public List<BizInfoDto> getBizListByCategory(String small_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BizInfoDto> list = new ArrayList<BizInfoDto>();
		System.out.println("쿼리 시작");
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select biz_id, biz_name,branch_name, std_name, dong_name, lng, lat from bizinfo \n");
			sql.append("where small_code = ?");
			sql.append("ORDER BY small_code");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, small_code);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BizInfoDto dto = new BizInfoDto();
				dto.setBiz_id(rs.getInt("biz_id"));
				dto.setBiz_name(rs.getString("biz_name"));
				dto.setBranch_name(rs.getString("branch_name"));
				dto.setStd_name(rs.getString("std_name"));
				dto.setDong_name(rs.getString("dong_name"));
				dto.setLng(rs.getString("lng"));
				dto.setLat(rs.getString("lat"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("search 쿼리 성공");
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

		return list;
	}

}
