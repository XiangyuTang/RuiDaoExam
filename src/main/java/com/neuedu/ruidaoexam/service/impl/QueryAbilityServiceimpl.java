package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.AnsweredQuestionMapper;
import com.neuedu.ruidaoexam.service.QueryAbilityService;
@Service
public class QueryAbilityServiceimpl implements QueryAbilityService {

	@Autowired
	AnsweredQuestionMapper answeredQuestionMapper;
	
	@Override
	public Integer getTotalRightQues(Integer stu_id, Integer ques_type) {
		// TODO Auto-generated method stub
		int i = answeredQuestionMapper.getTotalRightQues(stu_id, ques_type);
		return i;
	}

	@Override
	public Integer getTotalQues(Integer stu_id, Integer ques_type) {
		// TODO Auto-generated method stub
		int i = answeredQuestionMapper.getTotalQues(stu_id, ques_type);
		return i;
	}

}
