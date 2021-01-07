package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DB;
import com.cos.blog.domain.board.dto.SaveReqDto;

public class BoardDao {
	public int save(SaveReqDto dto) { //글 등록
		String sql = "INSERT INTO board(userId, title, content, createDate) VALUES(?,?,?, now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.close(conn, pstmt);
		}
		
		
		return -1;
	}
	public List<Board> findAll(){
		String sql = "select * from board order by id DESC";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> boards = new ArrayList<>();
		try {
				pstmt = conn.prepareStatement(sql);	
				rs = pstmt.executeQuery();
				while(rs.next()) { //커서를 한칸씩 밑으로 이동하는 함수
					Board board = Board.builder()
							.id(rs.getInt("id"))
							.userId(rs.getInt("userId"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
							.readCount(rs.getInt("readCount"))
							.createDate(rs.getTimestamp("createDate"))
							.build();
					boards.add(board);
				}
				return boards;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB연결 실패");
		}finally {
			DB.close(conn, pstmt);
		}
		return null;
	}
}
