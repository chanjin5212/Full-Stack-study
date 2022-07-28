package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Ex02Controller implements Controller{
	
	private SpringDAO dao;
	
	public void setDao(SpringDAO dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//의존 객체
		//SpringDAO dao = new SpringDAO();
		
		int count = dao.getCount();
		
		
		ModelAndView mv = new ModelAndView("ex02");
		
		mv.addObject("count", count);
		
		return mv;
	}

}
