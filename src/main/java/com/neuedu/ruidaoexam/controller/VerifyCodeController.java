package com.neuedu.ruidaoexam.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.ruidaoexam.configUtils.MD5Util;
import com.neuedu.ruidaoexam.configUtils.SendEmailUtils;

import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.service.LogAndRegService;
import com.neuedu.ruidaoexam.service.StudentService;
import com.neuedu.ruidaoexam.service.TeacherService;


@Controller
public class VerifyCodeController {

   @Autowired StudentService studentservice;
   @Autowired TeacherService teacherservice;
   @Autowired LogAndRegService logandregservice;
	/*
	 * 作用：邮箱验证码发送
	 * 详细：生成一个6位随机验证码(String)，调用service.SendEmailUtils的方法发送
	 * 验证 邮件，并将验证码存在session中用来下次验证验证码。
	 * 返回emailSendMsg：1成功，0失败（receiver收信人为null）
	 */
	@RequestMapping("/testpage")
	
	public String testpage() {
		return "TestPage";
	}
	
	@PostMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(String email) {
		if(!logandregservice.checkEmail(email)) {
			return "1";//1代表邮件在数据库里不存在 可以加入
		}
		return "0";
		
	}
	@PostMapping("/checkNickname")
	@ResponseBody
	public String checkNickname(String nickname) {
		if(!logandregservice.checkUsername(nickname)) {
			return "1";//1代表用户名在数据库里不存在 可以加入
		}
		return "0";
		
		
		
	}
	//@RequestParam("receiver")
	public String fucku(String receiver,
			HttpSession session) {
		System.out.println("test成功:"+receiver);
		session.setAttribute("receiver", "success4094");
		return "sss";
	}
	@PostMapping("/checkRegister")
	@ResponseBody
	//@RequestParam("receiver")
	public String checkVerifyemail(String email,String vercode,String password,String nickname,String character, String base64url,HttpSession session) {
		String verifycode = String.valueOf(session.getValue("verifycode"));//验证码的获取
		if(!vercode.equals(verifycode)) {
			return "0";	
		}
		if(character.equals("student"))
		{
		Student student=new Student();
		student.setEmail(email);
		student.setName(nickname);
		student.setPassword(MD5Util.md5Encode(password));
		student.setPoints(100);
		student.setFaceData(base64url);
		int i=logandregservice.register(student);
		System.out.println(character+"表记录+"+i);
		
		}else {
			
			Teacher teacher=new Teacher();
			teacher.setEmail(email);
			teacher.setName(nickname);
			teacher.setPassword(MD5Util.md5Encode(password));
			teacher.setPoints(100);
			int i=logandregservice.register(teacher);
			System.out.println(character+"表记录+"+i);
		
		}
		
		System.out.println("注册邮箱："+email);
		System.out.println("收到verifycode："+verifycode);
		System.out.println("角色："+character);
			
			
		return "1";
		
		
		
	
	}
	@PostMapping("/getverifyemail")
	@ResponseBody
	//HttpServletRequest req
	public String sendVerifyemail(
			String receiver,
			HttpSession session) throws MessagingException {
		
		System.out.println("getverifyemail接到访问请求");
		System.out.println("receiver:"+receiver);
		if(receiver != null) {
			String verifycode = "";
			for(int i=0; i<6; i++) {
				verifycode += (int)(Math.random()*10);
			}
			session.setAttribute("verifycode", verifycode);
			SendEmailUtils seu = new SendEmailUtils(receiver,verifycode);
			seu.mailSend();
			
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("email");
//			mav.addObject("emailSendMsg", "1");
			return "1";
		}else {
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("emailSendMsg", "0");
			return "0";
		}
		
	}
	
	
	/*
	 * 修改密码 0-密码错误 1 修改成功 2修改失败
	 */
	@PostMapping("/changePassword")
	@ResponseBody
	public String changePassword(String oldPassword,String newPassword,HttpServletRequest request) {
		String role=(String)request.getSession().getAttribute("role");
		String name=(String)request.getSession().getAttribute("name");
		int test=logandregservice.checkUser(name, MD5Util.md5Encode(oldPassword));
		if(test==0) {
			return "0";
		}else {
			Boolean i=logandregservice.changePassword(role, name, newPassword);
			if(i) {
				return "1";
			}
			return "2";
			
		}
	
	}

}
