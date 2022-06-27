package com.test.memo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memo/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Edit.java
		//1. 데이터 가져오기(?seq=5)
		//2. DB 작업 > select
		//3. 결과 반환(DTO)
		//4. JSP 호출하기 + 3번 전달하기
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		DAO dao = new DAO();
		
		//3.
		DTO dto = dao.get(seq);
		
		//4.
		req.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/memo/edit.jsp");

		dispatcher.forward(req, resp);
	}

}
