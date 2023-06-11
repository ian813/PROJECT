package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Review;
import com.ssafy.util.DBUtil;

//싱글턴으로 만들어보자
public class MainDaoImpl implements MainDao {

	// DBUtil 가져와야함.
	private final DBUtil util = DBUtil.getInstance();

	private static MainDaoImpl instance = new MainDaoImpl();

	private MainDaoImpl() {
	}

	public static MainDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Review> selectAllReviews() {
		String sql = "SELECT * FROM review";
		List<Review> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 2. 데이터베이스를 연결을 해야됨
		try {
			conn = util.getConnection();

			pstmt = conn.prepareStatement(sql);
			// 전체 값을 가져오는 SQL문 작성

 			rs = pstmt.executeQuery();

			// DB에서 인덱스는 1부터시작이에요
			while (rs.next()) {
				Review review = new Review();
				review.setNum(rs.getInt("num")); // rs.getInt(1); 같은말
				review.setId(rs.getString("id"));
				review.setNickName(rs.getString("nickName"));
				review.setTitle(rs.getString("title"));
				review.setContent(rs.getString("content"));

				list.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 박태흠 정답~~ 스코프 이
			util.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Review selectOne(int id) throws SQLException {
		String sql = "SELECT * FROM review WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Review review = new Review();
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				review.setNum(rs.getInt(1)); // rs.getInt(1); 같은말
				review.setId(rs.getString(2));
				review.setNickName(rs.getString(3));
				review.setTitle(rs.getString(4));
				review.setContent(rs.getString(5));
			}

		} finally {
			util.close(conn, pstmt, rs);
		}

		return review;
	}

	@Override
	public void insertReview(Review review) throws SQLException {
		// 굉장히 불편하다.
//		String sql = "INSERT INTO board (title, writer, content) VALUES ('"+board.getTitle()+"','....";	
		String sql = "INSERT INTO review (num, nickName, title, content) VALUES (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = util.getConnection();
		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, review.getNum());
		pstmt.setString(2, review.getNickName());
		pstmt.setString(3, review.getTitle());
		pstmt.setString(4, review.getContent());
		
		pstmt.executeUpdate();

		util.close(conn, pstmt);
	}

	@Override
	public void deleteReview(int id) throws SQLException {
		String sql = "DELETE FROM review WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 데이터가 지워졌습니다.");
		} finally {
			util.close(conn, pstmt);
		}
	}
	
	@Override
 	public int reviewCount() throws SQLException {
 		String sql = "SELECT count(*) FROM users";

 		Connection conn = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;

 		int result = 0;

 		try {
 			conn = util.getConnection();
 			pstmt = conn.prepareStatement(sql);
 			rs = pstmt.executeQuery();

 			if (rs.next()) {
 				result = rs.getInt(1);
 			}

			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		} finally {
 			util.close(conn, pstmt, rs);
 		}
		
 		return result;
 	}
	
	@Override
	public void updateReview(Review review) throws SQLException {
		String sql = "UDDATE review SET title=?, content=? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContent());
			
			pstmt.executeUpdate();
		}finally {
			util.close(conn, pstmt);
		}
	}

}