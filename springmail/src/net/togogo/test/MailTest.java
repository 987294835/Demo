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
	 * ���Է��ͼ��ʼ�(��������)
	 */
	@Test
	public void testSendSimpleMail(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//����ʼ������߶���
		JavaMailSender sender = (JavaMailSender)ac.getBean("mailSender");
		//�����ʼ���Ϣ����
		MimeMessage mime = sender.createMimeMessage();
		try {
			//�����ʼ���Ϣ����
			MimeMessageHelper helper = new MimeMessageHelper(mime,true,"utf-8");
			//�����ʼ�������
			helper.setFrom("13502563409@163.com");
			//�����ʼ�������
			helper.setTo("987294835@qq.com");
			//�����ʼ�����
			helper.setSubject("��Һ�");
			//�����ʼ�����
			helper.setText("��ӭʹ��spring�����ʼ�...");
			//�����ʼ�
			sender.send(mime);
			System.out.println("�ʼ����ͳɹ�...");
		} catch (MessagingException e) {
			e.printStackTrace();
		}	

	}
	

	/**
	 * ���Է��͸����ʼ�(������)
	 */
	@Test
	public void testSendComplexMail(){
		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		JavaMailSender ms = (JavaMailSender)bf.getBean("mailSender");
		ms.send(new AttachMailSender());
	}
}
