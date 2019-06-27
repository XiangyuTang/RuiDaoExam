package com.neuedu.ruidaoexam.service;

import java.util.ArrayList;

public interface addQuestionService {
	String characterToBinary(String character);
	void addChoiceQuestion(ArrayList<String> questionsArray,int bank_id);
	void addEssayQuestion(ArrayList<String> questionsArray, int bank_id);
	void addJudgeQuestion(ArrayList<String> questionsArray, int bank_id);
	void addQues_Bank_Mapper(int bank_id,int question_type, int question_id);
}
