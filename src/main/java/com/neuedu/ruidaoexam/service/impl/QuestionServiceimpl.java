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
import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
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
	public HashMap<String, Object> getQuestionByBankid(Integer Bank_id) {
		Ques_Bank_MapperExample ques_Bank_MapperExample = new Ques_Bank_MapperExample();
		Criteria createCriteria = ques_Bank_MapperExample.createCriteria();
		createCriteria.andBankIdEqualTo(Bank_id);
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
		HashMap<String, Object> questionHashMap = new HashMap<>();
		if (!choice_id_list.isEmpty()) {
			List<ChoiceQuestion> choiceQuestions = choiceQuestionMapper.selectByidInList(choice_id_list);
			questionHashMap.put("choiceQuestions", choiceQuestions);
		}else {
			questionHashMap.put("choiceQuestions", choice_id_list);
		}
		if (!judge_id_list.isEmpty()) {
			List<JudgeQuestion> judgeQuestions = judgeQuestionMapper.selectByidInList(judge_id_list);
			questionHashMap.put("judgeQuestions", judgeQuestions);
		}else {
			questionHashMap.put("judgeQuestions", judge_id_list);
		}
		if (!essay_id_list.isEmpty()) {
			List<EssayQuestion> essayQuestions = essayQuestionMapper.selectByidInList(essay_id_list);
			questionHashMap.put("essayQuestions", essayQuestions);
		}else {
			questionHashMap.put("essayQuestions", essay_id_list);
		}
		/*
		 * List<ChoiceQuestion> choiceQuestions =
		 * choiceQuestionMapper.selectByidInList(choice_id_list); List<JudgeQuestion>
		 * judgeQuestions = judgeQuestionMapper.selectByidInList(judge_id_list);
		 * List<EssayQuestion> essayQuestions =
		 * essayQuestionMapper.selectByidInList(essay_id_list);
		 * questionHashMap.put("choiceQuestions", choiceQuestions);
		 * questionHashMap.put("judgeQuestions", judgeQuestions);
		 * questionHashMap.put("essayQuestions", essayQuestions);
		 */
//		for (JudgeQuestion judgeQuestion:judgeQuestions) {
//		System.out.println(judgeQuestion.getContent());
//	}
//		for (EssayQuestion essayQuestion:essayQuestions) {
//			System.out.println(essayQuestion.getContent());
//		}
		return questionHashMap;
	}

	@Override
	public List<Object> getQuestionsByBankid(Integer Bank_id) {
		Ques_Bank_MapperExample ques_Bank_MapperExample = new Ques_Bank_MapperExample();
		Criteria createCriteria = ques_Bank_MapperExample.createCriteria();
		createCriteria.andBankIdEqualTo(Bank_id);
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
		List<Object> questions = new ArrayList<Object>();
		if (!choice_id_list.isEmpty()) {
			List<ChoiceQuestion> choiceQuestions = choiceQuestionMapper.selectByidInList(choice_id_list);
			questions.addAll(choiceQuestions);
		}else {
		}
		if (!judge_id_list.isEmpty()) {
			List<JudgeQuestion> judgeQuestions = judgeQuestionMapper.selectByidInList(judge_id_list);
			questions.addAll(judgeQuestions);
		}else {
		}
		if (!essay_id_list.isEmpty()) {
			List<EssayQuestion> essayQuestions = essayQuestionMapper.selectByidInList(essay_id_list);
			questions.addAll(essayQuestions);
		}else {
		}
		return questions;
	}

//	@Override
//	public List<ChoiceQuestion> getChoiceQuestionsInList(List<Integer> idList) {
//		List<ChoiceQuestion> choiceQuestionsInList = choiceQuestionMapper.getChoiceQuestionsInList(idList);
//		return choiceQuestionsInList;
//	}

}
