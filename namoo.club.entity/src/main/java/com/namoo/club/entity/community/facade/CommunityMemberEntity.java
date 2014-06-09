package com.namoo.club.entity.community.facade;

import java.util.List;

import com.namoo.club.entity.community.domain.CommunityMember;

public interface CommunityMemberEntity {
	//
	void create(CommunityMember member);
	CommunityMember retrieve(int communityNo, String personId);
	List<CommunityMember> retrieveByCommnityNo(int communityNo);
	void delete(CommunityMember member);
}
