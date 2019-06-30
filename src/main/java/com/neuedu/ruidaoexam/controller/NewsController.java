package com.neuedu.ruidaoexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {
	
	
	@RequestMapping("/tonews")
	public String tonews() {
		return "news";
	}
}
