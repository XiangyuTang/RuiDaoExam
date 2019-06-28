package com.neuedu.ruidaoexam.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.StudentDataVO;

public interface StudentService {
	
	int registStudent(Student stu);
	List<Report> getGradeList(Integer stuid);
	Integer getNumberofAnswered(Integer stuid);
	Integer getNumberofNotAnswered(Integer stuid);
	List<Paper> getNotAnsweredList(Integer stuid);
	
	@Cacheable(value="Student")
	Student getStudent(Integer stuid);
}
