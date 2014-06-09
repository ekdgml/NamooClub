package com.namoo.club.entity.community.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.club.entity.community.domain.Community;
import com.namoo.club.entity.shared.DbCommonTestCase;

public class CommunityEntityTest extends DbCommonTestCase {

	private static final String DATASET_XML = "CommunityEntityTest_dataset.xml";

	@Autowired
	private CommunityEntity communityEntity;

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreate() {
		//
		Community community = new Community();
		community.setName("영화 커뮤니티");
		community.setDescription("영화를 사랑하는 사람들의 모임");

		String communityId = communityEntity.create(community);

		// assertion
		community = communityEntity.retrieve(communityId);
		assertEquals("영화 커뮤니티", community.getName());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testRetrieve() {
		//
		Community community = communityEntity.retrieve("1");

		// assertion
		assertEquals("스포츠 커뮤니티", community.getName());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testRetrieveAll() {
		//
		List<Community> communities = communityEntity.retrieveAll();

		// assertion
		assertEquals(3, communities.size());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdate() {
		//
		Community community = communityEntity.retrieve("1");
		community.setName("만능 스포츠 커뮤니티");
		
		// execution
		communityEntity.update(community);
		
		// assertion
		community = communityEntity.retrieve("1");
		assertEquals("만능 스포츠 커뮤니티", community.getName());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDelete() {
		//
		communityEntity.delete(new Community("1"));
		
		// assertion
		assertNull(communityEntity.retrieve("1"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreateCategory() {
		fail("Not yet implemented");
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testRetrieveCategory() {
		fail("Not yet implemented");
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testRetrieveAllCategories() {
		fail("Not yet implemented");
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdateCategory() {
		fail("Not yet implemented");
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeleteCategory() {
		fail("Not yet implemented");
	}

}
