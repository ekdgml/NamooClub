package com.namoo.club.entity.community.shared.dto;

import java.util.Date;
import java.util.List;

import com.namoo.club.entity.community.domain.Community;
import com.namoo.club.entity.community.domain.CommunityMember;
import com.namoo.club.entity.shared.type.IdNameList;

public class CommunityRDto extends CommunityCDto{
	//
	private int countOfMembers;
	private int countOfClubs;
	private Date openDate;
	private List<IdNameList> categories;
	private List<CommunityMember> members;
	private String managerName;
	
	//--------------------------------------------------------------
	//0. default public constructor
	public CommunityRDto() {
		//
	}
	//--------------------------------------------------------------
	// 1. private constructor
	public CommunityRDto(Community community) {
		//
		this.countOfMembers = community.getMembers().size();
		this.openDate = community.getOpenDate();
		this.categories = community.getCategories();
		this.members = community.getMembers();
		this.managerName = community.getPersonName();
	}
	//--------------------------------------------------------------
	// 2. DTO creation form a domain object
	public CommunityRDto createDto(Community community) {
		//
		return new CommunityRDto(community);
	}
	//--------------------------------------------------------------
	// 3. getter only in RDto
	
	public int getCountOfMembers() {
		return countOfMembers;
	}
	public int getCountOfClubs() {
		return countOfClubs;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public List<IdNameList> getCategories() {
		return categories;
	}
	public List<CommunityMember> getMembers() {
		return members;
	}
	public String getManagerName() {
		return managerName;
	}
	
}
