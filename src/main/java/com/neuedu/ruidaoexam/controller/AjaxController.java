package com.neuedu.ruidaoexam.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.ruidaoexam.service.impl.QuestionServiceimpl;

@RestController
public class AjaxController {
	@Autowired
	QuestionServiceimpl questionServiceimpl;
	
	//通过bank_id查询其所属的所有题目并返回前端
	@RequestMapping("/toquestion")
	public Map<String, List<Object>> test(){
		questionServiceimpl.getQuestionByBankid(2);
		return null;
	}
}
