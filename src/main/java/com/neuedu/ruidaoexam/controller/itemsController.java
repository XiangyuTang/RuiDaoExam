package com.neuedu.ruidaoexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("items")
public class itemsController{
@RequestMapping("/queryItems")
public String queryItems() {
//省略。。。
	System.out.println("考试进入");
	return null;
}
}