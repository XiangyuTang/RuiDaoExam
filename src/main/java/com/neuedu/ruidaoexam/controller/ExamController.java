package com.neuedu.ruidaoexam.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.service.InviteService;

@Controller
public class ExamController {
	
	@Autowired
	InviteService inviteService;
	
	@RequestMapping(value="/verifyintoexam",method = RequestMethod.POST)
    @ResponseBody
    public String verifyIntoExam(String email,String invitecode,HttpServletResponse response) {
		//System.out.println(email+invitecode);
		//response.addHeader("Access-Control-Allow-Origin", "*");
		String str="";
		int i = inviteService.verifyPerson(email,invitecode);
		if(i>0)
			str="1";
		return str;
	}
}
