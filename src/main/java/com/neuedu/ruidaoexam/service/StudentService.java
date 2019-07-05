package com.neuedu.ruidaoexam.service;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
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
	int addPoint(Integer stuid,Integer addNum);//026 by lb增加积分可能用到
	int degradePoint(Integer stuid,Integer degradeNum);// 0626 by lb减少积分（购买时候用到）
	List<Map<String,Object>> getBoughtPapers(Integer stuid);
	Boolean buyPaper(Integer stuid,Integer paper_id);
	/*
	 * 此处getStudent注释的为刘斌编写
	 * 由于和唐翔宇采用了二级缓存的getStudent有冲突
	 * 最后决定使用后者的getStudent
	 */
	//public Student getStudent(Integer stuid);
	@CacheEvict(value="Student")
	Student getStudent(Integer stuid);
	
	Student getStudentByEmail(String email);
}
