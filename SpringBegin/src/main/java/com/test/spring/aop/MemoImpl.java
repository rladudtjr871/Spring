package com.test.spring.aop;

import java.util.Calendar;

public class MemoImpl implements Memo {

	@Override
	public void add(String memo) {
		
		System.out.println("�޸� ����: " + memo);
				
	}

	@Override
	public String read(int seq) throws Exception {
		
		if (seq >= 1 && seq <= 10) {
			System.out.println("�޸� �б�: " + seq);
		} else {
			throw new Exception("�������� �ʴ� �޸�");
		}
		
		return "�޸��Դϴ�.";
	}

	@Override
	public boolean edit(int seq, String memo) {
		
		System.out.println("�޸� �����ϱ�: " + memo);
		
		return false;
	}

	@Override
	public boolean del(int seq) {
		
		System.out.println("�޸� �����ϱ�: " + seq);
		
		return false;
	}
	
}
