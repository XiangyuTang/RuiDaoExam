package com.neuedu.ruidaoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.ReportMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.QuestionBank;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.ReportExample;
import com.neuedu.ruidaoexam.entity.ReportExample.Criteria;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.TradeRecord;
import com.neuedu.ruidaoexam.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService{
    @Autowired StudentMapper stumapper;
    @Autowired ReportMapper reportmapper;
	@Override
	public int registStudent(Student stu) {
		// TODO Auto-generated method stub
		int i=stumapper.insert(stu);
		return i;
	}
	@Override
	public List<Report> getGradeList(Integer stuid) {
		ReportExample reportExample=new ReportExample();
		Criteria criteria=reportExample.createCriteria();
		criteria.andStuIdEqualTo(stuid);
		criteria.andIsAllowedToSeeEqualTo(1);
		List<Report> reports=reportmapper.selectByExample(reportExample);
		return reports;
		
	}
}
