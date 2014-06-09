package com.namoo.club.entity.community.domain;

public class CommunityManager {
	
	private int communityNo;
	
	private String managerName;
	private String managerId;

	//--------------------------------------------------------------------------
	// constructor
	
	public CommunityManager(int communityNo, String managerId){
		//
		this.communityNo = communityNo;
		this.managerId = managerId;
	}
	
	//--------------------------------------------------------------------------
	// getter/setter
	
	public String getName() {
		//
		return managerName;
	}

	public String getEmail() {
		// 
		return managerId;
	}

	public int getCommunityNo() {
		//
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
}