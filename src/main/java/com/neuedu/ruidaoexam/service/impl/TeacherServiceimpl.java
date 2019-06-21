package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.service.TeacherService;
@Service
public class TeacherServiceimpl implements TeacherService{
    @Autowired TeacherMapper mapper;
	@Override
	public int registTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		int i = mapper.insertSelective(teacher);
		return i;
	}

	
	
}
