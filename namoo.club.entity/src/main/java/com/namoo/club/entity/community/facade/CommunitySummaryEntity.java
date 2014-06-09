package com.namoo.club.entity.community.facade;

import com.namoo.club.entity.community.domain.CommunitySummary;

public interface CommunitySummaryEntity {
	//
	void create(int communityNo, CommunitySummary summary);
	CommunitySummary retrieve(int communityNo);
	void update(int communityNo, CommunitySummary summary);
	void delete(int communityNo);
}
