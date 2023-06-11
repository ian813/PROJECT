package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.Review;

public interface MainDao {
	//운동 영상 리뷰 목록
	public List<Review> selectAllReviews();
	
	//ID에 해당하는 게시글 하나 가져오기
	public Review selectOne(int id) throws SQLException;
	
	//리뷰 등록
	public void insertReview(Review review) throws SQLException;
	
	//리뷰 삭제 
	public void deleteReview(int id) throws SQLException;
	
	//리뷰 수정
	public void updateReview(Review review) throws SQLException;
	
	//리뷰 개수
	int reviewCount() throws SQLException;
	
	
}
