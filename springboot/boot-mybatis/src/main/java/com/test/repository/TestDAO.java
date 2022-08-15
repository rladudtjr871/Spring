package com.test.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public int test() {
		
		System.out.println("TestDAO.test()");
		
		return (int)System.nanoTime();
	}

	public List<String> list() {
		
		return template.selectList("test.list");
	}
	
}
