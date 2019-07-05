package com.neuedu.ruidaoexam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.service.impl.StudentServiceimpl;
import com.neuedu.ruidaoexam.service.impl.TeacherServiceimpl;

@Controller
public class BaseInfoController {
	@Autowired StudentServiceimpl studentservice;
	@Autowired TeacherServiceimpl teacherservice;
	
	@PostMapping("/showInfo")
	@ResponseBody
	public Object showInfo(HttpServletRequest request) {
		String role = String.valueOf(request.getSession().getAttribute("role")).trim();
		Integer uid = Integer.parseInt(String.valueOf(request.getSession().getAttribute("uid")).trim());
		if(role.equals("teacher")) {
			return teacherservice.getTeacher(uid);
		}else {
			return studentservice.getStudent(uid);
		}
	}
}

