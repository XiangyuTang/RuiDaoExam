package com.neuedu.ruidaoexam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.entity.News;
import com.neuedu.ruidaoexam.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	NewsService newsService;
	@RequestMapping("/tonews")
	public String tonews(HttpServletRequest request,Model model) {
		String role = (String) request.getSession().getAttribute("role");
		Integer uid = (Integer) request.getSession().getAttribute("uid");
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWW");
//		System.out.println(role);
//		System.out.println(uid);
		if (role.equals("teacher")) {			
			List<News> teacherNews = newsService.getTeacherNews(uid);
//			for (News news:teacherNews) {
//				System.out.println(news.getNewsId());
//			}
			model.addAttribute("newslist", teacherNews);
		}else {
			List<News> studentNews = newsService.getStudentNews(uid);
			for (News news:studentNews) {
				System.out.println(news.getNewsId());
			}
			model.addAttribute("newslist", studentNews);
		}
		return "news";
	}
}
