package com.namoo.club.entity.community.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.entity.community.domain.CommunityMember;
import com.namoo.club.entity.community.facade.CommunityMemberEntity;

@Repository
public class CommunityMemberEntityLogic implements CommunityMemberEntity {
	//
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void create(CommunityMember member) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO communitymember(com_no, email, is_manager) VALUES (?, ?, '2')";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, member.getCommunityNo());
			pstmt.setString(2, member.getEmail());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null)try {rset.close();} catch (SQLException e) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}

	@Override
	public CommunityMember retrieve(int communityNo, String personId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	    CommunityMember comMember = null;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT a.com_no, a.email, b.name FROM communitymember A JOIN user b ON a.email = b.email WHERE a.com_no = ? AND a.email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, communityNo);
			pstmt.setString(2, personId);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				int _comNo = rset.getInt("com_no");
				String _email = rset.getString("email");
				String name = rset.getString("name");
				comMember = new CommunityMember(_comNo, _email);
				comMember.setMemberName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {	}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		return comMember;
	}

	@Override
	public void delete(CommunityMember member) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM communitymember WHERE com_no = ? AND is_manager = '2' AND email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getCommunityNo());
			pstmt.setString(2, member.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {	}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}

	@Override
	public List<CommunityMember> retrieveByCommnityNo(int communityNo) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	    List<CommunityMember> members = new ArrayList<CommunityMember>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT a.com_no, a.email, a.is_manager, b.name " +
						"FROM communitymember A JOIN user b ON a.email = b.email WHERE com_no = ? ORDER BY com_no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, communityNo);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				String name = rset.getString("name");
				String email = rset.getString("email");
				
				CommunityMember comMember = new CommunityMember(communityNo, email);
				comMember.setMemberName(name);
				members.add(comMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (SQLException e) {	}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
		return members;
	}

}
