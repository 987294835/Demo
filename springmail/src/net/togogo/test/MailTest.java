package net.togogo.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import net.togogo.model.AttachMailSender;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailTest {

	/**
	 * 测试发送简单邮件(不带附件)
	 */
	@Test
	public void testSendSimpleMail(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//获得邮件发送者对象
		JavaMailSender sender = (JavaMailSender)ac.getBean("mailSender");
		//创建邮件消息对象
		MimeMessage mime = sender.createMimeMessage();
		try {
			//设置邮件信息对象
			MimeMessageHelper helper = new MimeMessageHelper(mime,true,"utf-8");
			//设置邮件发送者
			helper.setFrom("13502563409@163.com");
			//设置邮件接收者
			helper.setTo("987294835@qq.com");
			//设置邮件主题
			helper.setSubject("大家好");
			//设置邮件内容
			helper.setText("欢迎使用spring发送邮件...");
			//发送邮件
			sender.send(mime);
			System.out.println("邮件发送成功...");
		} catch (MessagingException e) {
			e.printStackTrace();
		}	

	}
	

	/**
	 * 测试发送复杂邮件(带附件)
	 */
	@Test
	public void testSendComplexMail(){
		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		JavaMailSender ms = (JavaMailSender)bf.getBean("mailSender");
		ms.send(new AttachMailSender());
	}
}
