package com.namoo.club.entity.person.shared.dto;

import java.sql.Date;

import com.namoo.club.entity.person.domain.SocialPerson;
import com.namoo.club.entity.shared.enumtype.Gender;

public class SocialPersonRDto extends SocialPersonCDto {
	//
	private Date birthDate;
	private Gender gender;
	
	//--------------------------------------------------------------------------
	// 0. default public constructor

	public SocialPersonRDto() {
		//
	}
	
	//--------------------------------------------------------------------------
	// 1. private constructor

	private SocialPersonRDto(SocialPerson person) {
		//
		super(person);
		
		this.birthDate = person.getBirthDate();
		this.gender = person.getGender();
	}
	
    //--------------------------------------------------------------------------
    // 2. DTO creation form a domain object
	
	public static SocialPersonRDto createDto(SocialPerson person) {
		//
		return new SocialPersonRDto(person);
	}

	//--------------------------------------------------------------------------
	// 3. getter only in RDto
	
	public Date getBirthDate() {
		return birthDate;
	}

	public Gender getGender() {
		return gender;
	}
	

}
