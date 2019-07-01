package com.neuedu.ruidaoexam.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.News;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.service.InviteService;
import com.neuedu.ruidaoexam.service.NewsService;
import com.neuedu.ruidaoexam.service.TeacherService;

@Controller
public class InviteController {
	
	@Autowired
	InviteService inviteService;
	@Autowired
	NewsService newsService;
	@Autowired
	TeacherService teacherService;
	/**
	 * @RequestBody 相当于将数据放在ajax对象中(实际上是一个json字符串),传递到后台 ,后台还是可以利用OGNL技术,与对象进行绑定
	 * @param vo
	 * @return
	 */
	//@RequestMapping("/sendEmail")
	@PostMapping("/sendEmail")
	@ResponseBody
	public String sendemail(@RequestBody MsgOfInvite msg,HttpSession session){		
		//HashMap<String,Object> map = new HashMap<String,Object>();
		System.out.println(msg.getName()+"---"+msg.getEmail());
		System.out.println(msg.getBegintime()+"---"+msg.getEndtime()+"---"+msg.getCheattimes());
		String invitecode = "";
		if(session.getAttribute("invitecode")==null)//如果session中没有邀请码
		{
			for(int i=0; i<6; i++) {
				invitecode += (int)(Math.random()*10);
			}
			session.setAttribute("invitecode", invitecode);
		}
		else
		{
			invitecode = session.getAttribute("invitecode").toString();
		}
		inviteService.sendEmail(msg,invitecode);
		inviteService.addInviteMsg(msg,invitecode);
		System.out.println("邮件发送成功！");
		
		return "invite";
	}
	
	@PostMapping("/informOne")
	@ResponseBody
	public String inform(@RequestBody MsgOfInvite msg,HttpSession session)
	{
		String invitecode = "";
		if(session.getAttribute("invitecode")==null)
		{
			for(int i=0; i<6; i++) {
				invitecode += (int)(Math.random()*10);
			}
			session.setAttribute("invitecode", invitecode);
		}
		else
		{
			invitecode = session.getAttribute("invitecode").toString();
		}
		//inviteService.verifyPerson(msg.getEmail(), )
		
		inviteService.addInviteMsg(msg,invitecode);
		/*InviteStudent student = inviteService.verifyPerson(msg.getEmail(), invitecode);
		Teacher teacher = teacherService.getTeacher(student.getTeacherId());
		Date time = new Date();
		News news = new News(null,0,null,student.getStudentId(),1,student.getTeacherId(),null,teacher.getName(),0,time,);
		newsService.insertNews(news);*/
		return "invite";
	}
	
	//考生录入界面
	@RequestMapping("/toinvite")
	public String toinvite(Integer paper_id, Model m) {
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
//		System.out.println(paper_id);
		m.addAttribute("paper_id", paper_id);
		return "invite";
	}
}
