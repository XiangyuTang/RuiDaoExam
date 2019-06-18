package com.neuedu.ruidaoexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class controller1 {

	//这个controller测试放行静态资源的
	@RequestMapping("/to11")
	public String to111(){
		//System.out.println("f-----------------");
		return "11";
	}
	@RequestMapping("/test")
	public String test()
	{
		return "examOver";
	}
	
	@RequestMapping("/toinvite")
	public String toinvite()
	{
		return "inviteStudents";
	}
	
	@RequestMapping("/toindex")
	public String toindex()
	{
		return "index";
	}
	
}
