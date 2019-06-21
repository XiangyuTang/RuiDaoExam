package com.neuedu.ruidaoexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.PaperService;
import com.neuedu.ruidaoexam.service.Trade_recordService;


@Controller
public class PageJumpController {
	@Autowired
	PaperService paperService;
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
	
	@RequestMapping("/toindex")
	public String toindex()
	{
		return "index";
	}

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
		List<QuestionBank> questionBanks = paperService.getQusetionBankByTeacherid(1);
		List<QuestionBank> questionBanks2 = trade_recordService.getQusetionBankByTeacherid(1);
		for (QuestionBank questionbank:questionBanks2) {
			questionBanks.add(questionbank);
		}
		for(QuestionBank questionBank:questionBanks) {
			System.out.println(questionBank.getQuesBankName());
		}
		return "shoudongzujuan";
	}
	
	@RequestMapping("/toentercode")
	public String toentercode() {
		
		return "examEntrance";
	}
	
}
