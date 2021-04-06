package com.example.demo.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.content.service.MainService;

@Controller
public class MainController {

	@Autowired
	MainService mainservice;
	
	@GetMapping("/main")
	public String main(Model model) {
		
		
		
		model.addAttribute("value", "hello");
		return "main";
	}
	
}
