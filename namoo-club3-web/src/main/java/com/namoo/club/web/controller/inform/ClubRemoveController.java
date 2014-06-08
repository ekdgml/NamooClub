package com.namoo.club.web.controller.inform;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.club.service.facade.ClubService;
import com.namoo.club.service.facade.CommunityService;
import com.namoo.club.service.factory.NamooClubServiceFactory;
import com.namoo.club.web.controller.shared.DefaultController;
import com.namoo.club.web.controller.shared.LoginRequired;

@WebServlet("/inform/clubRemove.do")
@LoginRequired
public class ClubRemoveController extends DefaultController{

	private static final long serialVersionUID = -3829572762564286577L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		CommunityService comService = NamooClubServiceFactory.getInstance().getCommunityService();
		ClubService service = NamooClubServiceFactory.getInstance().getClubService();
		String name = req.getParameter("name");
		int comNo = Integer.parseInt(req.getParameter("comNo"));
		int clubNo = Integer.parseInt(req.getParameter("clubNo"));
		
		comService.findCommunity(comNo).removeClub(clubNo);
		service.removeClub(clubNo, comNo, true);
		
		req.setAttribute("comNo", comNo);
		req.setAttribute("name", name);
		
		redirect(req, resp, "/club/clubList.do?comNo="+comNo);
	}

}
