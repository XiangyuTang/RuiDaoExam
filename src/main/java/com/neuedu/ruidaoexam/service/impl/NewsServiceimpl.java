package com.neuedu.ruidaoexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.NewsMapper;
import com.neuedu.ruidaoexam.entity.News;
import com.neuedu.ruidaoexam.service.NewsService;

import io.lettuce.core.models.command.CommandDetail.Flag;
@Service
public class NewsServiceimpl implements NewsService {
	@Autowired
	NewsMapper newsMapper;
	@Override
	public List<News> getTeacherNews(Integer receive_teacher_id) {
		List<News> TeacherNews = newsMapper.getAllTeacherNews(receive_teacher_id);
		newsMapper.updateIsReadByTeacher_id(receive_teacher_id);
		return TeacherNews;
	}

	@Override
	public List<News> getStudentNews(Integer receive_student_id) {
		List<News> StudentNews = newsMapper.getAllStudentNews(receive_student_id);
		newsMapper.updateIsReadByStudent_id(receive_student_id);
		return StudentNews;
	}

	@Override
	public Integer countTeacherReceiveNews(Integer receive_teacher_id) {
		int i = newsMapper.countTeacherReceiveNews(receive_teacher_id);
		return i;
	}

	@Override
	public Integer countStudentReceiveNews(Integer receive_student_id) {
		int i = newsMapper.countStudentReceiveNews(receive_student_id);
		return i;
	}

	@Override
	public int insertNews(News news) {
		// TODO Auto-generated method stub
		int i = newsMapper.insert(news);
		return i;
	}
	
}
