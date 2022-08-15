package com.test.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements IMemberDAO {

	public int test() {
		
		System.out.println("MemberDAO.test()");
		
		return (int)System.nanoTime();
	}
	
}
