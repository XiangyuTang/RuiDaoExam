package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.QuestionBank;

public interface Trade_recordService {
	List<QuestionBank> getQusetionBankByTeacherid(Integer Teacher_id); 
}
