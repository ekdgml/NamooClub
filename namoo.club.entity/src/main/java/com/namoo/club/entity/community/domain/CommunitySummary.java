package com.namoo.club.entity.community.domain;

public class CommunitySummary {
	//
	private int countOfMembers;
	private int countOfClubs;
	
	//--------------------------------------------------------------------
	//constructor
	public CommunitySummary(int members, int clubs) {
		//
		this.countOfMembers = members;
		this.countOfClubs = clubs;
	}
	//--------------------------------------------------------------------
	//getter, setter

	public int getCountOfMembers() {
		return countOfMembers;
	}

	public void setCountOfMembers(int countOfMembers) {
		this.countOfMembers = countOfMembers;
	}

	public int getCountOfClubs() {
		return countOfClubs;
	}

	public void setCountOfClubs(int countOfClubs) {
		this.countOfClubs = countOfClubs;
	}
	
}
