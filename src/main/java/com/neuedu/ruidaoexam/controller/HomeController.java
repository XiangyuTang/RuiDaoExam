package com.neuedu.ruidaoexam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.service.impl.HomeGetNumServiceimpl;

@Controller
public class HomeController {
	
	@Autowired
	HomeGetNumServiceimpl homeGetNumServiceimpl;
	
	@RequestMapping("/home")
	public String getNum(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		int i = homeGetNumServiceimpl.getStudentNum();
		request.getSession().setAttribute("getStudentNum", i);
		
		int j = homeGetNumServiceimpl.getTeacherNum();
		request.getSession().setAttribute("getTeacherNum", j);
		
		int qn = homeGetNumServiceimpl.getQuestionNum();
		request.getSession().setAttribute("getQuestionNum", qn);
		
		return "home";
		
	}
	
//	@RequestMapping("/marking")
//	public String getStudent(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		
//		return "marking";
//		
//	}
	
}
