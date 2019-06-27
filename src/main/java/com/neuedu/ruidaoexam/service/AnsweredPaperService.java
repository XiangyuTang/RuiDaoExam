package com.neuedu.ruidaoexam.service;

import com.neuedu.ruidaoexam.entity.AnsweredPaper;

public interface AnsweredPaperService {
	int insert(AnsweredPaper ap);

	Integer selectPrimeKey(AnsweredPaper answerpaper);
}
