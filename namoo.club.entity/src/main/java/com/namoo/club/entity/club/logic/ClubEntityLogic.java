package com.namoo.club.entity.club.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.entity.club.domain.Club;
import com.namoo.club.entity.club.facade.ClubEntity;

@Repository
public class ClubEntityLogic implements ClubEntity {
	//
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int create(Club club) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO club(com_no, category_no, club_nm, club_des, club_date)"
					+ " VALUES(?, ?, ?, ?, sysdate())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, club.getComNo());
			pstmt.setInt(2, club.getCategoryNo());
			pstmt.setString(3, club.getName());
			pstmt.setString(4, club.getDescription());
			
			pstmt.executeUpdate();
			
			resultSet = pstmt.getGeneratedKeys();
			if(resultSet.next()) {
				club.setClubNo(resultSet.getInt(1));
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			 if ( resultSet != null) try { resultSet.close(); } catch (SQLException e) { }
			 if ( pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			 if ( conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return club.getClubNo();
	}

	@Override
	public Club retrieve(int clubNo) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Club club = null;
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT club_no, com_no, category_no, club_nm, club_des, club_date FROM club WHERE club_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clubNo);
			
			resultSet= pstmt.executeQuery();
			
			if(resultSet.next()) {
				clubNo = resultSet.getInt("club_no");
				int comNo = resultSet.getInt("com_no");
				int categoryNo = resultSet.getInt("category_no");
				String clubName = resultSet.getString("club_nm");
				String clubDes = resultSet.getString("club_des");
				
				club = new Club(categoryNo, comNo, clubName, clubDes);
				club.setClubNo(clubNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 if ( resultSet != null) try { resultSet.close(); } catch (SQLException e) { }
			 if ( pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			 if ( conn != null) try { conn.close(); } catch (SQLException e) { }
		}

		return club;
	}
	
	@Override
	public List<Club> retrieveByCommunityNo(int communityNo) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		List<Club> clubs = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT club_no, category_no, club_nm, club_des, club_date FROM club WHERE com_no=? ORDER BY club_no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, communityNo);
			
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				//
				int clubNo = resultSet.getInt("club_no");
				int categoryNo = resultSet.getInt("category_no");
				String clubNm = resultSet.getString("club_nm");
				String clubDes = resultSet.getString("club_des");
				Date date = resultSet.getDate("club_date");

				Club club = new Club(categoryNo, communityNo, clubNm, clubDes);
				club.setOpenDate(date);
				club.setClubNo(clubNo);
				clubs.add(club);
			}
		} catch(SQLException e) {
			 e.printStackTrace();
		 } finally {
			 if ( resultSet != null) try { resultSet.close(); } catch (SQLException e) { }
			 if ( pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			 if ( conn != null) try { conn.close(); } catch (SQLException e) { }
		 }
		return clubs;
	}

	@Override
	public void update(Club club) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			
			String sql = "UPDATE club SET club_nm =?, club_des = ?, club_date = sysdate() WHERE club_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, club.getName());
			pstmt.setString(2, club.getDescription());
			pstmt.setInt(3, club.getClubNo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if ( conn != null) try { conn.close(); } catch (SQLException e) { }
		}
	}

	@Override
	public void delete(Club club) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			
			String sql = "DELETE FROM club WHERE club_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, club.getClubNo());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try { conn.close(); } catch (SQLException e) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
		}
	}
}
