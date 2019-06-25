package com.neuedu.ruidaoexam.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.configUtils.MailConfig;
import com.neuedu.ruidaoexam.dao.InviteStudentMapper;
import com.neuedu.ruidaoexam.dao.PaperMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;
import com.neuedu.ruidaoexam.service.InviteService;
import com.neuedu.ruidaoexam.jms.queue.Producer;

@Service
public class InviteServiceimpl implements InviteService{

	@Autowired
	InviteStudentMapper inviteStudentMapper;

	@Autowired
	Producer producer;//注入一个queue的生产者

	@Override
	public void sendEmail(MsgOfInvite msg,String invitecode) {
		// TODO Auto-generated method stub
		try {
			MailConfig.send(msg,invitecode);
			/*Student student = studentMapper.selectByPrimaryKey(1);
			System.out.println("学生的名字："+student.getName());*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//利用queue添加邀请消息，以处理高并发情况
	@Override
	public int addInviteMsg(MsgOfInvite msg, String invitecode) {
		// TODO Auto-generated method stub
		producer.send(msg, invitecode);
		return 1;
	}

	@Override
	public InviteStudent verifyPerson(String email, String invitecode) {
		// TODO Auto-generated method stub
		InviteStudent inviteStudent  = inviteStudentMapper.selectByEmailAndInvitecode(email, invitecode);
		if(inviteStudent!=null)
			return inviteStudent;
		return null;
	}	
}
