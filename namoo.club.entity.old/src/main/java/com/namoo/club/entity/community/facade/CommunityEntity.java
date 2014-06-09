package com.namoo.club.entity.community.facade;

import java.util.List;

import com.namoo.club.entity.community.domain.Community;

public interface CommunityEntity {
	//
	String create(Community community);
	Community retrieve(String communityId);
	List<Community> retrieveAll();
	List<Community> retrieveByManagerId(String managerId);
	void update(Community community);
	void delete(Community community);
}
