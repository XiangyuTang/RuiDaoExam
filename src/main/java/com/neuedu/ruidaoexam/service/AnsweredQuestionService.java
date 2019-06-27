package com.neuedu.ruidaoexam.service;

import com.neuedu.ruidaoexam.entity.AnsweredQuestion;

public interface AnsweredQuestionService {
	int update(AnsweredQuestion aq);
	int selectPrimeKey(AnsweredQuestion aq);
}
