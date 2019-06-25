package com.neuedu.ruidaoexam.service;

import com.neuedu.ruidaoexam.entity.Teacher;

public interface TeacherService {
	int registTeacher(Teacher teacher);
	String getTeacherNameByPaper(Integer created_id);//lb增加 学生index页面要用到

}
