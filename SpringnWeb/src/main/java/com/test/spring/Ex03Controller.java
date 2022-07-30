package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. 어노테이션 사용

@Controller
@RequestMapping(value="/ex03.do")
public class Ex03Controller {

//	//요청 메소드 > 맘대로~ > @RequestMapping
//	@RequestMapping //이걸 붙이는 순간 doGet,doPost 같은 메소드가 도니다.
//	public String test() {
//		
//		//업무 코드..
//		
//		//ModelAndView mv = new ModelAndView("ex02");			
//		//return mv;
//		
//		return "ex03";
//		//return "/WEB-INF/views/ex03.jsp";		
//	}
	
	
	//요청 메소드가 void > 주소와 동일한 이름의 JSP를 자동으로 찾아준다. > 비권장 방식 
	@RequestMapping
	public void test() {
		System.out.println("test");
				
		//return "ex03";
	}
	
	
	//@RequestMapping > 유일해야한다.
	public void aaa() {
		
	}
	
	public void bbb() {
		
	}
	
	public String ccc() {
		return "ccc";
	}
	
}
