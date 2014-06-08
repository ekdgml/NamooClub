package com.namoo.club.web.controller.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.club.web.controller.shared.DefaultController;
import com.namoo.club.web.controller.shared.LoginRequired;

@WebServlet("/community/comCreateInput.xhtml")
@LoginRequired
public class ComCreateInputController extends DefaultController{

	private static final long serialVersionUID = -2467943640519332357L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		String name = req.getParameter("name");
		req.setAttribute("name", name);
		req.setAttribute("categories", req.getParameter("categories"));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/comCreateInput.jsp");
		dispatcher.forward(req, resp);
	}
}
