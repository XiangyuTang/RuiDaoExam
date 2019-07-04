package com.neuedu.ruidaoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.ChoiceQuestionMapper;
import com.neuedu.ruidaoexam.dao.EssayQuestionMapper;
import com.neuedu.ruidaoexam.dao.JudgeQuestionMapper;
import com.neuedu.ruidaoexam.dao.Ques_Paper_MapperMapper;
import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.ForChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForJudgeQuestion;
import com.neuedu.ruidaoexam.entity.ForTianKongQuestion;
import com.neuedu.ruidaoexam.entity.ForWenDaQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;
import com.neuedu.ruidaoexam.entity.Ques_Paper_Mapper;
import com.neuedu.ruidaoexam.service.PreviewService;

@Service
public class PreviewServiceimpl implements PreviewService{
	
	@Autowired
	Ques_Paper_MapperMapper ques_Paper_MapperMapper;
	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	@Autowired
	JudgeQuestionMapper judgeQuestionMapper;
	@Autowired
	EssayQuestionMapper essayQuestionMapper;
	
	public ArrayList<String> getNum(int paper_id) {
		
		Integer getXuanZeNum = ques_Paper_MapperMapper.countXuanZeNum(paper_id); 
		Integer getPanDuanNum = ques_Paper_MapperMapper.countPanDuanNum(paper_id); 
		Integer getTianKongNum = ques_Paper_MapperMapper.countTianKongNum(paper_id); 
		Integer getWenDaNum = ques_Paper_MapperMapper.countWenDaNum(paper_id); 
		
		ArrayList<String> getNumList = new ArrayList<>();
		getNumList.add(Integer.toString(getXuanZeNum));
		getNumList.add(Integer.toString(getPanDuanNum));
		getNumList.add(Integer.toString(getTianKongNum));
		getNumList.add(Integer.toString(getWenDaNum));
		
		return getNumList;
		
	}
	
	
	@Override
	public ArrayList<ForChoiceQuestion> getXuanZe(int paper_id) {

		List<Ques_Paper_Mapper> getXuanZeList = ques_Paper_MapperMapper.selectXuanZeByPaperId(paper_id);
		if (getXuanZeList.size()==0) {
			return null;
		}
		
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (Ques_Paper_Mapper id:getXuanZeList) {
			
			idList.add(id.getCqId());
			
		}
		
		List<ChoiceQuestion> choiceQuestionsInList = choiceQuestionMapper.getChoiceQuestionsInList(idList);
		ArrayList<ForChoiceQuestion> forChoiceQuestionInList = new ArrayList<ForChoiceQuestion>();
		for (ChoiceQuestion cho:choiceQuestionsInList) {
			
			ForChoiceQuestion forChoiceQuestion = new ForChoiceQuestion();
			
			String getRightAnswerString = cho.getAnswer();
			String rightAnswer = null;
			switch (getRightAnswerString) {
			case "1 0 0 0":
				rightAnswer = "A";
				break;
			case "0 1 0 0":
				rightAnswer = "B";
				break;
			case "0 0 1 0":
				rightAnswer = "C";
				break;
			case "0 0 0 1":
				rightAnswer = "D";
				break;
			case "1 1 0 0":
				rightAnswer = "AB";
				break;
			case "1 0 1 0":
				rightAnswer = "AC";
				break;
			case "1 0 0 1":
				rightAnswer = "AD";
				break;
			case "0 1 1 0":
				rightAnswer = "BC";
				break;
			case "0 1 0 1":
				rightAnswer = "BD";
				break;
			case "0 0 1 1":
				rightAnswer = "CD";
				break;
			case "1 1 1 0":
				rightAnswer = "ABC";
				break;
			case "1 1 0 1":
				rightAnswer = "ABD";
				break;
			case "1 0 1 1":
				rightAnswer = "ACD";
				break;
			case "0 1 1 1":
				rightAnswer = "BCD";
				break;
			case "1 1 1 1":
				rightAnswer = "ABCD";
				break;
			}
			forChoiceQuestion.setRightAnswer(rightAnswer);
			
			forChoiceQuestion.setChoiceQuesId(cho.getChoiceQuesId());
			forChoiceQuestion.setQuesTypeId(cho.getQuesTypeId());
			forChoiceQuestion.setContent(cho.getContent());
			forChoiceQuestion.setChoice1(cho.getChoice1());
			forChoiceQuestion.setChoice2(cho.getChoice2());
			forChoiceQuestion.setChoice3(cho.getChoice3());
			forChoiceQuestion.setChoice4(cho.getChoice4());
			Integer abilityTypeId = cho.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forChoiceQuestion.setAbilityType(abilityType);
			
			forChoiceQuestionInList.add(forChoiceQuestion);
		}
		
		int index  = 0;
		for (Ques_Paper_Mapper xuan:getXuanZeList) {
			
			ForChoiceQuestion forChoiceQuestion = forChoiceQuestionInList.get(index);
			
			Integer score = Integer.parseInt(xuan.getScore());
			forChoiceQuestion.setScore(score);
			index++;
		}
		
		int i = forChoiceQuestionInList.size();
		for (int j = 0; j < i; j++) {
			System.out.println("pppppppppppppppppppppppppppppppp" + forChoiceQuestionInList.get(j).getContent());
			System.out.println("pppppppppppppppppppppppppppppppp" + forChoiceQuestionInList.get(j).getScore());
		}
		
		return forChoiceQuestionInList;
	}

	@Override
	public ArrayList<ForJudgeQuestion> getPanDuan(int paper_id) {
		List<Ques_Paper_Mapper> getPanDuanList = ques_Paper_MapperMapper.selectPanDuanByPaperId(paper_id);
		if (getPanDuanList.size()==0) {
			return null;
		}
		
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (Ques_Paper_Mapper id:getPanDuanList) {
			
			idList.add(id.getJqId());
			
		}
		
		List<JudgeQuestion> judgeQuestionsInList = judgeQuestionMapper.getJudgeQuestionsInList(idList);
		ArrayList<ForJudgeQuestion> forJudgeQuestionsInList = new ArrayList<ForJudgeQuestion>();
		for (JudgeQuestion ju:judgeQuestionsInList) {
			
			ForJudgeQuestion forJudgeQuestion = new ForJudgeQuestion();
			
			Integer getRightAnswerString = ju.getAnswer();
			String rightAnswer = null;
			switch (getRightAnswerString) {
			case 1:
				rightAnswer = "A";
				break;
			case 0:
				rightAnswer = "B";
				break;
			}
			String choice1 = "正确";
			String choice2 = "错误";
			forJudgeQuestion.setRightAnswer(rightAnswer);
			
			forJudgeQuestion.setJudgeQuesId(ju.getJudgeId());
			forJudgeQuestion.setQuesTypeId(ju.getQuesTypeId());
			forJudgeQuestion.setContent(ju.getContent());
			forJudgeQuestion.setChoice1(choice1);
			forJudgeQuestion.setChoice2(choice2);
			Integer abilityTypeId = ju.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forJudgeQuestion.setAbilityType(abilityType);
			
			forJudgeQuestionsInList.add(forJudgeQuestion);
		}
		
		int index  = 0;
		for (Ques_Paper_Mapper pan:getPanDuanList) {
			
			ForJudgeQuestion forJudgeQuestion = forJudgeQuestionsInList.get(index);
			
			Integer score = Integer.parseInt(pan.getScore());
			forJudgeQuestion.setScore(score);
			index++;
		}
		
		int i = forJudgeQuestionsInList.size();
		for (int j = 0; j < i; j++) {
			System.out.println("pppppppppppppppppppppppppppppppp" + forJudgeQuestionsInList.get(j).getContent());
			System.out.println("pppppppppppppppppppppppppppppppp" + forJudgeQuestionsInList.get(j).getScore());
		}
		
		return forJudgeQuestionsInList;
	}


	@Override
	public ArrayList<ForTianKongQuestion> getTianKong(int paper_id) {
		List<Ques_Paper_Mapper> getTianKongList = ques_Paper_MapperMapper.selectTianKongByPaperId(paper_id);
		if (getTianKongList.size()==0) {
			return null;
		}
		
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (Ques_Paper_Mapper id:getTianKongList) {
			
			idList.add(id.getEqId());
			
		}
		
		List<EssayQuestion> essayQuestionsInList = essayQuestionMapper.getTianKongQuestionsInList(idList);
		ArrayList<ForTianKongQuestion> forTianKongQuestionsInList = new ArrayList<ForTianKongQuestion>();
		for (EssayQuestion ess:essayQuestionsInList) {
			
			ForTianKongQuestion forTianKongQuestion = new ForTianKongQuestion();
			
			forTianKongQuestion.setRightAnswer(ess.getAnswer());
			
			forTianKongQuestion.setTianKongQuesId(ess.getQuesAnsId());
			forTianKongQuestion.setQuesTypeId(ess.getQuesTypeId());
			forTianKongQuestion.setContent(ess.getContent());
			Integer abilityTypeId = ess.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forTianKongQuestion.setAbilityType(abilityType);
			
			forTianKongQuestionsInList.add(forTianKongQuestion);
		}
		
		int index  = 0;
		for (Ques_Paper_Mapper tian:getTianKongList) {
			
			ForTianKongQuestion forTianKongQuestion = forTianKongQuestionsInList.get(index);
			
			Integer score = Integer.parseInt(tian.getScore());
			forTianKongQuestion.setScore(score);
			index++;
		}
		
		int i = forTianKongQuestionsInList.size();
		for (int j = 0; j < i; j++) {
			System.out.println("pppppppppppppppppppppppppppppppp" + forTianKongQuestionsInList.get(j).getContent());
			System.out.println("pppppppppppppppppppppppppppppppp" + forTianKongQuestionsInList.get(j).getScore());
		}
		
		return forTianKongQuestionsInList;
	}


	@Override
	public ArrayList<ForWenDaQuestion> getWenDa(int paper_id) {
		List<Ques_Paper_Mapper> getWenDaList = ques_Paper_MapperMapper.selectWenDaByPaperId(paper_id);
		if (getWenDaList.size()==0) {
			return null;
		}
		
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (Ques_Paper_Mapper id:getWenDaList) {
			
			idList.add(id.getEqId());
			
		}
		
		List<EssayQuestion> essayQuestionsInList = essayQuestionMapper.getWenDaQuestionsInList(idList);
		ArrayList<ForWenDaQuestion> forWenDaQuestionsInList = new ArrayList<ForWenDaQuestion>();
		for (EssayQuestion ess:essayQuestionsInList) {
			
			ForWenDaQuestion forWenDaQuestion = new ForWenDaQuestion();
			
			forWenDaQuestion.setRightAnswer(ess.getAnswer());
			
			forWenDaQuestion.setWenDaQuesId(ess.getQuesAnsId());
			forWenDaQuestion.setQuesTypeId(ess.getQuesTypeId());
			forWenDaQuestion.setContent(ess.getContent());
			Integer abilityTypeId = ess.getAbilityTypeId();
			String abilityType = null;
			switch (abilityTypeId) {
			case 1:
				abilityType = "表达能力";
				break;
			case 2:
				abilityType = "理解能力";
				break;
			case 3:
				abilityType = "思辨能力";
				break;
			case 4:
				abilityType = "速读能力";
				break;
			case 5:
				abilityType = "记忆能力";
				break;
			case 6:
				abilityType = "交流能力";
				break;
			case 7:
				abilityType = "综合能力";
				break;
			}
			forWenDaQuestion.setAbilityType(abilityType);
			
			forWenDaQuestionsInList.add(forWenDaQuestion);
		}
		
		int index  = 0;
		for (Ques_Paper_Mapper tian:getWenDaList) {
			
			ForWenDaQuestion forWenDaQuestion = forWenDaQuestionsInList.get(index);
			
			Integer score = Integer.parseInt(tian.getScore());
			forWenDaQuestion.setScore(score);
			index++;
		}
		
		int i = forWenDaQuestionsInList.size();
		for (int j = 0; j < i; j++) {
			System.out.println("pppppppppppppppppppppppppppppppp" + forWenDaQuestionsInList.get(j).getContent());
			System.out.println("pppppppppppppppppppppppppppppppp" + forWenDaQuestionsInList.get(j).getScore());
		}
		
		return forWenDaQuestionsInList;
	}


}
