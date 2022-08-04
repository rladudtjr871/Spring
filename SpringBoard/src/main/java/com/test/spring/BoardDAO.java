package com.test.spring;

import java.util.List;

public interface BoardDAO {

	int add(BoardDTO dto);

	List<BoardDTO> list();

	BoardDTO get(String seq);
 
	
	
}
