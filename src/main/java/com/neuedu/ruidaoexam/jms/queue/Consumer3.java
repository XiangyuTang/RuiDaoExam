package com.neuedu.ruidaoexam.jms.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.neuedu.ruidaoexam.dao.InviteStudentMapper;
import com.neuedu.ruidaoexam.dao.PaperMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;


/**
 * 定义点对点模式的消费者
 * @author Administrator
 * @Component 记得在类前加一个component表示将该类注册到框架中，由框架来管理和调用
 */
@Component
public class Consumer3 {
	/**
	 * 在项目中随时监听EmailsQueue队列 ,如果队列有变化 ,消费者就会监听到 ,会触发下面的方法,进行处理
	 * @param text
	 */
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	InviteStudentMapper inviteStudentMapper; 
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	PaperMapper paperMapper;
	
	@JmsListener(destination="EmailsQueue")
	public void receiveQueue(String text){
		//System.out.println("----  customer1 receive message ,message text: "+text);
		
		//fastjson提供一个方式,将文本类型强转成对象类型
		/*UserInfo u = JSON.parseObject(text , new TypeReference<UserInfo>(){});
		
		System.out.println("从队列中得到的对象的内容是"+u.toString());
		userInfoMapper.addUser(u);*/
		TempObject to = JSON.parseObject(text , new TypeReference<TempObject>(){});
		MsgOfInvite msg = to.getMsg();
		String invitecode = to.getInvitecode();
		System.out.println("以下是消费者3处理得到的消息");
		System.out.println(msg.getName()+"---"+msg.getEmail());
		System.out.println(msg.getBegintime()+"---"+msg.getEndtime()+"---"+msg.getCheattimes());
		Student s = studentMapper.getStudentByEmail(msg.getEmail());
		Teacher t = teacherMapper.selectByPrimaryKey(msg.getTeacherid());
		Paper p = paperMapper.selectByPrimaryKey(msg.getPaperid());
		InviteStudent inviteStudent = new InviteStudent(null,
				p.getPaperId(),t.getTeacherId(),s.getStudentId(),msg.getBegintime(),msg.getEndtime(),invitecode,0,msg.getCheattimes());
		inviteStudentMapper.insert(inviteStudent);
		
	}
}
