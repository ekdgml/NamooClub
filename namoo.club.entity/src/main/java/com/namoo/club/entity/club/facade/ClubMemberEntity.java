package com.namoo.club.entity.club.facade;

import java.util.List;

import com.namoo.club.entity.club.domain.ClubMember;

public interface ClubMemberEntity {
	//
	void create(ClubMember member);
	ClubMember retrieve(int clubNo, String personId);
	List<ClubMember> retrieveByClubNo(int clubNo);
	void delete(ClubMember member);
}
