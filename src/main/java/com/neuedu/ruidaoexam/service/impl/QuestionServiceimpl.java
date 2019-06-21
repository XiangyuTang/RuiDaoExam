package com.neuedu.ruidaoexam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.ChoiceQuestionMapper;
import com.neuedu.ruidaoexam.dao.EssayQuestionMapper;
import com.neuedu.ruidaoexam.dao.JudgeQuestionMapper;
import com.neuedu.ruidaoexam.dao.Ques_Bank_MapperMapper;
import com.neuedu.ruidaoexam.entity.Ques_Bank_Mapper;
import com.neuedu.ruidaoexam.entity.Ques_Bank_MapperExample;
import com.neuedu.ruidaoexam.entity.Ques_Bank_MapperExample.Criteria;
import com.neuedu.ruidaoexam.service.QuestionService;
@Service
public class QuestionServiceimpl implements QuestionService {
	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	@Autowired
	JudgeQuestionMapper judgeQuestionMapper;
	@Autowired
	EssayQuestionMapper essayQuestionMapper;
	@Autowired
	Ques_Bank_MapperMapper ques_Bank_MapperMapper;
	
	//通过题库的id查询其包含的题目集合
	@Override
	public HashMap<String, List<Object>> getQuestionByBankid(Integer Bank_id) {
		Ques_Bank_MapperExample ques_Bank_MapperExample = new Ques_Bank_MapperExample();
		Criteria createCriteria = ques_Bank_MapperExample.createCriteria();
		createCriteria.andBankIdEqualTo(2);
		List<Ques_Bank_Mapper> ques_Bank_Mappers = ques_Bank_MapperMapper.selectByExample(ques_Bank_MapperExample);
		List<Integer> choice_id_list = new ArrayList<Integer>();
		List<Integer> essay_id_list = new ArrayList<Integer>();
		List<Integer> judge_id_list = new ArrayList<Integer>();
		for (Ques_Bank_Mapper ques_Bank_Mapper:ques_Bank_Mappers) {
			Integer quesType = ques_Bank_Mapper.getQuesType();
			if (quesType == 1 || quesType == 2) {
				System.out.println(ques_Bank_Mapper.getCqId());
				choice_id_list.add(ques_Bank_Mapper.getCqId());
			}else if (quesType == 4) {
				System.out.println(ques_Bank_Mapper.getJqId());
				judge_id_list.add(ques_Bank_Mapper.getJqId());
			}else {
				System.out.println(ques_Bank_Mapper.getEqId());
				essay_id_list.add(ques_Bank_Mapper.getEqId());
			}
		}
		return null;
	}

}
