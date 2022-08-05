package com.test.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조 업무 객체
@Aspect //보조 업무 객체의 자격 할당
@Component //<bean>
public class Cross {

	
	//주업무 지정 > 포인트컷 생성
	
	@Pointcut("execution(public String com.test.spring.AOPController.test())") //"AspectJ 표현식"
	public void pc1() {
		//껍데기 > 구현 x				
	}
	
	
	//보조 업무 선언 + 주업무 결합
	@After("pc1()") //이거까지 해야 주업무와 보조업무 결합
	public void m1() {
		
		System.out.println("보조 업무");
	}
	
	@Before("pc1()") 
	public void m2() {
		System.out.println("보조 업무2");
	}
	
}










