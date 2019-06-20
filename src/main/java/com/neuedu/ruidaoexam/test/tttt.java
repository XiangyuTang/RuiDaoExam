package com.neuedu.ruidaoexam.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.Student;

public class tttt {
	SqlSession session = MyBatisSessionFactory.getSession();
	//
	StudentMapper mapper = session.getMapper(StudentMapper.class);
	@Test
	public void test()
	{		
		Student student = mapper.selectByPrimaryKey(1);
		System.out.println(student.getName());
	}
}
