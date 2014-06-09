package com.namoo.club.entity.community.domain;

public class CommunityMember {

	private int communityNo;
	
	private String memberName;
	private String memberId;

	//--------------------------------------------------------------------------
	// constructor
	
	/**
	 * 
	 * @param rolePerson
	 */
	public CommunityMember(int communityNo, String personId){
		//
		this.communityNo = communityNo;
		this.memberId = personId;
	}
	
	//--------------------------------------------------------------------------
	// getter/setter
	
	public String getName() {
		return memberName;
	}
	
	public String getEmail() {
		return memberId;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
