package com.namoo.club.entity.person.shared.dto;

import com.namoo.club.entity.person.domain.SocialPerson;

public class SocialPersonCDto {
	//
	private String name;
	private String email;
	private String password;
	
	//--------------------------------------------------------------------------
	// 0. default public constructor

	public SocialPersonCDto() {
		//
	}
	
	//--------------------------------------------------------------------------
	// 1. public constructor

	public SocialPersonCDto(SocialPerson person) {
		//
		this.name = person.getName();
		this.email = person.getEmail();
		this.password = person.getPassword();
	}

    //--------------------------------------------------------------------------
    // 2. Domain object creation from this DTO

	public SocialPerson createSocialPerson() {
		//
		return new SocialPerson(name, email, password);
	}
	
    //--------------------------------------------------------------------------
    // 3. getter/setter	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
