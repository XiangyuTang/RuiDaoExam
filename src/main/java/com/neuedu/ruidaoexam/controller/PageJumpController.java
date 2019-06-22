package com.neuedu.ruidaoexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.QuestionBankService;
import com.neuedu.ruidaoexam.service.Trade_recordService;


@Controller
public class PageJumpController {
	@Autowired
	QuestionBankService questionBankService;
	@Autowired
	Trade_recordService trade_recordService;
	//这个controller测试放行静态资源的
	@RequestMapping("/to11")
	public String to111(){
		//System.out.println("f-----------------");
		return "11";
	}
	@RequestMapping("/test")
	public String test()
	{
		return "examOver";
	}
	
	//学生个人中心
	@RequestMapping("/toindex")
	public String toindex()
	{
		return "index";
	}

	//教师个人中心
	@RequestMapping("/toindexteacher")
	public String toindexteacher()
	{
		return "indexteacher";
	}
	
	@RequestMapping("/toinvite")
	public String toinvite()
	{
		return "invite";
	}
	
	//注册页
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "user/reg";
	}
	
	//登录页
	@RequestMapping("tologin")
	public String toLogin() {
		return "user/login";
	}
	
	@RequestMapping("/toshoudong")
	public String toshoudong(Model model) {
		//此处的teacher_id应该是session中的内容
		List<QuestionBank> questionBanks = questionBankService.getQusetionBankByTeacherid(1);
		List<QuestionBank> questionBanks2 = trade_recordService.getQusetionBankByTeacherid(1);
		for (QuestionBank questionbank:questionBanks2) {
			questionBanks.add(questionbank);
		}
		for(QuestionBank questionBank:questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
		model.addAttribute("questionbanks",questionBanks);
		model.addAttribute("test", "我被取用了");
		return "shoudongzujuan";
	}
	
	@RequestMapping("/toentrance")
	public String toentercode() {
		
		return "examEntrance";
	}
	
	@RequestMapping("/toquestion1")
	public String toquestion() {
		System.out.println("我被调了");
		return "news";
	}
	//主页
	@RequestMapping("/tohomePage")
	public String tohomepage(){
		return "user/homePage";
	}
	//教师主页(展示/欢迎页)
	@RequestMapping("/toteacherhome")
	public String toteacherhome(){
		return "teacher/teacherhome";
	}
	
	//考试页
	@RequestMapping("/toexam")
	public String toexam(){
		return "examing";
	}
}
