package com.test.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test.do")
public class TestController {
	
	@RequestMapping
	public String test() {
		
		return "ex03";
	}

}
