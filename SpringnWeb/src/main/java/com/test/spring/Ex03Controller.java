package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//��Ʈ�ѷ� ����
//1. Controller �������̽� ����
//2. ������̼� ���

@Controller
@RequestMapping(value="/ex03.do")
public class Ex03Controller {

//	//��û �޼ҵ� > �����~ > @RequestMapping
//	@RequestMapping //�̰� ���̴� ���� doGet,doPost ���� �޼ҵ尡 ���ϴ�.
//	public String test() {
//		
//		//���� �ڵ�..
//		
//		//ModelAndView mv = new ModelAndView("ex02");			
//		//return mv;
//		
//		return "ex03";
//		//return "/WEB-INF/views/ex03.jsp";		
//	}
	
	
	//��û �޼ҵ尡 void > �ּҿ� ������ �̸��� JSP�� �ڵ����� ã���ش�. > ����� ��� 
	@RequestMapping
	public void test() {
		System.out.println("test");
				
		//return "ex03";
	}
	
	
	//@RequestMapping > �����ؾ��Ѵ�.
	public void aaa() {
		
	}
	
	public void bbb() {
		
	}
	
	public String ccc() {
		return "ccc";
	}
	
}
