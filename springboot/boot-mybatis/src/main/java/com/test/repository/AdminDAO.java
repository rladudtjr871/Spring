package com.test.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//@Primary //를 붙이면 IMemberDAO를 상속받는 MemberDAO와 AdminDAO 중 @Primary가 붙은걸 먼저 실행
@Qualifier("admin")
public class AdminDAO implements IMemberDAO {

	public int test() {
		
		System.out.println("AdminDAO.test()");
		
		return (int)System.nanoTime();
	}
	
}
