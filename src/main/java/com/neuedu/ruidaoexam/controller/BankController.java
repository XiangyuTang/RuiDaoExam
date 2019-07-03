package com.neuedu.ruidaoexam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.service.QuestionBankService;
import com.neuedu.ruidaoexam.service.Trade_recordService;

@Controller
public class BankController {
	@Autowired
	QuestionBankService questionBankService;
	@Autowired
	Trade_recordService trade_recordService;
	
	@RequestMapping("/toMyBank")
	public String toMyBanks(Model model,HttpServletRequest request) {
		// 此处的teacher_id应该是session中的内容
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		List<QuestionBank> questionBanks = questionBankService.getQusetionBankByTeacherid(uid);
		List<QuestionBank> questionBanks2 = trade_recordService.getQusetionBankByTeacherid(uid);
		for (QuestionBank questionbank : questionBanks2) {
			questionBanks.add(questionbank);
		}
		model.addAttribute("banks", questionBanks);
		return "banks";
	}
	@RequestMapping("/addbank")
	@ResponseBody
	public String addBank(String bankname,Integer banktype,HttpServletRequest request) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		QuestionBank bank = new QuestionBank();
		bank.setCreatedbyteacherid(uid);
		bank.setQuesBankName(bankname);
		bank.setQuesBankFiled(banktype);
		bank.setPointPrice(0);
		Integer addQuestBank = questionBankService.addQuestBank(bank);
		if (addQuestBank > 0) {
			return "true";
		}else {
			return "false1";
		}
	}
}
