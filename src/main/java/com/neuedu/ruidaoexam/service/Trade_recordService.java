package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.QuestionBank;

public interface Trade_recordService {
	//通过老师的id查询其购买的题库
	List<QuestionBank> getQusetionBankByTeacherid(Integer Teacher_id); 
}
