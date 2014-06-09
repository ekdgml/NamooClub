package com.namoo.club.entity.person.facade;

import java.util.List;

import com.namoo.club.entity.person.domain.SocialPerson;

public interface PersonEntity {
	//
	void create(SocialPerson person);
	SocialPerson retrieve(String email);
	void update(SocialPerson person);
	void delete(SocialPerson person);
	List<SocialPerson> retrieveAll();
}
