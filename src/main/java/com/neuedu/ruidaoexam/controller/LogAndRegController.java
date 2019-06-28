package com.neuedu.ruidaoexam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.ruidaoexam.configUtils.MD5Util;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.service.LogAndRegService;
import com.neuedu.ruidaoexam.service.StudentService;
import com.neuedu.ruidaoexam.service.TeacherService;

//登录注册controller
@Controller
public class LogAndRegController {
	   @Autowired StudentService studentservice;
	   @Autowired TeacherService teacherservice;
	   @Autowired LogAndRegService larservice;
	   /*
		 * 方法：提交登录
		 * 详细：参数-邮箱/用户名，密码，验证码
		 * 返回：1老师登录，2学生，3验证码错误，0用户名密码错误
		 */
		@RequestMapping("/loginsubmit")
		@ResponseBody
		public String loginsubmit(String username,String password,String check_code,
				HttpServletRequest request) {
			String oldcheck_code = String.valueOf(request.getSession().getAttribute("check_code"));
			System.out.println("code:"+oldcheck_code+","+check_code);
			if(!check_code.equals(oldcheck_code)) {
				return "3";
			}
			if(larservice.login(username, MD5Util.md5Encode(password)) == 1) {
				request.getSession().setAttribute("role", "teacher");
				Teacher teacher =  (Teacher) larservice.getUser(username, MD5Util.md5Encode(password));
				request.getSession().setAttribute("uid", teacher.getTeacherId());
				request.getSession().setAttribute("name", teacher.getName());
				return "1";
			}else if(larservice.login(username, MD5Util.md5Encode(password)) == 2) {
				request.getSession().setAttribute("role", "student");
				Student student =  (Student) larservice.getUser(username, MD5Util.md5Encode(password));
				request.getSession().setAttribute("uid", student.getStudentId());
				request.getSession().setAttribute("name", student.getName());
				return "2";
			}else {
				return "0";
			}
			
		}

		/*
		 * 方法：获得当前用户
		 * 详细：读取session中的role（角色），id，name放在json返回给用户
		 * 返回：role，id，name的json
		 */
		@RequestMapping("/getCurrentUser")
		@ResponseBody
		public String getCurrentUser(HttpServletRequest request) {
			HttpSession session = request.getSession();
			JSONObject json = new JSONObject();
			json.put("role",session.getValue("role"));
			json.put("uid",session.getValue("uid"));
			json.put("name",session.getValue("name"));
			String jsonstr = JSON.toJSONString(json);
			return jsonstr;
		}
		/*
		 * 修改密码 0-密码错误 1 修改成功 2修改失败
		 */
		/*
		 * 方法：找回密码
		 * 详细：根据传入密码，修改该邮箱的密码
		 * 返回： 0-密码错误 1 修改成功 2修改失败
		 */
		@PostMapping("/setPassword")
		@ResponseBody
		public String setPassword(String username,String newPassword,HttpServletRequest request) {
			String role=(String)request.getSession().getAttribute("role");
			String name=(String)request.getSession().getAttribute("name");
			System.out.println("setPassword此时："+username+","+newPassword+","+larservice.getUserType(username));
				Boolean i=larservice.changePassword(larservice.getUserType(username), username, newPassword);
				if(i) {
					return "1";
				}
				return "2";
		
		}
		
}
