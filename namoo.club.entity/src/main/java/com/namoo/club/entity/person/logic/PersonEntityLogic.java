package com.namoo.club.entity.person.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.entity.person.domain.SocialPerson;
import com.namoo.club.entity.person.facade.PersonEntity;

@Repository
public class PersonEntityLogic implements PersonEntity {
	//
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void create(SocialPerson person) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO user(email, name, password) VALUES(?, ?,  ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, person.getId());
			pstmt.setString(2, person.getName());
			pstmt.setString(3, person.getPassword());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) { }
			if (conn != null) try { conn.close(); } catch (SQLException e) { }
		}
	}

	@Override
	public SocialPerson retrieve(String email) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SocialPerson user = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT email, name, password FROM user WHERE email=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();

			if (rset.next()) {
				String name = rset.getString("name");
				String email2 = rset.getString("email");
				String password = rset.getString("password");
				user = new SocialPerson(name, email2, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) try { rset.close(); } catch (SQLException e) { }
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) { }
			if (conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return user;
	}

	@Override
	public void update(SocialPerson person) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE user SET password=? WHERE email=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, person.getPassword());
			pstmt.setString(2, person.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) { }
			if (conn != null) try { conn.close(); } catch (SQLException e) { }
		}
	}

	@Override
	public void delete(SocialPerson person) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM user WHERE email=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, person.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) { }
			if (conn != null) try { conn.close(); } catch (SQLException e) { }
		}
	}

	@Override
	public List<SocialPerson> retrieveAll() {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SocialPerson> users = new ArrayList<SocialPerson>();

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT email, name, password FROM user ORDER BY email";
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				String email = rset.getString("email");
				String name = rset.getString("name");
				String password = rset.getString("password");

				SocialPerson user = new SocialPerson(name, email, password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) try { rset.close(); } catch (SQLException e) { }
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) { }
			if (conn != null) try { conn.close(); } catch (SQLException e) { }
		}
		return users;
	}

}
