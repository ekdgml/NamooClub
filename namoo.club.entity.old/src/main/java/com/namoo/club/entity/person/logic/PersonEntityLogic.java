package com.namoo.club.entity.person.logic;

import static com.namoo.club.entity.shared.util.JdbcUtils.closeQuietly;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.namoo.club.entity.person.domain.SocialPerson;
import com.namoo.club.entity.person.facade.PersonEntity;
import com.namoo.club.entity.shared.enumtype.Gender;

@Repository
public class PersonEntityLogic implements PersonEntity {

	@Autowired
	private DataSource dataSource;
	
	//--------------------------------------------------------------------------
	
	@Override
	public void create(SocialPerson person) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO person ");
			sb.append("(email, name, password, birth_date, gender) ");
			sb.append("VALUES (?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, person.getEmail());
			pstmt.setString(2, person.getName());
			pstmt.setString(3, person.getPassword());
			pstmt.setDate(4, person.getBirthDate());
			
			if (person.getGender() != null) {
				pstmt.setString(5, person.getGender().code());
			} else {
				pstmt.setString(5, null);
			}
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자를 추가하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(pstmt, conn);
		}
	}

	@Override
	public SocialPerson retrieve(String personId) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		SocialPerson person = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT email, name, password, birth_date, gender ");
			sb.append("FROM person WHERE email = ?");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, personId);
			
			result = pstmt.executeQuery();
			
			if (result.next()) {
				person = mapToSocialPerson(result);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자 목록을 조회하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(result, pstmt, conn);
		}
		return person;
	}

	@Override
	public void update(SocialPerson person) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE person ");
			sb.append("SET name = ?, password = ?, birth_date = ?, gender = ? ");
			sb.append("WHERE email = ?");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getPassword());
			pstmt.setDate(3, person.getBirthDate());
			if (person.getGender() != null) {
				pstmt.setString(4, person.getGender().code());
			}
			pstmt.setString(5, person.getEmail());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자를 수정하는 중 오류가 발생하였습니다.", e);
		} finally {
			closeQuietly(pstmt, conn);
		}	
	}

	@Override
	public void delete(SocialPerson person) {
		//
		// TODO:

	}
	
	//--------------------------------------------------------------------------
	
	private SocialPerson mapToSocialPerson(ResultSet result) throws SQLException {
		// 
		String email = result.getString("email");
		String name = result.getString("name");
		String password = result.getString("password");
		Date birthDate = result.getDate("birth_date");
		String gender = result.getString("gender");
		
		SocialPerson person = new SocialPerson(name, email, password);
		person.setBirthDate(birthDate);
		if (!StringUtils.isEmpty(gender)) {
			person.setGender(Gender.findBy(gender));
		}
		return person;
	}	
}
