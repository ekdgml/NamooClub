package com.namoo.club.entity.club.facade;

import java.util.List;

import com.namoo.club.entity.club.domain.ClubManager;

public interface ClubManagerEntity {
	//
	void create(ClubManager manager);
	ClubManager retrieve(int clubNo, String personId);
	List<ClubManager> retrieveByClubNo(int clubNo);
	void delete(ClubManager manager);
}
