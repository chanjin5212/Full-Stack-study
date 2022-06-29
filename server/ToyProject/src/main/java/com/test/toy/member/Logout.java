package com.test.toy.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Logout.java
		//1. 로그아웃
		//2. JSP 호출하기
		
		HttpSession session = req.getSession();
		
		//1.
		session.removeAttribute("auth");
		session.removeAttribute("name");
		session.removeAttribute("lv");
		
		//2.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/logout.jsp");
		dispatcher.forward(req, resp);
	}

}



















