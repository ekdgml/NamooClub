package com.namoo.club.entity.person.facade;

import com.namoo.club.entity.person.domain.SocialPerson;

public interface PersonEntity {
	//
	void create(SocialPerson person);
	SocialPerson retrieve(String personId);
	void update(SocialPerson person);
	void delete(SocialPerson person);
}
