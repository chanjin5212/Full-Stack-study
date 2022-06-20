package com.test.servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

public class Ex01 {
	
	public static void main(String[] args) {
		
		
		//알바생
		//- 브라우저 요청 > 동적으로 웹페이지 제작
		
		//요청
		//- 자바 프로그램이 HTML,CSS,JavaScript 언어를 사용해서 페이지를 제작
		
		Calendar now = Calendar.getInstance();
		
		String html = "";
		
		html += "<html>";
		html += "<head>";
		html += "<meta charset='UTF-8'>";
		html += "</head>";
		html += "<body>";
		html += "<h1>동적 페이지</h1>";
		html += "<p>이 페이지는 동적으로 생성되었습니다.</p>";
		html += String.format("<p>현재 시간: %tF %tT</p>", now, now);
		html += "</body>";
		html += "</html>";
				
		System.out.println(html);
		
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\main\\webapp\\ex01.html"));
			writer.write(html);
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//http://localhost:8090/ServletTest/ex01.html
		
		
	}

}



















