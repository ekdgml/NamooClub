package com.namoo.club.entity.community.shared.dto;

import com.namoo.club.entity.community.domain.Community;


public class CommunityCDto {
	//
	private String name;
	private String description;
	
	// 커뮤니티를 개설하는 주민의 personId
	private String managerId;
	
	//--------------------------------------------------------------------------
	// 0. default public constructor

	public CommunityCDto() {
		//
	}
	
	//--------------------------------------------------------------------------
	// 1. public constructor

	public CommunityCDto(Community community) {
		//
		this.name = community.getName();
		this.description = community.getDescription();
		this.managerId = community.getManager().getPersonId();
	}

    //--------------------------------------------------------------------------
    // 2. Domain object creation from this DTO
	
	public Community createCommunity() {
		//
		return new Community(name, description, managerId);
	}
	
    //--------------------------------------------------------------------------
    // 3. getter/setter

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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
}
