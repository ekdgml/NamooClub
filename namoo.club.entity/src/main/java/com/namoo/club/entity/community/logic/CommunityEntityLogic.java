package com.namoo.club.entity.community.logic;

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

import com.namoo.club.entity.community.domain.Community;
import com.namoo.club.entity.community.domain.CommunityManager;
import com.namoo.club.entity.community.facade.CommunityEntity;

@Repository
public class CommunityEntityLogic implements CommunityEntity {
	//
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int create(Community community) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO community(com_nm, com_des, com_date) VALUES (?, ?, sysdate())";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, community.getName());
			pstmt.setString(2, community.getDescription());

			pstmt.executeUpdate();

			rset = pstmt.getGeneratedKeys();
			if (rset.next()) {
				community.setComNo(rset.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null)try {rset.close();} catch (SQLException e) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		return community.getComNo();
	}

	@Override
	public Community retrieve(int communityNo) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Community community = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT com_no, com_nm, com_des, com_date FROM community WHERE com_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, communityNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				String comName = rset.getString("com_nm");
				String description = rset.getString("com_des");
				Date date = rset.getDate("com_date");
				int comNo2 = rset.getInt("com_no");

				community = new Community(comName, description);
				community.setComNo(comNo2);
				community.setOpenDate(date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null)try {rset.close();} catch (SQLException e) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		return community;
	}
	
	@Override
	public List<Community> retrieveAll() {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<Community> communities = new ArrayList<Community>();

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT com_no, com_nm, com_des, com_date FROM community ORDER BY com_no";
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				int comNo = rset.getInt("com_no");
				String comName = rset.getString("com_nm");
				String comDescription = rset.getString("com_des");
				Date date = rset.getDate("com_date");

				Community community = new Community(comName, comDescription);
				community.setComNo(comNo);
				community.setOpenDate(date);
				communities.add(community);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null)try {rset.close();} catch (SQLException e) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		return communities;
	}

	@Override
	public void update(Community community) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE community SET com_nm=?, com_des=?, com_date=sysdate() WHERE com_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, community.getName());
			pstmt.setString(2, community.getDescription());
			pstmt.setInt(3, community.getComNo());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}

	@Override
	public void delete(Community community) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM community WHERE com_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, community.getComNo());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}

	@Override
	public void createManager(CommunityManager manager) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO communitymember(com_no, email, is_manager) VALUES (?, ?, '1')";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, manager.getCommunityNo());
			pstmt.setString(2, manager.getEmail());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}

	@Override
	public CommunityManager retrieveManager(int communityNo) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CommunityManager comManager = null;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT a.com_no, a.email, a.is_manager, b.name FROM communitymember A JOIN user b ON a.email = b.email WHERE com_no = ? AND is_manager ='1'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, communityNo);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				int comNo2 = rset.getInt("com_no");
				String email = rset.getString("email");
				String name = rset.getString("name");
				comManager = new CommunityManager(comNo2, email);
				comManager.setManagerName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {	}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		return comManager;
	}
}
