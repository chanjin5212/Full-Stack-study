package com.test.memo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memo/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//List.java
		//1. DB 작업 > DAO 위임 > select
		//2. 결과 반환
		//3. JSP 호출하기 + 결과 전달하기
		
		//1. + 2.
		DAO dao = new DAO();
		
		ArrayList<DTO> list = dao.list();
		
		//2.5
		for (DTO dto : list) {
			dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		}
		
		//3.
		req.setAttribute("list", list);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/memo/list.jsp");

		dispatcher.forward(req, resp);
	}

}