package com.neuedu.ruidaoexam.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.MsgOfInvite;
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
	//@RequestMapping("/sendEmail")
	@PostMapping("/sendEmail")
	@ResponseBody
	public String sendemail(@RequestBody MsgOfInvite msg,HttpSession session
			/*@RequestParam(value="name",required=false) String name,
			@RequestParam(value="email",required=false) String email,
			@RequestParam(value="begintime",required=false) String begin_time,
			@RequestParam(value="endtime",required=false) String end_time,
			@RequestParam(value="cheattimes",required=false,defaultValue="0") Integer cheat_times*/){		
		//HashMap<String,Object> map = new HashMap<String,Object>();
		//System.out.println(stu.getName()+stu.getEmail());
		System.out.println(msg.getName()+"---"+msg.getEmail());
		System.out.println(msg.getBegintime()+"---"+msg.getEndtime()+"---"+msg.getCheattimes());
		String invitecode = "";
		for(int i=0; i<6; i++) {
			invitecode += (int)(Math.random()*10);
		}
		session.setAttribute("invitecode", invitecode);
		inviteService.sendEmail(msg,invitecode);
		System.out.println("邮件发送成功！");
		
		return "invite";
	}
}
