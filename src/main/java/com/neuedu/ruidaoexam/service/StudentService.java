package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.Report;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.StudentDataVO;

public interface StudentService {
	
	int registStudent(Student stu);
	List<Report> getGradeList(Integer stuid);
	StudentDataVO getStudentIndexData(Integer stuid);
}
