package com.namoo.club.entity.person.shared.dto;

import com.namoo.club.entity.person.domain.SocialPerson;

public class SocialPersonRDto extends SocialPersonCDto{
	//
	//--------------------------------------------------------------
	//0. default public constructor
	public SocialPersonRDto() {
		//
	}
	//--------------------------------------------------------------
	// 1. private constructor
	private SocialPersonRDto(SocialPerson person) {
		//
		super(person);
	}
	//--------------------------------------------------------------
	// 2. DTO creation form a domain object
	public static SocialPersonRDto createDto(SocialPerson person) {
		//
		return new SocialPersonRDto(person);
	}
	//--------------------------------------------------------------
	// 3. getter only in RDto
}
