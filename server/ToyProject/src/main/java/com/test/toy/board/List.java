package com.test.toy.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doTemp(req, resp);
	}
	
	
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		doTemp(req, resp);
//	}
	
	

	private void doTemp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//List.java
		//1. DB 작업 > DAO 위임 > select
		//2. 결과
		//3. JSP 호출하기 + 결과 전달하기
		
		
		
		
		//그냥 목록? vs 검색 결과?
		//- list.do
		//- list.do + (column + word)
		
		req.setCharacterEncoding("UTF-8");
		
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String isSearch = "n";
		
		if ((column == null || word == null)
				|| (column == "" || word == "")) {
			isSearch = "n";
		} else {
			isSearch = "y";
		}
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("column", column);
		map.put("word", word);
		map.put("isSearch", isSearch);
		
				
		
		HttpSession session = req.getSession();
		
		//1. + 2.
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list = dao.list(map);
		
		//2.5
		//- 출력 데이터의 가공 업무
		
		Calendar now = Calendar.getInstance();
		String strNow = String.format("%tF", now);// "2022-06-29"
		
		for (BoardDTO dto : list) {
			
			//시분초 자르기
			if (dto.getRegdate().startsWith(strNow)) {
				//오늘
				dto.setRegdate(dto.getRegdate().substring(11));
			} else {
				//어제 이전
				dto.setRegdate(dto.getRegdate().substring(0, 10));
			}
			
			
			//제목이 길면 자르기
			if (dto.getSubject().length() > 25) {
				dto.setSubject(dto.getSubject().substring(0, 25) + "..");
			}
			
			//태그 비활성화
			dto.setSubject(dto.getSubject().replace("<", "&lt;").replace(">", "&gt;"));
			
		}
		
		
		//2.7 새로고침 조회수 증가 방지
		session.setAttribute("read", "n");
		
		
		
		//3.
		req.setAttribute("list", list);
		
		req.setAttribute("map", map);
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}



















