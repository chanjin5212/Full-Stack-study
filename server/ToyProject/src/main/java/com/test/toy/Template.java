package com.test.toy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/template.do")
public class Template extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Template.java
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/template.jsp");
		dispatcher.forward(req, resp);
	}

}


















