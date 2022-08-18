package com.test.spring.thymeleaf;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {
	
	
	private SqlSessionTemplate template;
	
	@Autowired
	public AddressDAO(SqlSessionTemplate template) {
		this.template = template;
		
	}

	
	//단일값(숫자)
	public int num() {
		
		return template.selectOne("test.num");				
	}
	
	
	//단일값(문자열)
	public String txt() {
		
		return template.selectOne("test.txt");
	}
	
	//단일값(날짜)
	public Calendar now() {
		
		return Calendar.getInstance();
	}
	
	//단일값(DTO)
	public AddressDTO get() {
		
		return template.selectOne("test.get");
	}
	
	//단일값(HashMap)
	public Map<String, Integer> map() {
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		map.put("kor", 100);
		map.put("eng", 90);
		map.put("math", 80);
		
		return map;		
	}
	
	
	//다중값(List<String>)
	public List<String> names() {
		
		return template.selectList("test.names");
	}
	
	
	//다중값(List<AddressDTO>)
	public List<AddressDTO> list() {
		
		return template.selectList("test.list");
	}
	
}
