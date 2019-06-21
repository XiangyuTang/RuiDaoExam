package com.neuedu.ruidaoexam.config;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
 
/**
 * Spring Mail
 * API都在org.springframework.mail及其子包org.springframework.mail.javamail中封装，
 * 且只提供了邮件发送的封装。 SimpleMailMessage: 对邮件的一个简单封装，只能用于表示一个纯文本的邮件，也不能包含附件等。
 * JavaMailSenderImpl: 邮件发送器，主要提供了邮件发送接口、透明创建Java
 * Mail的MimeMessage、及邮件发送的配置(如:host/port/username/password...)。
 * MimeMailMessage、MimeMessageHelper：对MimeMessage进行了封装。
 * Spring还提供了一个回调接口MimeMessagePreparator, 用于准备JavaMail的MIME信件
 * 一下代码转载自:http://www.blogjava.net/tangzurui/archive/2008/12/08/244953.html
 * 
 * @description: 使用spring-integration-mail完成邮箱发送
 * @author: skyler
 * @time: 2016年7月5日 下午6:18:05
 */

public class SendEmailUtils {
 
	//发件人，官方邮箱账号
	private String MailSender = "1661690249@qq.com";
	//授权码，第三方邮件，pop3/smtp/imap服务
	private String AuthorizationCode = "vvdodwkkgrihcfii";
	
	//收信人，实例对象时初始化
	private String MailReceiver;
	//标题
	private String MailTitle = "来自RuiDaoExam的验证邮件";
	//内容
	private String MailContent;
	
	
	/*
	 * MailReceiver:收信人; MailCode:验证码
	 * 根据参数初始化变量
	 * type=1:注册; type=2:邀请
	 */
	public SendEmailUtils(String MailReceiver,String MailCode,int type) {
		this.MailReceiver = MailReceiver;
		if(type == 1) {
			this.MailContent = "您正在RuiDaoExam网站注册账号，验证码为：" +
					MailCode + "，若非本人操作，请无视这封邮件。";
		}else {
			this.MailContent = "邀请";
		}
////		this.MailContent = "老师";
//		System.out.println("实例化对象成功");
//		System.out.println(this.MailSender);
//		System.out.println(this.MailReceiver);
//		System.out.println(this.AuthorizationCode);
//		System.out.println(this.MailTitle);
//		System.out.println(this.MailContent);
	}

	//发送邮件方法
    public void mailSend() throws MessagingException {
    	System.out.println("开始发送");
        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.smtp.auth","true");
 
        Authenticator aut = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailSender,AuthorizationCode);
 
            }
        };
 
        Session session = Session.getInstance(prop,aut);
        MimeMessage msg = new MimeMessage(session);
        //设置发件人
        msg.setFrom(new InternetAddress(MailSender));//sender
        //设置收件人
        msg.setRecipients(Message.RecipientType.TO,MailReceiver);//recipients
        //设置标题
        msg.setSubject(MailTitle);
        //设置内容
        msg.setContent(MailContent,"text/html;charset=utf-8");
        //发送
        Transport.send(msg);
        System.out.println("发送成功");
	}
    
    //@Test
	public void ts() throws MessagingException {
		SendEmailUtils seu = new SendEmailUtils("409478176@qq.com", "hh",1);
		//seu.mailSend();
	}
    
}

