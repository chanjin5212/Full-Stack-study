package com.test.toy.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/info.do")
public class Info extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Info.java
		//1. 아이디?
		//2. DB 작업 > DAO 위임 > select
		//3. 결과
		//4. JSP 호출하기
		
		HttpSession session = req.getSession();
		
		//1.
		String id = (String)session.getAttribute("auth");
		
		//2.
		MemberDAO dao = new MemberDAO();
		
		//3.
		MemberDTO dto = dao.get(id);
		
		//4.
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/info.jsp");
		dispatcher.forward(req, resp);
	}

}















