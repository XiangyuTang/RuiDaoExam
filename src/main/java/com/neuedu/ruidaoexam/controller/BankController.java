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
public class BankController {
	@Autowired
	QuestionBankService questionBankService;
	@Autowired
	Trade_recordService trade_recordService;
	
	@RequestMapping("/toMyBank")
	public String toMyBanks(Model model) {
		// 此处的teacher_id应该是session中的内容
		List<QuestionBank> questionBanks = questionBankService.getQusetionBankByTeacherid(1);
		List<QuestionBank> questionBanks2 = trade_recordService.getQusetionBankByTeacherid(1);
		for (QuestionBank questionbank : questionBanks2) {
			questionBanks.add(questionbank);
		}
		model.addAttribute("banks", questionBanks);
		return "banks";
	}
}
