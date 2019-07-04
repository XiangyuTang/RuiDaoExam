package com.neuedu.ruidaoexam.service;

import java.util.ArrayList;

import com.neuedu.ruidaoexam.entity.ChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForChoiceQuestion;
import com.neuedu.ruidaoexam.entity.ForJudgeQuestion;
import com.neuedu.ruidaoexam.entity.ForTianKongQuestion;
import com.neuedu.ruidaoexam.entity.ForWenDaQuestion;
import com.neuedu.ruidaoexam.entity.JudgeQuestion;

public interface PreviewService {
	
	ArrayList<String> getNum(int paper_id);
	
	ArrayList<ForChoiceQuestion> getXuanZe(int paper_id);	//呈现选择题答题情况
	
	ArrayList<ForJudgeQuestion> getPanDuan(int paper_id);	//呈现判断题答题情况
	
	ArrayList<ForTianKongQuestion> getTianKong(int paper_id);	//呈现填空题答题情况
	
	ArrayList<ForWenDaQuestion> getWenDa(int paper_id);	//呈现问答题答题情况
	
}
