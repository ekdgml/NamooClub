package com.namoo.club.service.facade;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.club.service.facade.CommunityService;
import com.namoo.club.service.logic.CommunityServiceLogic;
import com.namoo.club.service.logic.UserServiceLogic;

import dom.entity.ClubCategory;
import dom.entity.Community;
import dom.entity.CommunityMember;

public class CommunityServiceTest extends DbCommonTest{
	//
	private CommunityService communityService; 
	private UserService userService;
	
	@Before
	public void setUp() throws Exception {
		//
		super.setUp();
		communityService = new CommunityServiceLogic();
		userService = new UserServiceLogic();
	}
	
	@After
	public void tearDown() throws Exception {
		//
		super.tearDown();
	}
	//----------------------------------------------------------------------------------------------
	@Test
	public void testRegistCommunity() {
		//
		List<ClubCategory> categories = new ArrayList<>();
		ClubCategory category1 = new ClubCategory(1, 3, "category1"); 
		ClubCategory category2 = new ClubCategory(2, 3, "category2"); 
		categories.add(category1);
		categories.add(category2);
		Community community = communityService.registCommunity("com3", "com3_des", "ekdgml", categories);
		
		//검증
		community = communityService.findCommunity(community.getComNo());
		assertEquals(3, communityService.findAllCommunities().size());
		assertThat(community.getManager().getEmail(), is("ekdgml"));
		assertThat(community.getMembers().size(), is(1));
	}

	@Test
	public void testFindCommunity() {
		//
		Community community = communityService.findCommunity(1);
		
		//검증
		assertEquals("com1", community.getName());
		assertEquals("com1_des", community.getDescription());
		assertThat(community.getManager().getEmail(), is("ekdgml"));
		assertThat(community.getManager().getName(), is("박상희"));
	}

	@Test
	public void testJoinAsMemberAndUser() {
		//
		communityService.joinAsMember(2, "abcd", "abcdId", "jkl");
		
		//검증
		CommunityMember member = communityService.findCommunityMember(2, "abcdId");
		assertEquals("abcdId", member.getEmail());
		assertThat(member.getName(), is("abcd"));
		assertNotNull(userService.findTowner("abcdId"));
	}

	@Test
	public void testJoinAsMember() {
		//
		communityService.joinAsMember(2, "wntjd");
		
		//검증
		CommunityMember member = communityService.findCommunityMember(2, "wntjd");
		assertEquals("wntjd", member.getEmail());
		assertThat(member.getName(), is("이주성"));
	}

	@Test
	public void testFindAllCommunities() {
		//
		List<Community> communities = communityService.findAllCommunities();
		
		//검증
		assertEquals(2, communities.size());
		assertThat(communities.get(0).getName(), is("com1"));
	}

	@Test
	public void testRemoveCommunity() {
		//
		communityService.removeCommunity(1, true);
		
		List<Community> communities = communityService.findAllCommunities();
		assertEquals(1, communities.size());
		assertThat(communities.get(0).getName(), is("com2"));
	}

	@Test
	public void testFindBelongCommunities() {
		//
		List<Community> communities = communityService.findBelongCommunities("ekdgml");
		
		//검증
		assertEquals(1, communities.size());
		assertThat(communities.get(0).getName(), is("com1"));
	}

	@Test
	public void testFindManagedCommnities() {
		//
		List<Community> communities = communityService.findManagedCommunities("ekdgml");
		
		//검증
		assertEquals(1, communities.size());
		assertThat(communities.get(0).getName(), is("com1"));
	}

	@Test
	public void testWithdrawalCommunity() {
		//
		communityService.withdrawalCommunity(1, "hong");
		
		//검증
		assertEquals(1, communityService.findAllCommunityMember(1).size());
		assertNull(communityService.findCommunityMember(1, "hong"));
	}

	@Test
	public void testFindAllCategories() {
		//
		List<ClubCategory> categories = communityService.findAllCategories(1);
		assertEquals(2, categories.size());
		assertThat(categories.get(0).getCategoryName(), is("category1"));
	}

}
