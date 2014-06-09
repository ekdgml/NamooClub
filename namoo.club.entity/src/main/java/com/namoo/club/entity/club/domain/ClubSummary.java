package com.namoo.club.entity.club.domain;

public class ClubSummary {
	//
	private int countOfMembers;
	private int countOfManagers;
	
	//----------------------------------------------------------------------------
	//constructor
	public ClubSummary(int members, int managers) {
		//
		this.countOfManagers = managers;
		this.countOfMembers = members;
	}
	//----------------------------------------------------------------------------
	//getter, setter

	public int getCountOfMembers() {
		return countOfMembers;
	}

	public void setCountOfMembers(int countOfMembers) {
		this.countOfMembers = countOfMembers;
	}

	public int getCountOfManagers() {
		return countOfManagers;
	}

	public void setCountOfManagers(int countOfManagers) {
		this.countOfManagers = countOfManagers;
	}
	
}
