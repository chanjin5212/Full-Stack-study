package com.test.toy.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/loginok.do")
public class LoginOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//LoginOk.java
		//1. 데이터 가져오기
		//2. DB 작업 > DAO 위임 > select
		//3. 결과 > 인증 티켓 발급
		//4. JSP 호출하기
		
		
		HttpSession session = req.getSession();
		
		
		//1.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//2.
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO result = dao.login(dto);
		
		
		//3.
		if (result != null) {
			
			//인증 티켓 발급
			session.setAttribute("auth", id);
			
			session.setAttribute("name", result.getName());
			session.setAttribute("lv", result.getLv());
			
		}
		
		//4.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/loginok.jsp");
		dispatcher.forward(req, resp);
	}

}




















