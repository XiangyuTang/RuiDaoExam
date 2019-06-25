package com.neuedu.ruidaoexam.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.service.InviteService;

@Controller
public class ExamController {
	
	@Autowired
	InviteService inviteService;
	
	@RequestMapping(value="/verifyintoexam",method = RequestMethod.POST)
    @ResponseBody
    public String verifyIntoExam(String email,String invitecode,HttpServletResponse response,HttpSession session) {

		String str="";
		
		InviteStudent inviteStudent = inviteService.verifyPerson(email,invitecode);
		if(inviteStudent!=null)
		{
			str="1";
			session.setAttribute("inviteStudent", inviteStudent);
			int paper_id = inviteStudent.getPaperId();
			
		}	
		else
			str="0";
		return str;
	}
}
