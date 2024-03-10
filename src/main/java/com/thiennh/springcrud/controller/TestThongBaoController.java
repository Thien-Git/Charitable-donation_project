package com.thiennh.springcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestThongBaoController {

	@GetMapping("/testThongBao")
	public String testThongBao(Model model) {
		
//		model.addAttribute("msg", "Hello");
		model.addAttribute("ohno", "Hello");
		
		return "templates/test/tview";
	}
	
	@GetMapping("/dichden")
	public String dich(@RequestParam("msg") String msg, Model model) {
		
//		OK vậy là chuyển hướng qua đây thì nó nhận msg theo kieu requestParam,
		System.out.println(msg);
		model.addAttribute("msg", msg);
		return "templates/test/tview";
	}
	
	@GetMapping("/redirect")
	public String testRe(Model model) {
		
		model.addAttribute("msg", "Success");
		
		return "redirect:/dichden";
	}
}
