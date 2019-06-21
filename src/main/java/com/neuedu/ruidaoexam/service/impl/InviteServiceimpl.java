package com.neuedu.ruidaoexam.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ruidaoexam.configUtils.MailConfig;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.service.InviteService;

@Service
public class InviteServiceimpl implements InviteService{

	@Autowired
	StudentMapper studentMapper;//暂时不起作用	
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
}
