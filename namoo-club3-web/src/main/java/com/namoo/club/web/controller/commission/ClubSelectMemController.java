package com.namoo.club.web.controller.commission;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.club.service.facade.ClubService;
import com.namoo.club.service.factory.NamooClubServiceFactory;
import com.namoo.club.web.controller.shared.DefaultController;
import com.namoo.club.web.controller.shared.LoginRequired;

import dom.entity.ClubManager;
import dom.entity.ClubMember;
import dom.entity.SocialPerson;

@WebServlet("/commission/clubSelectMem.xhtml")
@LoginRequired
public class ClubSelectMemController extends DefaultController{

	private static final long serialVersionUID = 7884665973587174715L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		ClubService service = NamooClubServiceFactory.getInstance().getClubService();
		SocialPerson person = (SocialPerson) req.getSession().getAttribute("loginUser");
		String name = person.getName();
		int clubNo = Integer.parseInt(req.getParameter("clubNo"));
		String clubName = service.findClub(clubNo).getName();
		List<ClubMember> members = service.findAllClubMember(clubNo);
		
		List<ClubManager> managers = service.findAllClubManager(clubNo);
		members = filter(members, managers);
		
		req.setAttribute("members", members);
		req.setAttribute("name", name);
		req.setAttribute("club", clubName);
		req.setAttribute("clubNo", clubNo);
		req.setAttribute("comNo", req.getParameter("comNo"));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/commission/clubSelectMem.jsp");
		dispatcher.forward(req, resp);
	}
	private List<ClubMember> filter(List<ClubMember> members, List<ClubManager> managers) {
		// 
		ClubMember found = null;
		for (ClubMember member : members) {
			for (ClubManager manager : managers)
			if (member.getEmail().equals(manager.getEmail())) {
				found = member;
				System.out.println(found.getEmail());
				break;
			}
		}
		
		if (found != null) {
			members.remove(found);
		}
		
		return members;
	}
}
