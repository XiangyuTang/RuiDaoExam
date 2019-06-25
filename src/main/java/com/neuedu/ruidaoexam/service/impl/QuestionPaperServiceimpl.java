package com.neuedu.ruidaoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.ChoiceQuestionMapper;
import com.neuedu.ruidaoexam.dao.EssayQuestionMapper;
import com.neuedu.ruidaoexam.dao.JudgeQuestionMapper;
import com.neuedu.ruidaoexam.dao.Ques_Paper_MapperMapper;
import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;
import com.neuedu.ruidaoexam.entity.Ques_Paper_MapperExample;
import com.neuedu.ruidaoexam.entity.Ques_Paper_MapperExample.Criteria;
import com.neuedu.ruidaoexam.service.QuestionPaperService;
@Service
public class QuestionPaperServiceimpl implements QuestionPaperService {

	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	
	@Autowired
	JudgeQuestionMapper judgeQuestionMapper;
	
	@Autowired
	EssayQuestionMapper essayQuestionMapper;
	
	@Autowired
	Ques_Paper_MapperMapper ques_Paper_MapperMapper;
	
	@Override
	public List<ChoiceQuestion> selectSingleChoice(Integer paper_id) {
		// TODO Auto-generated method stub
		int questype = 1;
		List<ChoiceQuestion> singleChoices = new ArrayList<ChoiceQuestion>();
		Ques_Paper_MapperExample example = new Ques_Paper_MapperExample();
		Criteria criteria = example.createCriteria();
		criteria.andPaperIdEqualTo(paper_id).andQuesTypeEqualTo(questype);
		List<Ques_Paper_Mapper> selectByExample = ques_Paper_MapperMapper.selectByExample(example);
		for(Ques_Paper_Mapper o : selectByExample)
		{
			System.out.println("单选题的id:"+o.getCqId());
			ChoiceQuestion cq = choiceQuestionMapper.selectByPrimaryKey(o.getCqId());
			cq.setScore(o.getScore());
			singleChoices.add(cq);
		}
		return singleChoices;
	}

	@Override
	public List<ChoiceQuestion> selectMultipleChoice(Integer paper_id) {
		// TODO Auto-generated method stub
		int questype = 2;
		List<ChoiceQuestion> multipleChoices = new ArrayList<ChoiceQuestion>();
		Ques_Paper_MapperExample example = new Ques_Paper_MapperExample();
		Criteria criteria = example.createCriteria();
		criteria.andPaperIdEqualTo(paper_id).andQuesTypeEqualTo(questype);
		List<Ques_Paper_Mapper> selectByExample = ques_Paper_MapperMapper.selectByExample(example);
		for(Ques_Paper_Mapper o : selectByExample)
		{
			System.out.println("多选题的id:"+o.getCqId());
			ChoiceQuestion cq = choiceQuestionMapper.selectByPrimaryKey(o.getCqId());
			cq.setScore(o.getScore());
			multipleChoices.add(cq);
		}
		return multipleChoices;
	}

	@Override
	public List<JudgeQuestion> selectJudge(Integer paper_id) {
		// TODO Auto-generated method stub
		int questype = 4;
		List<JudgeQuestion> JudgeChoices = new ArrayList<JudgeQuestion>();
		Ques_Paper_MapperExample example = new Ques_Paper_MapperExample();
		Criteria criteria = example.createCriteria();
		criteria.andPaperIdEqualTo(paper_id).andQuesTypeEqualTo(questype);
		List<Ques_Paper_Mapper> selectByExample = ques_Paper_MapperMapper.selectByExample(example);
		for(Ques_Paper_Mapper o : selectByExample)
		{
			System.out.println("判断题的id:"+o.getJqId());
			JudgeQuestion jq = judgeQuestionMapper.selectByPrimaryKey(o.getJqId());
			jq.setScore(o.getScore());
			JudgeChoices.add(jq);
		}
		return JudgeChoices;
	}

	@Override
	public List<EssayQuestion> selectFillBlank(Integer paper_id) {
		// TODO Auto-generated method stub
		int questype = 5;
		List<EssayQuestion> fillBlanks = new ArrayList<EssayQuestion>();
		Ques_Paper_MapperExample example = new Ques_Paper_MapperExample();
		Criteria criteria = example.createCriteria();
		criteria.andPaperIdEqualTo(paper_id).andQuesTypeEqualTo(questype);
		List<Ques_Paper_Mapper> selectByExample = ques_Paper_MapperMapper.selectByExample(example);
		for(Ques_Paper_Mapper o : selectByExample)
		{
			System.out.println("填空题的id:"+o.getEqId());
			EssayQuestion eq = essayQuestionMapper.selectByPrimaryKey(o.getEqId());
			eq.setScore(o.getScore());
			fillBlanks.add(eq);
		}
		return fillBlanks;
	}

	@Override
	public List<EssayQuestion> selectShortAnswer(Integer paper_id) {
		// TODO Auto-generated method stub
		int questype = 3;
		List<EssayQuestion> shortAnswers = new ArrayList<EssayQuestion>();
		Ques_Paper_MapperExample example = new Ques_Paper_MapperExample();
		Criteria criteria = example.createCriteria();
		criteria.andPaperIdEqualTo(paper_id).andQuesTypeEqualTo(questype);
		List<Ques_Paper_Mapper> selectByExample = ques_Paper_MapperMapper.selectByExample(example);
		for(Ques_Paper_Mapper o : selectByExample)
		{
			System.out.println("简答题的id:"+o.getEqId());
			EssayQuestion eq = essayQuestionMapper.selectByPrimaryKey(o.getEqId());
			eq.setScore(o.getScore());
			shortAnswers.add(eq);
		}
		return shortAnswers;
	}

}
