package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
								throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		//구구단 페이지 = HTML + CSS + JavaScript
		writer.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "        h1 {\r\n"
				+ "            border-bottom: 1px dashed #AAA;\r\n"
				+ "            width: 200px;\r\n"
				+ "        }\r\n"
				+ "        h1 > small {\r\n"
				+ "            font-size: .7em;\r\n"
				+ "            color: #777;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        div > div {\r\n"
				+ "            font-size: 1.2rem;\r\n"
				+ "            border: 1px solid #BBB;\r\n"
				+ "            width: 100px;\r\n"
				+ "            padding: 5px;\r\n"
				+ "            border-radius: 3px;\r\n"
				+ "            margin-bottom: 3px;\r\n"
				+ "            padding-left: 12px;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        div > div > span {\r\n"
				+ "            border: 1px solid #999;\r\n"
				+ "            display: inline-block;\r\n"
				+ "            width: 25px;\r\n"
				+ "            text-align: right;\r\n"
				+ "            border-radius: 3px;\r\n"
				+ "            background-color: rgba(255, 99, 71, .3);\r\n"
				+ "            display: none;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>구구단 <small>5단</small></h1>\r\n"
				+ "\r\n"
				+ "    <div id=\"list\">\r\n"
				+ "        <div>5 x 1 = <span>5</span></div>\r\n"
				+ "        <div>5 x 2 = <span>10</span></div>\r\n"
				+ "        <div>5 x 3 = <span>15</span></div>\r\n"
				+ "        <div>5 x 4 = <span>20</span></div>\r\n"
				+ "        <div>5 x 5 = <span>25</span></div>\r\n"
				+ "        <div>5 x 6 = <span>30</span></div>\r\n"
				+ "        <div>5 x 7 = <span>35</span></div>\r\n"
				+ "        <div>5 x 8 = <span>40</span></div>\r\n"
				+ "        <div>5 x 9 = <span>45</span></div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "    <script>\r\n"
				+ "\r\n"
				+ "        document.querySelectorAll('#list div').forEach(function(item, index) {\r\n"
				+ "\r\n"
				+ "            item.addEventListener('click', function(event) {\r\n"
				+ "                event.target.firstElementChild.style.display = 'inline-block';\r\n"
				+ "            });\r\n"
				+ "\r\n"
				+ "        });\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    </script>\r\n"
				+ "</body>\r\n"
				+ "</html>");		
		
		writer.close();
		
	}
	
}





















