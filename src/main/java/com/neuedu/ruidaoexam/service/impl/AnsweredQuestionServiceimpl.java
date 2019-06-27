package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.AnsweredQuestionMapper;
import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.service.AnsweredQuestionService;
@Service
public class AnsweredQuestionServiceimpl implements AnsweredQuestionService {
	
	@Autowired
	AnsweredQuestionMapper answeredQuestionMapper;
	
	@Override
	public int update(AnsweredQuestion aq) {
		// TODO Auto-generated method stub
		int i = answeredQuestionMapper.updateAndInsert(aq);
		return i;
	}
	
	@Override
	public int selectPrimeKey(AnsweredQuestion aq) {
		// TODO Auto-generated method stub
		Integer i = 0;
		if(aq.getQuesType()==1||aq.getQuesType()==2)
		{
			i = answeredQuestionMapper.selectPrimeKey(aq.getPaperResultId(),aq.getQuesType(),aq.getCqId());
		}
		else if(aq.getQuesType()==4)
		{
			i = answeredQuestionMapper.selectPrimeKey(aq.getPaperResultId(),aq.getQuesType(),aq.getJqId());
		}
		else
		{
			i = answeredQuestionMapper.selectPrimeKey(aq.getPaperResultId(),aq.getQuesType(),aq.getEqId());
		}
		return i;
	}
	
}
