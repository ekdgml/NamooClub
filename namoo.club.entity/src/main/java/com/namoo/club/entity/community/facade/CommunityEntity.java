package com.namoo.club.entity.community.facade;

import java.util.List;

import com.namoo.club.entity.community.domain.Community;
import com.namoo.club.entity.community.domain.CommunityManager;

public interface CommunityEntity {
	//
	int create(Community community);
	Community retrieve(int communityNo);
	List<Community> retrieveAll();
	void update(Community community);
	void delete(Community community);
	
	void createManager(CommunityManager manager);
	CommunityManager retrieveManager(int communityNo);
}
