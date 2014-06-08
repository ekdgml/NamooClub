package com.namoo.club.web.controller.club;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.club.web.controller.shared.DefaultController;
import com.namoo.club.web.controller.shared.LoginRequired;

import dom.entity.SocialPerson;

@WebServlet("/club/clubJoinInput.xhtml")
@LoginRequired
public class ClubJoinInputController extends DefaultController {

	private static final long serialVersionUID = 4306268894132074403L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		SocialPerson person = (SocialPerson) req.getSession().getAttribute("loginUser");
		String name = person.getName();
		req.setAttribute("name", name);
		req.setAttribute("comNo", req.getParameter("comNo"));
		req.setAttribute("clubNo", req.getParameter("clubNo"));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/club/clubJoinInput.jsp");
		dispatcher.forward(req, resp);
	}

}
