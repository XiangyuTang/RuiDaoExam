package com.neuedu.ruidaoexam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.config.MailConfig;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.service.InviteService;

@Service
public class InviteServiceimpl implements InviteService{

	@Autowired
	StudentMapper studentMapper;//暂时不起作用
	
	@Override
	public void sendEmail(Student stu) {
		// TODO Auto-generated method stub
		try {
			MailConfig.send(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
