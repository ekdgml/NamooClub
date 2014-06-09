package com.namoo.club.entity.club.facade;

import com.namoo.club.entity.club.domain.ClubSummary;

public interface ClubSummaryEntity {
	//
	void create(int clubNo, ClubSummary summary);
	ClubSummary retrieve(int clubNo);
	void update(int clubNo, ClubSummary summary);
	void delete(int clubNo);
}
