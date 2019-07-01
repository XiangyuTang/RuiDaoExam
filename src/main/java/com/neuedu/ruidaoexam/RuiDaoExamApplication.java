package com.neuedu.ruidaoexam;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.neuedu.ruidaoexam.dao"})
public class RuiDaoExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuiDaoExamApplication.class, args);
	}
	/**
	 * springboot 在启动的时候 ,自动实例化带有@Bean注解的对象 
	 * 
	 * @return 返回值是一个Queue 队列的对象   Stack
	 */
	@Bean
	public Queue queue(){
		//定义一个点对点队列  ,名称为EmailsQueue
		return new ActiveMQQueue("EmailsQueue");
	}
	
	
	/*@Bean
	public Topic topic(){
		//定义一个主题模式队列  ,名称为EmailsTopic 
		return new ActiveMQTopic("EmailsTopic");
	}*/
}
