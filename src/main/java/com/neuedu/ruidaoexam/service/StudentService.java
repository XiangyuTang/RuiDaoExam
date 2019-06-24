package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.Student;

public interface StudentService {
	
	int registStudent(Student stu);
	List<Report> getGradeList(Integer stuid);
	int getNumberOfAnsweredPaper(Integer stuid);
}
