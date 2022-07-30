package com.test.spring.di01;

public class Lee {

	//���� ��ü
	private Brush brush;
	
	//DI ����
	//1. ������
	//2. Setter
	
	//�ٸ� ���(�ܺ�)�� ���� ���� > ������(******) > ���� ���� ����
	public Lee(Brush brush) {
		this.brush = brush;
	}
	
	//Setter(*****) > ���� ���� ����
	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	public void run() {
		
		//���� ��ü ����X
		//Brush brush = new Brush(); //���� ����
		brush.draw();
		
	}
	
	
}
