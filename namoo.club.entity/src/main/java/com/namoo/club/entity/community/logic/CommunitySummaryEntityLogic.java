package com.namoo.club.entity.community.logic;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.entity.community.domain.CommunitySummary;
import com.namoo.club.entity.community.facade.CommunitySummaryEntity;

@Repository
public class CommunitySummaryEntityLogic implements CommunitySummaryEntity {
	//
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void create(int communityNo, CommunitySummary summary) {
		// TODO Auto-generated method stub

	}

	@Override
	public CommunitySummary retrieve(int communityNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int communityNo, CommunitySummary summary) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int communityNo) {
		// TODO Auto-generated method stub

	}

}
