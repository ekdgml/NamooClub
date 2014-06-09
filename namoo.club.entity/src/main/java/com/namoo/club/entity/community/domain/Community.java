package com.namoo.club.entity.community.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.namoo.club.entity.person.domain.SocialPerson;
import com.namoo.club.entity.shared.type.IdNameList;

public class Community {
	
	private int comNo;
	private String name;
	private String description;
	private Date openDate;
	
	private List<IdNameList> categories;
	private List<CommunityMember> members;
	private CommunityManager manager;
	
	//transient
	private String personId;
	private String personName;
	
	//----------------------------------------------------------------
	public Community(String name, String description) {
		//
		this.name = name;
		this.description = description;
		this.categories = new ArrayList<IdNameList>();
	}
	
	public Community(String name, String description, SocialPerson user) {
		//
		this.name = name;
		this.description = description;
		this.categories = new ArrayList<IdNameList>();
		this.personId = user.getId();
		this.personName = user.getName();
	}

	//-------------------------------------------------------------------
	public int getComNo() {
		return comNo;
	}
	
	public void setComNo(int comNo) {
		this.comNo = comNo;
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
	
	public List<IdNameList> getCategories() {
		return categories;
	}
	
	public void setCategories(List<IdNameList> categories) {
		this.categories = categories;
	}
	
	public List<CommunityMember> getMembers() {
		return members;
	}
	
	public void setMembers(List<CommunityMember> members) {
		this.members = members;
	}
	
	public CommunityManager getManager() {
		return manager;
	}
	
	public void setManager(CommunityManager manager) {
		this.manager = manager;
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
	
//-----------------------------------------------------------------------------

	public void addCategory(IdNameList category) {
		//
		if (this.categories == null) {
			this.categories = new ArrayList<IdNameList>();
		}
		this.categories.add(category);
	}
	
}
