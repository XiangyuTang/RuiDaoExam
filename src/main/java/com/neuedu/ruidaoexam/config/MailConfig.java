package com.neuedu.ruidaoexam.config;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.neuedu.ruidaoexam.entity.Student;
import com.sun.mail.util.MailSSLSocketFactory;
 
/**
 * JavaMail发送邮件:前提是QQ邮箱里帐号设置要开启POP3/SMTP协议
 */
public class MailConfig {
	
	public static void main(String[] args) throws Exception {
		Student stu = null;
		Properties prop = new Properties();
		// 开启debug调试，以便在控制台查看
		prop.setProperty("mail.debug", "true");
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");
 
		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);
 
		// 创建session
		Session session = Session.getInstance(prop);
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		// =====================自行修改账号和授权码
		ts.connect("smtp.qq.com", "1661690249@qq.com", "vvdodwkkgrihcfii");// 后面的字符是授权码
		// 创建邮件
		Message message = createSimpleMail(session,stu);
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
 
	/**
	 * @Method: createSimpleMail
	 * @Description: 创建一封只包含文本的邮件
	 */
	public static MimeMessage createSimpleMail(Session session,Student stu) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress("1661690249@qq.com"));
		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(stu.getEmail()));
		// 邮件的标题
		message.setSubject("*睿道测评通知："+stu.getName()+"同学您好！您有一场考试需要参加~");
		// 邮件的文本内容
		message.setContent("<font style='color:red'>请点击以下链接参与考试</font><br><a href='https://www.baidu.com/' >百度一下</a>", "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}
	
	public static void send(Student stu)throws Exception{
		Properties prop = new Properties();
		// 开启debug调试，以便在控制台查看
		prop.setProperty("mail.debug", "true");
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");
 
		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);
 
		// 创建session
		Session session = Session.getInstance(prop);
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		// =====================自行修改账号和授权码
		ts.connect("smtp.qq.com", "1661690249@qq.com", "vvdodwkkgrihcfii");// 后面的字符是授权码
		// 创建邮件
		Message message = createSimpleMail(session,stu);
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
	
}
