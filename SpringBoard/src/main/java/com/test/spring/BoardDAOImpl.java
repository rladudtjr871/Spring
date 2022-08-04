package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private SqlSessionTemplate template;
	
	@Autowired
	public BoardDAOImpl(SqlSessionTemplate template) {
		this.template = template;
	}
	
	@Override
	public int add(BoardDTO dto) {
		
				
		return this.template.insert("board.add", dto);
	}
	
	
	@Override
	public List<BoardDTO> list() {
	
		return this.template.selectList("board.list");
	}
	
	
	@Override
	public BoardDTO get(String seq) {
	
		return this.template.selectOne("board.get", seq);
	}
	
	
}
