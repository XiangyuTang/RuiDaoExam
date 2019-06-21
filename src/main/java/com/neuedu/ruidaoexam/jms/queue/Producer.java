package com.neuedu.ruidaoexam.jms.queue;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.neuedu.ruidaoexam.entity.InviteStudent;
import com.neuedu.ruidaoexam.entity.MsgOfInvite;
import com.neuedu.ruidaoexam.entity.Paper;
import com.neuedu.ruidaoexam.entity.Student;
import com.neuedu.ruidaoexam.entity.Teacher;


/**
 * 定义一个点对点模式的生产者
 * 
 * 将该类注册到spring框架中 利用注解 @Component
 * @author Administrator
 *
 */
@Component
public class Producer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;

	
	/*
	 * 将一个java对象插入到一个消息队列中
	 */
	public  void send(MsgOfInvite msg, String invitecode){
		//将对象先转成json字符串,再插入到队列中
		//利用该方法,向队列中插入一个消息 , 
		//参数1: 目标队列
		//参数2: 插入内容
		TempObject to = new TempObject(msg,invitecode);//多个参数合为一个对象
		String strobj = JSON.toJSONString(to);
		jmsMessagingTemplate.convertAndSend(queue, strobj);
		
	}



}