package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.QuestionBank;

public interface QuestionBankService {
	//通过老师id查询其创建的题库
	List<QuestionBank> getQusetionBankByTeacherid(Integer Teacher_id);
	//删除题库
	int deleteBankByBankId(Integer Bank_id);
}
