package com.neuedu.ruidaoexam.service.impl;

import java.util.ArrayList;

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
import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;
import com.neuedu.ruidaoexam.service.addQuestionService;

@Service
public class addQuestionServiceimpl implements addQuestionService{
	
	@Autowired
	JudgeQuestionMapper judgeQuestionMapper;
	
	@Autowired
	EssayQuestionMapper essayQuestionMapper;
	
	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	
	@Autowired
	Ques_Bank_MapperMapper ques_Bank_MapperMapper;
	
	@Override
	public String characterToBinary(String character) {
		// TODO Auto-generated method stub
		System.out.println("lllllllllllllllll"+character);
		String first = "0";
		String Second = "0";
		String Third = "0";
		String Fourth = "0";
		String result = null;
		if(character.indexOf("A")!=(-1)||character.indexOf("a")!=(-1)) {
			first="1";
		}
		if(character.indexOf("B")!=(-1)||character.indexOf("b")!=(-1)) {
			Second = "1";
		}
		if(character.indexOf("C")!=(-1)||character.indexOf("c")!=(-1)) {
			Third = "1";
		}
		if(character.indexOf("D")!=(-1)||character.indexOf("d")!=(-1)) {
			Fourth ="1";
		}
		result = first+" "+Second+" "+Third+" "+Fourth;
		System.out.println("jkjjkjkjkjkjjkjkjkjjjkj"+result);
		return result;
	}

	@Override
	public void addChoiceQuestion(ArrayList<String> questionsArray, int bank_id) {
		// TODO Auto-generated method stub
		ChoiceQuestion cq = new ChoiceQuestion();
		cq.setQuesTypeId(Integer.parseInt(questionsArray.get(0)));
		cq.setContent(questionsArray.get(1));
		cq.setChoice1(questionsArray.get(2));
		cq.setChoice2(questionsArray.get(3));
		cq.setChoice3(questionsArray.get(4));
		cq.setChoice4(questionsArray.get(5));
		cq.setAnswer(characterToBinary(questionsArray.get(6)));
		cq.setDifficulty(Integer.parseInt(questionsArray.get(7)));
		cq.setAnalysis(questionsArray.get(8));
		cq.setAbilityTypeId(Integer.parseInt(questionsArray.get(9)));
		//choiceQuestionMapper.insertSelective(cq);
		choiceQuestionMapper.insertAndGetId(cq);
		int question_id = cq.getChoiceQuesId();
		addQues_Bank_Mapper(bank_id,Integer.parseInt(questionsArray.get(0)),question_id);
	}

	@Override
	public void addEssayQuestion(ArrayList<String> questionsArray, int bank_id) {
		// TODO Auto-generated method stub
		EssayQuestion eq = new EssayQuestion();
		eq.setQuesTypeId(Integer.parseInt(questionsArray.get(0)));
		eq.setContent(questionsArray.get(1));
		eq.setAnswer(questionsArray.get(2));
		System.out.println("setDifficultsetDifficultsetDifficult"+Integer.parseInt(questionsArray.get(3)));
		eq.setDifficulty(Integer.parseInt(questionsArray.get(3)));
		eq.setAbilityTypeId(Integer.parseInt(questionsArray.get(4)));
		//essayQuestionMapper.insertSelective(eq);
		essayQuestionMapper.insertAndGetId(eq);
		System.out.println("ididididididididididdidididi"+eq.getQuesAnsId());
		int question_id = eq.getQuesAnsId();
		addQues_Bank_Mapper(bank_id,Integer.parseInt(questionsArray.get(0)),question_id);
	}

	@Override
	public void addJudgeQuestion(ArrayList<String> questionsArray, int bank_id) {
		// TODO Auto-generated method stub
		JudgeQuestion jq = new JudgeQuestion();
		jq.setQuesTypeId(Integer.parseInt(questionsArray.get(0)));
		jq.setContent(questionsArray.get(1));
		if(questionsArray.get(2).equals("A")||questionsArray.get(2).equals("a")) {
			jq.setAnswer(1);
		}else{
			jq.setAnswer(0);
		}
		jq.setDifficulty(Integer.parseInt(questionsArray.get(3)));
		jq.setAbilityTypeId(Integer.parseInt(questionsArray.get(4)));
		//judgeQuestionMapper.insertSelective(jq);
		judgeQuestionMapper.insertAndGetId(jq);
		int question_id = jq.getJudgeId();
		addQues_Bank_Mapper(bank_id,Integer.parseInt(questionsArray.get(0)),question_id);
	}

	@Override
	public void addQues_Bank_Mapper(int bank_id,int question_type, int question_id) {
		// TODO Auto-generated method stub
		Ques_Bank_Mapper qbk = new Ques_Bank_Mapper();
		if(question_type==1||question_type==2) {
			qbk.setBankId(bank_id);
			qbk.setQuesType(question_type);
			qbk.setCqId(question_id);
			qbk.setEqId(null);
			qbk.setJqId(null);
			ques_Bank_MapperMapper.insertSelective(qbk);
			
		}else if(question_type==3||question_type==5){
			qbk.setBankId(bank_id);
			qbk.setQuesType(question_type);
			qbk.setCqId(null);
			qbk.setEqId(question_id);
			qbk.setJqId(null);
			ques_Bank_MapperMapper.insertSelective(qbk);
		}else{
			qbk.setBankId(bank_id);
			qbk.setQuesType(question_type);
			qbk.setCqId(null);
			qbk.setEqId(null);
			qbk.setJqId(question_id);
			ques_Bank_MapperMapper.insertSelective(qbk);
		}
	}

}
