package com.test.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller //이거 써도 RestController로 동작
public class RestTestController {

	
	@GetMapping("/fruit")
	@ResponseBody
	public List<String> list() {
		
		List<String> list = Arrays.asList("사과", "딸기", "바나나");
		
		return list;		
	}
	
	
}
