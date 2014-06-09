package com.namoo.club.entity.person.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.club.entity.person.domain.SocialPerson;
import com.namoo.club.entity.shared.DbCommonTestCase;
import com.namoo.club.entity.shared.enumtype.Gender;

public class PersonEntityTest extends DbCommonTestCase {
	//
	private static final String DATASET_XML = "PersonEntityTest_dataset.xml";

	@Autowired
	private PersonEntity personEntity;
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	// 추가테스트용 이메일 주소
	String email = "newperson@testcase.com";
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testRetrieve() {
		//
		// execution
		SocialPerson person = personEntity.retrieve("hyunohkim@testcase.com");
		
		// assertion
		assertEquals("김현오", person.getName());
		assertEquals("hyunohkim@testcase.com", person.getEmail());
		assertEquals(Gender.Male, person.getGender());
		assertEquals("1234", person.getPassword());
	}
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDelete() {
		//
		String email = "hyunohkim@testcase.com";
		// execution
		personEntity.delete(new SocialPerson(email));

		// assertion
		assertNull(personEntity.retrieve(email));
	}
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdate() {
		//
		String email = "hyunohkim@testcase.com";
		SocialPerson person = personEntity.retrieve(email);
		person.setName("김기사");
		person.setPassword("qwer");
		
		// execution
		personEntity.update(person);
		
		// assertion
		person = personEntity.retrieve(email);
		assertEquals("김기사", person.getName());
		assertEquals("qwer", person.getPassword());
	}
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreate() {
		//
		String name = "테스트";
		String password = "asdf";
		Gender gender = Gender.Male;
		Date birthDate = Date.valueOf("1982-10-10");
		
		SocialPerson person = new SocialPerson(name, email, password);
		person.setGender(gender);
		person.setBirthDate(birthDate);
		
		// execution
		personEntity.create(person);
		
		// assertion
		person = personEntity.retrieve(email);
		assertEquals(email, person.getEmail());
		assertEquals(password, person.getPassword());
		assertEquals(gender, person.getGender());
		assertEquals(birthDate, person.getBirthDate());
	}
}
