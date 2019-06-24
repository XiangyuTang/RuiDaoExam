package com.neuedu.ruidaoexam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarkingController {
	
	
	
	@RequestMapping("/marking")
	public String getNum(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
		
		return "marking";
		
	}
	
}
