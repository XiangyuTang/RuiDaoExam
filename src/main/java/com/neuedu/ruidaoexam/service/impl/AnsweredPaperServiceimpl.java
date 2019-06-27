package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.AnsweredPaperMapper;
import com.neuedu.ruidaoexam.entity.AnsweredPaper;
import com.neuedu.ruidaoexam.service.AnsweredPaperService;

@Service
public class AnsweredPaperServiceimpl implements AnsweredPaperService {
	
	@Autowired
	AnsweredPaperMapper answeredPaperMapper;
	
	@Override
	public void insert(AnsweredPaper ap) {
		// TODO Auto-generated method stub
		answeredPaperMapper.insert(ap);
	}
	
}
