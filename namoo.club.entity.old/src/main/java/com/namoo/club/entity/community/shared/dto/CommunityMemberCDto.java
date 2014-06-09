package com.namoo.club.entity.community.shared.dto;

import com.namoo.club.entity.community.domain.CommunityMember;

public class CommunityMemberCDto {
	//
	private String communityId;
	private String memberId;

	//--------------------------------------------------------------------------
	// 0. default public constructor

	public CommunityMemberCDto() {
		//
	}
	
	//--------------------------------------------------------------------------
	// 1. public constructor

	protected CommunityMemberCDto(CommunityMember member) {
		//
		this.communityId = member.getCommunityId();
		this.memberId = member.getPersonId();
	}
	
    //--------------------------------------------------------------------------
    // 2. Domain object creation from this DTO
	
	public CommunityMember createCommunityMember() {
		//
		return new CommunityMember(communityId, memberId);
	}

	//--------------------------------------------------------------------------
	// 3. getter/setter
	
	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
