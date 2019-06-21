package com.neuedu.ruidaoexam.service;

import java.util.HashMap;
import java.util.List;

import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;

public interface QuestionService {
//	List<ChoiceQuestion> getChoiceQuestionByBankid(Integer Bank_id);
//	List<JudgeQuestion> getJudgeQuestionByBankid(Integer Bank_id);
//	List<EssayQuestion> getEssayQuestionByBankid(Integer Bank_id);
	//通过题库的id查询其包含的题目集合
	HashMap<String, List<Object>> getQuestionByBankid(Integer Bank_id);
}
