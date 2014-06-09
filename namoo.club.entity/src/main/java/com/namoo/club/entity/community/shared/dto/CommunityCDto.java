package com.namoo.club.entity.community.shared.dto;

import com.namoo.club.entity.community.domain.Community;
import com.namoo.club.entity.person.domain.SocialPerson;

public class CommunityCDto {
	//
	private int communityNo;
	private String name;
	private String description;
	private String personId;
	
	//----------------------------------------------------------------------------
	//0. default public constructor
	public CommunityCDto() {
		//
	}
	//----------------------------------------------------------------------------
	// 1. public constructor
	public CommunityCDto(Community community) {
		//
		this.communityNo = community.getComNo();
		this.name = community.getName();
		this.description = community.getDescription();
		this.personId = community.getManager().getEmail();
	}
	//----------------------------------------------------------------------------
	// 2. Domain object creation from this DTO
	public Community createCommunity() {
		//
		return new Community(name, description, new SocialPerson(personId));
	}
	//----------------------------------------------------------------------------
	// 3. getter/setter
	
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
}