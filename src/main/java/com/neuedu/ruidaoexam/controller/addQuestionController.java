package com.neuedu.ruidaoexam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class addQuestionController {
	/**
	 * ajax的调用类
	 */
	
	/**
	 * @param request
	 * @return
	 */
//	@RequestMapping("/toAddChoiceQuestionController")
//	
//	public String addChoiceQuestion(@RequestBody qtVO vo) {
//
//		System.out.println("dddddddddddd"+vo.getQtNum());
//		String qtString = vo.getQtNum();
//		System.out.println("ssssssssssssssssssssssssss"+qtString);
//		
//		return qtString;
//		
//	}
	@RequestMapping(value="toGetQtNum", method = RequestMethod.POST)
    @ResponseBody
    public String addQues( @RequestBody Map val, HttpServletRequest request) {
		System.out.println(val.get("val").toString()+"ssssssssss");
		request.getSession().setAttribute("qtNum", val.get("val").toString());
		String result = request.getSession().getAttribute("qtNum").toString();
		System.out.println("ddddddddddddddddddd"+result);
		return val.get("val").toString();
	}
	
	
}
