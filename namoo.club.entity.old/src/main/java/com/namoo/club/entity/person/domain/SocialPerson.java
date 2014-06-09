package com.namoo.club.entity.person.domain;

import java.sql.Date;

import com.namoo.club.entity.shared.enumtype.Gender;
import com.namoo.club.entity.shared.type.NameValueList;

public class SocialPerson {
	//
	private String name;
	private String email;
	private String password;
	
	private Date birthDate;
	private Gender gender;
	
	//--------------------------------------------------------------------------
	// constructors
	
	public SocialPerson(){
		//
	}

	public SocialPerson(String email) {
		//
		this.email = email;
	}
	
	public SocialPerson(String name, String email, String password){
		//
		this.name = name;
		this.email = email;
		this.password = password;
	}

	//--------------------------------------------------------------------------
	// methods
	
	public void setValues(NameValueList pairs) {
		//
		if (pairs.hasName("birthDate")) {
			this.birthDate = Date.valueOf(pairs.getValue("birthDate"));
		} 
		
		if (pairs.hasName("gender")) {
			this.gender = Gender.findBy(pairs.getValue("gender"));
		}
	}
	
	//--------------------------------------------------------------------------
	// getter/setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}