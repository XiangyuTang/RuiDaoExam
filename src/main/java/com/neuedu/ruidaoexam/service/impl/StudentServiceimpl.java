package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService{
    @Autowired StudentMapper stumapper;
	@Override
	public int registStudent(Student stu) {
		// TODO Auto-generated method stub
		int i=stumapper.insert(stu);
		return i;
	}
	
}
