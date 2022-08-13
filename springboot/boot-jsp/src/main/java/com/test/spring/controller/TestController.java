package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test")
	public String test(Model model) {
		
		model.addAttribute("name", "후후후");
		
		return "test";
	}
	
}
