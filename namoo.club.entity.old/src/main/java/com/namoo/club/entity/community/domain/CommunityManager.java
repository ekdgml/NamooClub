package com.namoo.club.entity.community.domain;

public class CommunityManager {
	//
	private String communityId;
	private String personId;

	//--------------------------------------------------------------------------
	// constructor
	
	public CommunityManager(String communityId, String personId){
		//
		this.communityId = communityId;
		this.personId = personId;
	}
	
	//--------------------------------------------------------------------------
	// getter/setter

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	//--------------------------------------------------------------------------
	// override
	
	@Override
	public String toString() {
		// 
		StringBuilder builder = new StringBuilder();
		builder.append("communityId:" + communityId);
		builder.append(",personId:" + personId);
		
		return builder.toString();
	}
	
}