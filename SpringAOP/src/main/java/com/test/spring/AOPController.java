package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//bean�±� ���
@Controller
public class AOPController {

	@GetMapping(value="/test")
	public String test() {
		
		System.out.println("�־���: test");
		
		return "test";
	}
	
}


