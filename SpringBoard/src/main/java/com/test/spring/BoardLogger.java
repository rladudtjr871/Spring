package com.test.spring;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class BoardLogger {
	
	//모든 페이지 > 로그 기록
	//- 모든 URL
	
	//주업무 등록
	@Pointcut("execution(public * com.test.spring.BoardController.*(..))")
	public void pc1() {
		
	}
	
	@After("pc1()") //주업무와 연결
	public void log(JoinPoint joinPoint) { //joinPoint로 pc1의 인자값을 받아낼 수 있다.
		
		//[언제 - 누가] URL 접속 (request나 session이 필요)
		
		HttpServletRequest req = null;
		HttpSession session = null;
		
		//Objec 배열을 반환 > 받아 온 매개변수를 배열로 반환
		for (Object obj : joinPoint.getArgs()) {
			
			if (obj instanceof HttpServletRequest) {
				req = (HttpServletRequest)obj;
			} else if (obj instanceof HttpSession) {
				session = (HttpSession)obj;
			}
			
		}
		
		//
		if (req != null && session != null) {
			
			//[언제 - 누가] URL 접속
			Calendar now = Calendar.getInstance();
			
			System.out.printf("[LOG][%tF %tT - %s] %s\n"
							, now, now
							, session.getAttribute("auth") != null ? session.getAttribute("auth") : "익명"
							, req.getRequestURI());
		}
	}
	
}
