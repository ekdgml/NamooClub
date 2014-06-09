package com.namoo.club.entity.community.logic;

import static com.namoo.club.entity.shared.util.JdbcUtils.closeQuietly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	//--------------------------------------------------------------------------

	@Override
	public String create(Community community) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sb = new StringBuilder(256);
			sb.append("INSERT INTO community (comm_nm, comm_desc, ctgr_list, manager_id, open_dt) ");
			sb.append("VALUES (?, ?, ?, ?, sysdate())");
			
			pstmt = conn.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, community.getName());
			pstmt.setString(2, community.getDescription());
			pstmt.setString(3, community.getCategories().toJson());
			pstmt.setString(4, community.getManager().getPersonId());
			
			pstmt.executeUpdate();
			
			ResultSet genKey = pstmt.getGeneratedKeys();
			if (genKey.next()) {
				community.setId(Integer.toString(genKey.getInt(1)));
			}
			closeQuietly(genKey);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("커뮤니티를 생성하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(pstmt, conn);
		}
		return community.getId();
	}

	@Override
	public Community retrieve(String communityId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Community community = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sb = new StringBuilder(256);
			sb.append("SELECT comm_id, comm_nm, comm_desc, manager_id, open_dt ");
			sb.append("FROM community WHERE comm_id = ?");
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, Integer.parseInt(communityId));
			
			result = pstmt.executeQuery();
			
			if (result.next()) {
				community = mapToCommunity(result);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("커뮤니티정보를 조회하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(result, pstmt, conn);
		}
		return community;
	}

	@Override
	public List<Community> retrieveAll() {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Community> communities = new ArrayList<Community>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT comm_id, comm_nm, comm_desc, manager_id, open_dt FROM community";
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				Community community = mapToCommunity(result);
				communities.add(community);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("커뮤니티 목록을 조회하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(result, pstmt, conn);
		}
		return communities;
	}
	
	@Override
	public List<Community> retrieveByManagerId(String managerId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Community> communities = new ArrayList<Community>();
		try {
			conn = dataSource.getConnection();
			StringBuilder sb = new StringBuilder(256);
			sb.append("SELECT comm_id, comm_nm, comm_desc, manager_id, open_dt ");
			sb.append("FROM community ");
			sb.append("WHERE managerId = ?");
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, managerId);
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				Community community = mapToCommunity(result);
				communities.add(community);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("관리중인 커뮤니티 목록을 조회하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(result, pstmt, conn);
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
			StringBuilder sb = new StringBuilder(256);
			sb.append("UPDATE community SET comm_nm = ?, comm_desc = ?, manager_id = ? ");
			sb.append("WHERE comm_id = ?");
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, community.getName());
			pstmt.setString(2, community.getDescription());
			pstmt.setString(3, community.getManager().getPersonId());
			pstmt.setString(4, community.getId());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("커뮤니티정보를 수정하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(pstmt, conn);
		}
	}

	@Override
	public void delete(Community community) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM community WHERE comm_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(community.getId()));
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("커뮤니티를 삭제하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(pstmt, conn);
		}
	}

	//--------------------------------------------------------------------------

	private Community mapToCommunity(ResultSet result) throws SQLException {
		// 
		String communityId = Integer.toString(result.getInt("comm_id"));
		String communityName = result.getString("comm_nm");
		String description = result.getString("comm_desc");
		String managerId = result.getString("manager_id");
		
		Community community = new Community();
		community.setId(communityId);
		community.setName(communityName);
		community.setDescription(description);
		community.setManager(new CommunityManager(communityId, managerId));
		
		return community;
	}
}
