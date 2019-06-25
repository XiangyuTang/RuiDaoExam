package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.EssayQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;

public interface QuestionPaperService {
	List<ChoiceQuestion> selectSingleChoice(Integer paper_id);
	List<ChoiceQuestion> selectMultipleChoice(Integer paper_id);
	List<JudgeQuestion> selectJudge(Integer paper_id);
	List<EssayQuestion> selectFillBlank(Integer paper_id);
	List<EssayQuestion> selectShortAnswer(Integer paper_id);
}
