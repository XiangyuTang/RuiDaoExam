package com.neuedu.ruidaoexam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.service.InviteService;

@Controller
public class EmailController {
	
	@Autowired
	InviteService inviteService;
	
	/**
	 * @RequestBody 相当于将数据放在ajax对象中(实际上是一个json字符串),传递到后台 ,后台还是可以利用OGNL技术,与对象进行绑定
	 * @param vo
	 * @return
	 */
	@RequestMapping("/sendEmail")
	public String sendemail(@RequestBody Student stu){
		
		//HashMap<String,Object> map = new HashMap<String,Object>();
		System.out.println(stu.getName()+stu.getEmail());
		inviteService.sendEmail(stu);
		System.out.println("邮件发送成功！");
		//map.put("hehe", stu);
		/*
		if ("ligp".equals(stu.getRegistName())&&"1".equals(stu.getRegistPwd().toString())) {
			map.put("flag", "true");
			map.put("msg", "你好"+stu.getRegistName());
		}else{
			map.put("flag", "false");
			map.put("msg", "错误");
		}*/
		//return map;
		return "invite";
	}
}
