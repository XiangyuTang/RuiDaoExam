package com.neuedu.ruidaoexam.service;

//老师批改卷纸
public interface ModifyPaperService {
	void modifyChoiceQue(int reportId, int acquireScore, int answerPaperId, int quesId, String rightAns, int score, int isCorrect);
	void modifyJudgeQue(int reportId, int acquireScore, int answerPaperId, int quesId, String rightAns, int score, int isCorrect);
	void modifyEssayQue(int reportId, int acquireScore, int answerPaperId, int quesId, int score, int isCorrect);
}
