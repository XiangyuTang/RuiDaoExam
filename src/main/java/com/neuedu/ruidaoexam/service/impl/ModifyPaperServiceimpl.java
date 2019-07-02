package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.AnsweredQuestionMapper;
import com.neuedu.ruidaoexam.dao.ChoiceQuestionMapper;
import com.neuedu.ruidaoexam.dao.JudgeQuestionMapper;
import com.neuedu.ruidaoexam.dao.ReportMapper;
import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.service.ModifyPaperService;


@Service
public class ModifyPaperServiceimpl implements ModifyPaperService{

	@Autowired
	ReportMapper reportMapper;
	
	@Autowired
	AnsweredQuestionMapper answeredQuestionMapper;
	
	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	
	@Autowired
	JudgeQuestionMapper judgeQuestionMapper;
	
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
	public void modifyChoiceQue(int reportId, int acquireScore, int answerPaperId, int quesId, String rightAns, int score,
			int isCorrect) {
		// TODO Auto-generated method stub
		System.out.println("ldhfasdfhalflajflaskjflsafjalskfjaljfaklfjlkjfldsjflk");
		Report r = new Report();
		r.setReportId(reportId);
		r.setAcquiredScore(acquireScore);
		System.out.println("dddddddddddddddddddddddddddddddddd"+r.getAcquiredScore());
		reportMapper.updateByPrimaryKeySelective(r);
		System.out.println("111111111111111111111111111111111");
		answeredQuestionMapper.updateChoiceQuestionIsCorrect(isCorrect, score, answerPaperId, quesId);
		answeredQuestionMapper.updateChoiceQuestionIsCorrectAnswer(characterToBinary(rightAns), answerPaperId, quesId);
		System.out.println("2222222222222222222222222222222222222");
		ChoiceQuestion cq = new ChoiceQuestion();
		cq.setChoiceQuesId(quesId);
		cq.setAnswer(characterToBinary(rightAns));
		choiceQuestionMapper.updateByPrimaryKeySelective(cq);
	}

	@Override
	public void modifyJudgeQue(int reportId, int acquireScore, int answerPaperId, int quesId, String rightAns, int score,
			int isCorrect) {
		// TODO Auto-generated method stub
		Report r = new Report();
		r.setReportId(reportId);
		r.setAcquiredScore(acquireScore);
		reportMapper.updateByPrimaryKeySelective(r);
		System.out.println("score地值时============"+score);
		answeredQuestionMapper.updateJudgeQuestionIsCorrect(isCorrect, score, answerPaperId, quesId);
		int panduaAnswer = 0;
		if(rightAns.equals("A")||rightAns.equals("a")) {
			panduaAnswer = 1;
		}else if(rightAns.equals("B")||rightAns.equals("b")){
			panduaAnswer = 0;
		}else {
			System.out.println("输入错误");
		}
		answeredQuestionMapper.updateJudgeQuestionIsCorrectAnswer(panduaAnswer, answerPaperId, quesId);
		JudgeQuestion jq = new JudgeQuestion();
		jq.setJudgeId(quesId);
		jq.setAnswer(panduaAnswer);
		judgeQuestionMapper.updateByPrimaryKeySelective(jq);
	}

	@Override
	public void modifyEssayQue(int reportId, int acquireScore, int answerPaperId, int quesId, int score,
			int isCorrect) {
		// TODO Auto-generated method stub
		Report r = new Report();
		r.setReportId(reportId);
		r.setAcquiredScore(acquireScore);
		reportMapper.updateByPrimaryKeySelective(r);
		answeredQuestionMapper.updateEssayQuestionIsCorrect(isCorrect, score, answerPaperId, quesId);
		
	}
	
	

}
