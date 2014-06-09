package com.namoo.club.entity.club.facade;

import java.util.List;

import com.namoo.club.entity.club.domain.Club;

public interface ClubEntity {
	//
	int create(Club club);
	Club retrieve(int clubNo);
	List<Club> retrieveByCommunityNo(int communityNo);
	void update(Club club);
	void delete(Club club);
}
