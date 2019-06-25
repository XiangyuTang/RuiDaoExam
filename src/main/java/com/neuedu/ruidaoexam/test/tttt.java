package com.neuedu.ruidaoexam.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.ruidaoexam.dao.ChoiceQuestionMapper;
import com.neuedu.ruidaoexam.dao.EssayQuestionMapper;
import com.neuedu.ruidaoexam.dao.JudgeQuestionMapper;
import com.neuedu.ruidaoexam.dao.Ques_Paper_MapperMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.service.impl.QuestionPaperServiceimpl;

public class tttt {
	SqlSession session = MyBatisSessionFactory.getSession();
	//
	StudentMapper mapper = session.getMapper(StudentMapper.class);
	
	ChoiceQuestionMapper choiceQuestionMapper = session.getMapper(ChoiceQuestionMapper.class);
	
	JudgeQuestionMapper judgeQuestionMapper = session.getMapper(JudgeQuestionMapper.class);;
		
	EssayQuestionMapper essayQuestionMapper = session.getMapper(EssayQuestionMapper.class);;	
	
	Ques_Paper_MapperMapper ques_Paper_MapperMapper = session.getMapper(Ques_Paper_MapperMapper.class);;
	
	@Test
	public void test()
	{		
		Student student = mapper.selectByPrimaryKey(1);
		System.out.println(student.getName());
	}
	
	public static void main(String[] args)
	{
		QuestionPaperServiceimpl qpsi = new QuestionPaperServiceimpl();
		qpsi.selectSingleChoice(1);
	}
	
	
}
