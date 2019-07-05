package com.neuedu.ruidaoexam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addAbilityController {
	
	@RequestMapping(value="toGetAtNum", method = RequestMethod.POST)
    @ResponseBody
    public String addQues( @RequestBody Map val1, HttpServletRequest request) {
		System.out.println(val1.get("val1").toString()+"aaaassssssssss");
		request.getSession().setAttribute("atNum", val1.get("val1").toString());
		String result = request.getSession().getAttribute("atNum").toString();
		System.out.println("aaaaddddddddddddddddddd"+result);
		return val1.get("val1").toString();
	}
}
