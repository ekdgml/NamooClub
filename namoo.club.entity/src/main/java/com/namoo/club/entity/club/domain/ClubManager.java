package com.namoo.club.entity.club.domain;

public class ClubManager  {

	private int clubNo;
	private boolean kingManager;
	
	//transient
	private String managerId;
	private String managerName;
	
	//----------------------------------------------------------------
	
	public ClubManager(int clubNo) {
		//
		this.clubNo = clubNo;
	}
	
	public ClubManager(int clubNo, String managerId) {
		//
		this.clubNo = clubNo;
		this.managerId = managerId;
	}
	
	public ClubManager(int clubNo, String managerId, boolean king) {
		//
		this(clubNo, managerId);
		this.kingManager = king; 
	}
	//--------------------------------------------------
	public String getId() {
		return managerId;
	}
	
	public String getName() {
		return managerName;
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public boolean isKingManager() {
		return kingManager;
	}
	public void setKingManager(boolean kingManager) {
		this.kingManager = kingManager;
	}
	//-------------------------------------------------------------------------
}
