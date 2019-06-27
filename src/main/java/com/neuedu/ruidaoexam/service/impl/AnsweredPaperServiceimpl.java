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
	public int insert(AnsweredPaper ap) {
		// TODO Auto-generated method stub
		 int i = answeredPaperMapper.insert(ap);
		 return i;
	}

	@Override
	public Integer selectPrimeKey(AnsweredPaper answerpaper) {
		// TODO Auto-generated method stub
		int i = answeredPaperMapper.selectPrimeKey(answerpaper.getStuId(),answerpaper.getPaperId());
		return i;
	}
	
}
