package com.test.spring.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

//���� ���� ��ü
public class Logger {

	public void log() {
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] �α׸� ����մϴ�.\n", now, now);
	}
	
	public void time(ProceedingJoinPoint jp) {
		
		long begin = System.nanoTime();
		System.out.println("[LOG] ����� �����մϴ�.");
		
		//�־���
		try {
			
			jp.proceed(); //���� �����ϴ� �־����� �븮��
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		System.out.println("[LOG] ����� �����մϴ�.");
		
		System.out.printf("[LOG] �ҿ� �ð� %,dns\n", end - begin);
		
	}
	
	
	public void history(Object memo) {
		System.out.println("[LOG] �б� ���: " + memo);
	}
	
	public void check(Exception e) {
		System.out.println("[LOG] ���� �߻� " + e.getMessage());
	}
	
}
