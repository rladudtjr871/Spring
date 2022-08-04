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
	
	//------------����-------------------
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
	//req�� log������ ����
		
		session.setAttribute("auth", id); //�α���
		
		return "redirect:/list";
	}
	
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session, String id, HttpServletRequest req) {
		
		session.removeAttribute("auth"); //�α׾ƿ�
		
		return "redirect:/list";
	}
	
	
	
	//�Ű����� ������ pointcut(�α׳� üũ)���� �߿�
	@GetMapping(value="/add")
	public String add(HttpSession session,  HttpServletResponse resp, HttpServletRequest req) {
		
		return "add";
	}
	
	
	@PostMapping(value="/addok")
	public void addok(HttpSession session, HttpServletResponse resp, BoardDTO dto, HttpServletRequest req) {
		
		dto.setId((String)session.getAttribute("auth")); //�۾���
		
		int result = service.add(dto); //DB�� �߰�
				
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
		//���� ���⼭�� session�� �ʿ������ �α׿��� ����Ϸ��� �߰���
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	@GetMapping(value="/view")
	public String view(HttpSession session, HttpServletResponse resp, Model model, String seq, HttpServletRequest req) { //seq�� �۹�ȣ > ����� Model�� �־ jsp�� ��ȯ
		//���� ���⼭�� session�� �ʿ������ �α׿��� ����Ϸ��� �߰���
		//resp�� ���� ����
		//session�� resp�� �տ� ���� ������ check���� ������ �°� ����Ϸ���(�Ű����� ���� ����)
		
		BoardDTO dto = service.get(seq); //seq�� �ش� ���� ���� ã�Ƽ� dto�� ����
		
		model.addAttribute("dto", dto);
		
		return "view";
	}	
		
	
}
