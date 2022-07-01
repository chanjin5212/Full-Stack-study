package com.test.toy.board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//AddOk.java
		//1. 인코딩
		//2. 데이터 가져오기(subject, content)
		//3. DB 작업 > DAO 위임 > insert
		//4. 결과
		//5. JSP 호출하기
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		
		
		//1.5 파일 업로드
		String path = req.getRealPath("/files");
		int size = 1024 * 1024 * 100;
		
		
		MultipartRequest multi = null;
		
		try {
			
			multi = new MultipartRequest(
									req,
									path,
									size,
									"UTF-8",
									new DefaultFileRenamePolicy());
					
			
		} catch (Exception e) {
			System.out.println("AddOk.doPost");
			e.printStackTrace();
		}
		
		
		
		//2.
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		
		

		
		//2.5 현재 새글 작성중인지? 답변글 작성중인지?
		String reply = multi.getParameter("reply");
//		System.out.println(reply);
		
		int thread = -1;
		int depth = -1;
		
		
		BoardDAO dao = new BoardDAO();
		
		if (reply.equals("")) {
			//새글
			//a. 현존하는 모든 게시물 중에서 가장 큰 thread 값을 찾아서, 그 값에 +1000을 한 값을 새글의 thread값으로 사용한다.
			
			thread = dao.getMaxThread() + 1000;
			
			//b. 새글의 depth는 항상 0을 넣는다.
			depth = 0;


		} else {
			//답변글
			
			
			
			int parentThread = Integer.parseInt(multi.getParameter("thread"));
			int parentDepth = Integer.parseInt(multi.getParameter("depth"));
			int previousThread = (int)Math.floor((parentThread - 1) / 1000) * 1000;

			//a. 현존하는 모든 게시물의 thread값을 대상으로 현재 작성 중인 답변글의 부모글 thread값보다 작고, 이전 새글을 thread값보다 큰 thread를 모두 찾아서 -1을 한다.
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("parentThread", parentThread);
			map.put("previousThread", previousThread);
			
			
			dao.updateThread(map);
			
			
			//b. 현재 답변글의 thread값은 부모글의 thread-1을 넣는다.
			thread = parentThread - 1;
			
			//c. 현재 답변글의 depth값은 부모글의 depth+1을 넣는다.
			depth = parentDepth + 1;
			
			
		}
		
		
		
		
		//2.7 업로드 파일 처리
		String filename = multi.getFilesystemName("attach");
		String orgfilename = multi.getOriginalFileName("attach");
		
		
		
		
		
		
	
		//3.
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId((String)session.getAttribute("auth"));
		
		dto.setThread(thread);
		dto.setDepth(depth);
		
		dto.setFilename(filename);
		dto.setOrgfilename(orgfilename);
		
		
		
		
		
		
		
		int result = 0;
		
		if (session.getAttribute("auth") != null) {
			result = dao.add(dto);
		}
		
		
		//방금 쓴 글번호
		String seq = dao.getSeq();
		
		
		
		//3.5 해시 태그 
		String tags = multi.getParameter("tags");
		
		
		
		//게시물 1개 + 해시 태그 3개
		//- 게시물 1개 insert
		//- 게시물 1개 PK select
		//(
		//- 해시 태그 1개 insert
		//- 해시 태그 PK select
		//- 게시물해시태그 1개 insert
		//) x 3개
		
		
		//System.out.println("tags: " + tags);
		
		//Java > JSON format > JSON Simple
		
		
		JSONParser parser = new JSONParser();
		
		try {
			
			//JSONArray list;
			//JSONObject obj;
			
			JSONArray list = (JSONArray)parser.parse(tags);
			
			//System.out.println(list);
			
			for (Object obj : list) {
				//System.out.println(obj);
				
				String tag = (String)((JSONObject)obj).get("value");
				
				//HashTag > insert
				dao.addHashTag(tag);
				
				String hseq = dao.getHashTagSeq();
				
				//Tagging > insert
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("bseq", seq);
				map.put("hseq", hseq);
				
				dao.addTagging(map);
				
				
				
			}
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		
		
		
		
		
		
		//4.
		req.setAttribute("result", result);		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/addok.jsp");
		dispatcher.forward(req, resp);
	}

}



















