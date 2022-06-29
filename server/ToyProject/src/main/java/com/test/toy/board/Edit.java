package com.test.toy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Edit.do
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > select 
		//3. 결과
		//4. JSP 호출하기 + 결과 전달하기
		
		//1.
		String seq = req.getParameter("seq");
		
		//2. + 3.
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.get(seq);
		
		//4.
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);
	}

}



















