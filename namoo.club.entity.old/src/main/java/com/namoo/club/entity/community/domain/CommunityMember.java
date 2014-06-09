package com.namoo.club.entity.community.domain;

import java.sql.Date;

import com.namoo.club.entity.shared.enumtype.MembershipState;

public class CommunityMember {
	//
	private String communityId;
	private String personId;
	private MembershipState state;
	private Date startDate;
	private Date endDate;	
	
	// transient
	private String name;
	private String email;

	//--------------------------------------------------------------------------
	// constructor
	
	public CommunityMember() {
		//
	}
	
	public CommunityMember(String communityId, String personId){
		//
		this.communityId = communityId;
		this.personId = personId;
		
		this.state = MembershipState.Requested;
	}

	//--------------------------------------------------------------------------

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

	public MembershipState getState() {
		return state;
	}

	public void setState(MembershipState state) {
		this.state = state;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
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
	
	//--------------------------------------------------------------------------
	// override

	@Override
	public String toString() {
		// 
		StringBuilder builder = new StringBuilder();
		builder.append("communityId:" + communityId);
		builder.append(",personId:" + personId);
		builder.append(",state:" + state);
		builder.append(",startDate:" + startDate);
		builder.append(",endDate:" + endDate);
		
		return builder.toString();
	}
}