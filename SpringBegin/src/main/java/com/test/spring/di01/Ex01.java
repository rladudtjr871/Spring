package com.test.spring.di01;

import java.util.Calendar;
import java.util.Random;

public class Ex01 {

public static void main(String[] args) {
		
		//Ex01�� Pen�� ����!!!
		//- Ex01�� Pen�� ����(���)�Ѵ�.
		//- Pen�� Ex01�� ������ü��� �θ���.
		
		//Ex01�� �ڽ��� ������ �����ϱ� ���ؼ� Pen�� ����ߴ�.
		// > Pen�� ������ Ex01�� ������ ������ �� ����.
		Pen pen = new Pen();
		pen.write();
		
		
		//Brush�� ������ü�̴�.
		Brush brush = new Brush();
		brush.draw();
		
		
		
		
		//Ex01 > (��������) > Hong(������ü) > (��������) > Pen(������ü)
		
		//Hong > Pen
		Hong hong = new Hong();
		hong.run(); // > Pen > �۾�
		
		
		
		//Ex01 > Lee > Brush
		
		//Brush > Lee
		Brush b = new Brush();
		
		Lee lee = new Lee(b); //����(��ü) ����(DI)
		lee.run();
		
		
		//Hong vs Lee
		//- ���� ������ �߽�(����)�� ����??
		
	}
	
}
