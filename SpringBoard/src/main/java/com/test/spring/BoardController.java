package com.test.spring;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	
	//------------정석-------------------
	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	//---------------------------------
	
	
	@GetMapping(value="/test")
	public String test() {
		
		return "test";
	}
	
	
	@GetMapping(value="/login")
	public String login(HttpSession session, String id, HttpServletRequest req) {
	//req는 log때문에 만듬
		
		session.setAttribute("auth", id); //로그인
		
		return "redirect:/list";
	}
	
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session, String id, HttpServletRequest req) {
		
		session.removeAttribute("auth"); //로그아웃
		
		return "redirect:/list";
	}
	
	
	
	//매개변수 순서가 pointcut(로그나 체크)에서 중요
	@GetMapping(value="/add")
	public String add(HttpSession session,  HttpServletResponse resp, HttpServletRequest req) {
		
		return "add";
	}
	
	
	@PostMapping(value="/addok")
	public void addok(HttpSession session, HttpServletResponse resp, BoardDTO dto, HttpServletRequest req) {
		
		dto.setId((String)session.getAttribute("auth")); //글쓴이
		
		int result = service.add(dto); //DB에 추가
				
		try {
				
			if (result == 1) {
				resp.sendRedirect("/spring/list");				
				
			} else {
				resp.sendRedirect("/spring/add");
//				PrintWriter writer = resp.getWriter();
//				
//				writer.println("<script>");
//				writer.println("alert('failed');");
//				writer.println("location.href='/spring/list';");
//				writer.println("</script>");
//				
//				writer.close();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	
	@GetMapping(value="/list")
	public String list(Model model, HttpServletRequest req, HttpSession session) {
		//원래 여기서는 session이 필요없지만 로그에서 사용하려고 추가함
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	@GetMapping(value="/view")
	public String view(HttpSession session, HttpServletResponse resp, Model model, String seq, HttpServletRequest req) { //seq는 글번호 > 결과를 Model에 넣어서 jsp에 반환
		//원래 여기서는 session이 필요없지만 로그에서 사용하려고 추가함
		//resp도 같은 이유
		//session과 resp를 앞에 놓은 이유는 check에서 순서에 맞게 사용하려고(매개변수 순서 통일)
		
		BoardDTO dto = service.get(seq); //seq로 해당 글의 정보 찾아서 dto에 저장
		
		model.addAttribute("dto", dto);
		
		return "view";
	}	
		
	
}
