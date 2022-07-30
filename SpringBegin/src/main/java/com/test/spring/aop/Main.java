package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//Main > ��Ʈ�ѷ�(�־��� �����ϴ� ����)
		
		//�־��� ��ü
		//Memo memo = new MemoImpl();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/aop/memo.xml");
		
		Memo memo = (Memo)context.getBean("memo");
		
		//�޸� ����
		memo.add("������ AOP �۾��� �ϰ� �ֽ��ϴ�.");

		//�޸� �б�
		try {
			
			String txt = memo.read(5);
			txt = memo.read(15);
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		//�޸� �����ϱ�
		boolean result = memo.edit(5, "������ �����Դϴ�.");
		
		//�޸� �����ϱ�
		result = memo.del(5);
		
	}

}
