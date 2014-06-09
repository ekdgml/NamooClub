package com.namoo.club.entity.club.domain;

import java.util.Date;
import java.util.List;

import com.namoo.club.entity.person.domain.SocialPerson;

public class Club {
	//
	private int categoryNo;
	private int comNo;
	private int clubNo;
	private String name;
	private String description;
	private Date openDate;

	private List<ClubManager> managers;
	private List<ClubMember> members;
	
	//transient
	private String personId;
	private String personName;

	// ---------------------------------------------------------------------------------------------
	public Club(int categoryNo, int comNo, String name, String description) {
		//
		this.categoryNo = categoryNo;
		this.comNo = comNo;
		this.name = name;
		this.description = description;
	}

	public Club(int categoryNo, int comNo, String name, String description, SocialPerson user) {
		//
		this.categoryNo = categoryNo;
		this.comNo = comNo;
		this.name = name;
		this.description = description;
		this.personId = user.getId();
		this.personName = user.getName();
	}

	// ----------------------------------------------------------------------------------------------
	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public List<ClubManager> getManagers() {
		return managers;
	}

	public void setManagers(List<ClubManager> manager) {
		this.managers = manager;
	}

	public List<ClubMember> getMembers() {
		return members;
	}

	public void setMembers(List<ClubMember> member) {
		this.members = member;
	}
	
	public String getPersonId() {
		return personId;
	}
	
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	// --------------------------------------------------------------------------


	public ClubManager findManager(String loginEmail) {
		//
		List<ClubManager> managers = this.getManagers();
		for (ClubManager manager : managers) {
			if (!manager.isKingManager() && manager.getId().equals(loginEmail)) {
				return manager;
			}
		}
		return null;
	}

	public ClubManager getKingManager() {
		//
		if (managers != null) {
			for (ClubManager manager : managers) {
				if (manager.isKingManager()) {
					return manager;
				}
			}
		}
		return null;
	}

}
