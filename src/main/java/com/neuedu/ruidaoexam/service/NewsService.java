package com.neuedu.ruidaoexam.service;

import java.util.List;

import com.neuedu.ruidaoexam.entity.News;

public interface NewsService {
	List<News> getTeacherNews(Integer receive_teacher_id);
	List<News> getStudentNews(Integer receive_student_id);
	Integer countTeacherReceiveNews(Integer receive_teacher_id);
	Integer countStudentReceiveNews(Integer receive_student_id);
	int insertNews(News news);
}
