package com.test.toy.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/registerok.do")
public class RegisterOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//RegisterOk.java
		//1. 인코딩
		//2. 파일 업로드
		//3. 데이터 가져오기		
		//4. DB 작업 > DAO 위임 > insert
		//5. 결과
		//6. JSP 호출하기
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String path = req.getRealPath("/pic");
		
		System.out.println(path);
		
		int size = 1024 * 1024 * 100;
		
		String id = "";
		String pw = "";
		String name = "";
		String filename = "";
		int result = 0;
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
											req,
											path,
											size,
											"UTF-8",
											new DefaultFileRenamePolicy()
										);
			
			//3.
			id = multi.getParameter("id");
			pw = multi.getParameter("pw");
			name = multi.getParameter("name");
			filename = multi.getFilesystemName("pic");
			
			if (filename == null) {
				filename = "pic.png";
			}
			
			
			//4. 
			MemberDTO dto = new MemberDTO();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setPic(filename);
			
			//MemberDTO(id=aaa, pw=111, name=aaa, lv=null, pic=back.jpg, regdate=null)
			//MemberDTO(id=aaa, pw=111, name=aaa, lv=null, pic=null, regdate=null)

			//System.out.println(dto);
			
			MemberDAO dao = new MemberDAO();
			
			result = dao.add(dto);
			
		} catch (Exception e) {
			System.out.println("RegisterOk.doPost");
			e.printStackTrace();
		}
		
		//4.
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/registerok.jsp");
		dispatcher.forward(req, resp);
	}

}



















