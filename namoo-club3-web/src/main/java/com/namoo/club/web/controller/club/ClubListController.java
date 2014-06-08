package com.namoo.club.web.controller.club;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.club.service.facade.ClubService;
import com.namoo.club.service.facade.CommunityService;
import com.namoo.club.service.factory.NamooClubServiceFactory;
import com.namoo.club.web.controller.club.pres.PresClub;
import com.namoo.club.web.controller.shared.DefaultController;
import com.namoo.club.web.controller.shared.LoginRequired;

import dom.entity.Club;
import dom.entity.Community;
import dom.entity.SocialPerson;

@WebServlet("/club/clubList.do")
@LoginRequired
public class ClubListController extends DefaultController {

	private static final long serialVersionUID = 8429308006701253816L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		ClubService service = NamooClubServiceFactory.getInstance().getClubService();
		CommunityService comService = NamooClubServiceFactory.getInstance().getCommunityService();
		SocialPerson person = (SocialPerson) req.getSession().getAttribute("loginUser");

		String name = person.getName();
		int comNo = Integer.parseInt(req.getParameter("comNo"));
		String email = person.getEmail();

		Community community = comService.findCommunity(comNo);
		req.setAttribute("community", community);
		req.setAttribute("name", name);

		List<Club> allClubs = service.findAllClubs(comNo);
		List<Club> joinClubs = service.findBelongClubs(email, comNo);
		List<Club> unjoinClubs = filterList(allClubs, joinClubs);

		List<PresClub> presJoinClubs = convertAll(joinClubs, email);
		List<PresClub> presUnJoinClubs = convertAll(unjoinClubs, email);
		
		
		req.setAttribute("joinClubs", presJoinClubs);
		req.setAttribute("unjoinClubs", presUnJoinClubs);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/club/clubList.jsp");
		dispatcher.forward(req, resp);
	}

	private List<PresClub> convertAll(List<Club> clubs, String loginEmail) {
		//
		List<PresClub> presClubs = new ArrayList<PresClub>();
		for (Club club : clubs) {
			PresClub presClub = new PresClub(club);
			presClub.setLoginEmail(loginEmail);
			presClubs.add(presClub);
		}
		return presClubs;
		
	}

	private List<Club> filterList(List<Club> allClubs, List<Club> joinClubs) {
		//
		List<Club> unjoinClubs = new ArrayList<Club>(allClubs);
		List<Club> remove = new ArrayList<Club>();
		for (Club joinClub : joinClubs) {
			for (Club club : allClubs) {
				if (club.getClubNo() == (joinClub.getClubNo())) {
					remove.add(club);
					break;
				}
			}
		}
		if (!remove.isEmpty()) {
			unjoinClubs.removeAll(remove);
		}
		return unjoinClubs;
	}
}