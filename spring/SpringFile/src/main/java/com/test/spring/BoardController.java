package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	
	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	
	
	//목록보기
	@GetMapping(value="/list")
	public String list(Model model) {
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	//쓰기
	@GetMapping(value="/write")
	public String write() {
		
		return "write";
	}
	
	@PostMapping(value="/writeok")
	public String writeok(HttpServletRequest req, Model model, String title) {
		
		int result = service.write(req, title);
		
		model.addAttribute("result", result);
		
		return "writeok";
	}
	
	
}



































