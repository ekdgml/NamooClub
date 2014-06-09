package com.namoo.club.entity.club.domain;

public class ClubMember {
	
	private int clubNo;
	private char type;
	
	//transient
	private String memberId;
	private String memberName;
	
	//--------------------------------------------------------------------
	
	public ClubMember(int clubNo) {
		//
		this.clubNo = clubNo;
	}
	
	public ClubMember(int clubNo, String memberId) {
		//
		this.clubNo = clubNo;
		this.memberId = memberId;
	}
	//---------------------------------------------------------------------------
	
	public String getName() {
		return memberName;
	}
	
	public String getId() {
		return memberId;
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	
	
}
