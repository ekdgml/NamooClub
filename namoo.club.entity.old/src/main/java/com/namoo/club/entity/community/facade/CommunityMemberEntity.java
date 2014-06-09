package com.namoo.club.entity.community.facade;

import java.util.List;

import com.namoo.club.entity.community.domain.CommunityMember;

public interface CommunityMemberEntity {
	//
	void create(CommunityMember member);
	List<CommunityMember> retrieveByCommunityId(String communityId);
	void delete(CommunityMember member);
	void update(CommunityMember member);
}
