package com.namoo.club.entity.person.shared.dto;

import com.namoo.club.entity.person.domain.SocialPerson;

public class SocialPersonCDto {
	//
	private String name;
	private String id;
	private String password;
	
	//--------------------------------------------------------------------------------
	//0. default public constructor
	public SocialPersonCDto() {
		//
	}
	//--------------------------------------------------------------------------------
	// 1. public constructor
	public SocialPersonCDto(SocialPerson person) {
		//
		this.name = person.getName();
		this.id = person.getId();
		this.password = person.getPassword();
	}
	//--------------------------------------------------------------------------------
	// 2. Domain object creation from this DTO
	public SocialPerson createPerson() {
		//
		return new SocialPerson(name, id, password);
	}
	//--------------------------------------------------------------------------------
	// 3. getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setEmail(String email) {
		this.id = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
