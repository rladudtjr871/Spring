package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {

	@Autowired private SqlSessionTemplate template;
	
	public int insert(String id) {
		
		return this.template.insert(id);
	}
	
	public int insert(String id, Object param) {
		
		return this.template.insert(id, param);
	}
	
	public int update(String id) {
		
		return this.template.update(id);
	}
	
	public int update(String id, Object param) {
		
		return this.template.update(id, param);
	}
	
	public int delete(String id) {
		
		return this.template.delete(id);
	}
	
	public int delete(String id, Object param) {
		
		return this.template.delete(id, param);
	}
	
	public Object selectOne(String id) {
		
		return this.template.selectOne(id);
	}
	
	public Object selectOne(String id, Object param) {
		
		return this.template.selectOne(id, param);
	}
	
	public List<AddressDTO> selectList(String id) {
		
		return this.template.selectList(id);
	}
	
	public List<AddressDTO> selectList(String id, Object param) {
		
		return this.template.selectList(id, param);
	}
	
}

















