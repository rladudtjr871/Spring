package com.test.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		
		//m1();
		m2();
		
	}
	
	private static void m2() {
		
		//Ex02 > Hong > Pen
		//Ex02 > Lee > Brush
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/spring/di02/di02.xml");
		
		Hong hong = (Hong)context.getBean("hong");
		hong.run(); //+Pen
		
		
		Lee lee = (Lee)context.getBean("lee");
		//System.out.println(lee == null);
		lee.run();
		
	}

	private static void m1() {
		
		//������ ȯ�� > ��ü ���� + �Ҹ� > ������ ����
		// > ���� XML ����
		
		//Pen ��ü �����ϱ�
		Pen p1 = new Pen();
		p1.write();
		
		
		//XML ���� �б� > �ν� > ȣ��
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/spring/di02/di02.xml");
	
		
		//getBean() > �ĺ��ڸ� �˻� > �ش� Ŭ������ �ν��Ͻ� ����(new Pen()) + ��ȯ
		Pen p2 = (Pen)context.getBean("pen"); //id
		p2.write();
		
		Brush b1 = (Brush)context.getBean("brush");
		b1.draw();
		
		Pen p3 = (Pen)context.getBean("p1"); //name
		p3.write();
		
		Pen p4 = (Pen)context.getBean("p2"); //name
		p4.write();
		
		Pen p5 = (Pen)context.getBean("p3"); //name
		p5.write();
		
	}
	
}
