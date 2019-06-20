package com.neuedu.ruidaoexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageJumpController {

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
	
	@RequestMapping("/toindex")
	public String toindex()
	{
		return "index";
	}

	@RequestMapping("/toindexteacher")
	public String toindexteacher()
	{
		return "indexteacher";
	}
	
	@RequestMapping("/toinvite")
	public String toinvite()
	{
		return "invite";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "user/reg";
	}
	
	
	@RequestMapping("tologin")
	public String toLogin() {
		return "user/login";
	}
	
}
