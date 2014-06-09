package com.namoo.club.entity.community.shared.dto;

import java.util.ArrayList;
import java.util.List;

import com.namoo.club.entity.community.domain.CommunityMember;

public class CommunityMemberRDto extends CommunityMemberCDto {
	//
	private String name;
	private String email;
	
	//--------------------------------------------------------------------------
	// 1. private constructor
	
	private CommunityMemberRDto(CommunityMember member) {
		//
		super(member);
		
		this.name = member.getName();
		this.email = member.getEmail();
	}
	
    //--------------------------------------------------------------------------
    // 2. DTO creation form a domain object

	public static CommunityMemberRDto createDto(CommunityMember member) {
		//
		return new CommunityMemberRDto(member);
	}
	
	public static List<CommunityMemberRDto> createDtos(List<CommunityMember> members) {
		//
		List<CommunityMemberRDto> dtos = new ArrayList<CommunityMemberRDto>();
		for (CommunityMember member : members) {
			//
			dtos.add(new CommunityMemberRDto(member));
		}
		return dtos;
	}

	//--------------------------------------------------------------------------
	// 3. getter only in RDto

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

}
