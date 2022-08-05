package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//bean태그 등록
@Controller
public class AOPController {

	@GetMapping(value="/test")
	public String test() {
		
		System.out.println("주업무: test");
		
		return "test";
	}
	
}


