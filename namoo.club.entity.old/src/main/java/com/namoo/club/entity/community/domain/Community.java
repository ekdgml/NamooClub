package com.namoo.club.entity.community.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.namoo.club.entity.shared.type.IdNameList;

public class Community {
	//
	private String id;
	private String name;
	private String description;
	private Date openDate;
	private IdNameList categories;
	
	private CommunityManager manager;
	private List<CommunityMember> members;

	//--------------------------------------------------------------------------
	// constructors
	
	public Community() {
		// 
		this.openDate = new Date();
		this.members = new ArrayList<CommunityMember>();
	}
	
	public Community(String communityId) {
		//
		this.id = communityId;
	}
	
	public Community(String communityName, String description, String personId){
		//
		this();
		
		this.name = communityName;
		this.description = description;
	}
	
	//--------------------------------------------------------------------------
	// methods
	
	
	
	//--------------------------------------------------------------------------
	// getter/setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public IdNameList getCategories() {
		return categories;
	}

	public void setCategories(IdNameList categories) {
		this.categories = categories;
	}

	public CommunityManager getManager() {
		return manager;
	}

	public void setManager(CommunityManager manager) {
		this.manager = manager;
	}

	public List<CommunityMember> getMembers() {
		return members;
	}

	public void setMembers(List<CommunityMember> members) {
		this.members = members;
	}
	
	//--------------------------------------------------------------------------
	// override

	@Override
	public String toString() {
		// 
		StringBuilder builder = new StringBuilder();
		builder.append("id:" + id);
		builder.append(",name:" + name);
		builder.append(",description:" + description);
		builder.append(",openDate:" + openDate);
		
		return builder.toString();
	}
}