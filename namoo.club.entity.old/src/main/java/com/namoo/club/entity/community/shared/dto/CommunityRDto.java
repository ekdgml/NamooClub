package com.namoo.club.entity.community.shared.dto;

import java.util.Date;

import com.namoo.club.entity.community.domain.Community;

public class CommunityRDto extends CommunityCDto {
	//
	private String id;
	private Date openDate;
	
	//--------------------------------------------------------------------------
	// 0. default public constructor

	public CommunityRDto() {
		//
	}
	
	//--------------------------------------------------------------------------
	// 1. private constructor
	
	private CommunityRDto(Community community) {
		//
		super(community);
		
		this.id = community.getId();
		this.openDate = community.getOpenDate();
	}
	
	
    //--------------------------------------------------------------------------
    // 2. DTO creation form a domain object

	public static CommunityRDto createDto(Community community) {
		//
		return new CommunityRDto(community);
	}

	//--------------------------------------------------------------------------
	// 3. getter only in RDto
	
	public String getId() {
		return id;
	}

	public Date getOpenDate() {
		return openDate;
	}

}
