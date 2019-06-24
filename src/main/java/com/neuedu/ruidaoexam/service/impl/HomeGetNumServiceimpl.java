package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.ChoiceQuestionMapper;
import com.neuedu.ruidaoexam.dao.EssayQuestionMapper;
import com.neuedu.ruidaoexam.dao.JudgeQuestionMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.service.HomeGetNumService;

@Service
public class HomeGetNumServiceimpl implements HomeGetNumService{
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	
	@Autowired
	EssayQuestionMapper essayQuestionMapper;
	
	@Autowired
	JudgeQuestionMapper judgeQuestionMapper;
	
	@Override
	public int getStudentNum() {
			
			int i = studentMapper.countByExample(null);
			return i;
			
	}

	@Override
	public int getTeacherNum() {
		
		int j = teacherMapper.countByExample(null);
		return j;
		
	}

	@Override
	public int getQuestionNum() {
		
		int o = choiceQuestionMapper.countByExample(null);
		int p = essayQuestionMapper.countByExample(null);
		int q = judgeQuestionMapper.countByExample(null);
		int qn = o + p + q;
		return qn;
		
	}

}
