package com.test.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyBatisController {

	
	//MyBatisController > (의존) > MyBatisService > (의존) > MyBatusDAO
	
	//Spring DI 어노테이션
	@Autowired
	private MyBatisService service;
	
	
//	@Autowired	//의존주입 어노테이션 해당 클래스에는 @Component를 해줌.
//	public MyBatisController(MyBatisService service) {
//		this.service = service;
//	}
	
	
	@GetMapping(value="/test")
	public String test() {
		
		//MyBatisService service = new MyBatisServiceImpl();
		
		System.out.println("1: " + (this.service == null));
		
		service.test();
		
		return "result";
	}
	
	/*
	@GetMapping(value="/m1")
	public String m1(Model model) {
		
		return "result"; //jsp파일명
	}
	*/
	
	@GetMapping(value="/m1")
	public String m1(Model model) {
	
		//정적 쿼리 > 인자값X, 반환값X
		service.m1();
		
		return "result"; 
	}
	
	
	@GetMapping(value="/m2")
	public String m2(Model model, String seq) {
		
		//인자값O
		// > seq 전달 > 가격 인상
		
		//http://localhost:8090/spring/m2?seq=1
		
		int result = service.m2(seq);
		
		model.addAttribute("result", result);
		
		return "result"; //jsp파일명
	}
	
	
	@GetMapping(value="/m3")
	public String m3(Model model, String seq) {
		
		int result = service.m3(seq);
		
		model.addAttribute("result", result);
		
		return "result"; //jsp파일명
	}
	
	
	@GetMapping(value="/m4")
	public String m4(Model model, MyBatisDTO dto) {
		
		//m4?item=본체&price=500000
		//m4?item=태블릿&price=300000
		
		//System.out.println(dto);
		
		int result = service.m4(dto);
		
		model.addAttribute("result", result);
		
		return "result"; //jsp파일명
	}
	
	
	@GetMapping(value="/m5")
	public String m5(Model model, String seq) {
		
		//seq > 가격 반환
		//m5?seq=1
		
		int price = service.m5(seq);
		
		model.addAttribute("price", price);
		
		return "result"; //jsp파일명
	}
	
	
	
	@GetMapping(value="/m6")
	public String m6(Model model, String seq) {
		

		//seq > 모든 정보 반환
		//m6?seq=1
		
		MyBatisDTO dto = service.m6(seq);
		
		model.addAttribute("dto", dto);
		
		return "result"; //jsp파일명
	}
	
	
	
	
	@GetMapping(value="/m7")
	public String m7(Model model) {
		
		List<String> nlist = service.m7();
		
		model.addAttribute("nlist",nlist);
		
		return "result"; //jsp파일명
	}
	
	
	
	@GetMapping(value="/m8")
	public String m8(Model model) {
		
		List<MyBatisDTO> list = service.m8();
		
		model.addAttribute("list", list);
		
		return "result"; //jsp파일명
	}
	
	
	@GetMapping(value="/m9")
	public String m1(Model model, String table) {
		
		//select count(*) from tblInsa;
		
		int count = service.m9(table);
		
		model.addAttribute("count", count);
		
		return "result"; //jsp파일명
	}
	
	
	
	@GetMapping(value="/m10")
	public String m10(Model model, String word) {
		
		//select count(*) from tblInsa;
		
		List<MyBatisDTO> list = service.m10(word);
		
		model.addAttribute("list", list);
		
		return "result"; //jsp파일명
	}
	
	
	
	@GetMapping(value="/m11")
	public String m11(Model model, String type) {
		
		//employees + type
		//1. first_name
		//2. last_name
		
		List<String> nlist = service.m11(type);	
		
		model.addAttribute("nlist", nlist);
		
		return "result"; //jsp파일명
	}
	
}













