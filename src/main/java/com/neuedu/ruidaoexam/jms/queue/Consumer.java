package com.neuedu.ruidaoexam.jms.queue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.neuedu.ruidaoexam.dao.InviteStudentMapper;
import com.neuedu.ruidaoexam.dao.NewsMapper;
import com.neuedu.ruidaoexam.dao.PaperMapper;
import com.neuedu.ruidaoexam.dao.StudentMapper;
import com.neuedu.ruidaoexam.dao.TeacherMapper;
import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.News;
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
public class Consumer {
	/**
	 * 在项目中随时监听demo.queue1队列 ,如果队列有变化 ,消费者就会监听到 ,会触发下面的方法,进行处理
	 * @param text
	 */
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	NewsMapper newsMapper;
	
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
		System.out.println("以下是消费者1处理得到的消息");
		System.out.println(msg.getName()+"---"+msg.getEmail());
		System.out.println(msg.getBegintime()+"---"+msg.getEndtime()+"---"+msg.getCheattimes());
		Student s = studentMapper.getStudentByEmail(msg.getEmail());
		Teacher t = teacherMapper.selectByPrimaryKey(msg.getTeacherid());
		Paper p = paperMapper.selectByPrimaryKey(msg.getPaperid());
		InviteStudent inviteStudent = new InviteStudent(null,
				p.getPaperId(),t.getTeacherId(),s.getStudentId(),msg.getBegintime(),msg.getEndtime(),invitecode,0,msg.getCheattimes());
		Date time = new Date();
		String exam_time = msg.getDatePoor(msg.getEndtime(), msg.getBegintime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh时mm分"); 
		String timeFormat = sdf.format(msg.getBegintime());
		String newsContent = "教师"+t.getName()+"邀请您在"+timeFormat+"参与考试,考试时间共计"+exam_time+",您的邀请码为："+invitecode+",请及时参加！";
		String link = "toentrance";
		News news = new News(null,0,null,s.getStudentId(),1,t.getTeacherId(),null,t.getName(),0,time,newsContent,0,link,null);
		newsMapper.insert(news);
		inviteStudentMapper.insert(inviteStudent);
		
	}
}
