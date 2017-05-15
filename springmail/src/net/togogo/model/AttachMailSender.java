package net.togogo.model;

import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class AttachMailSender implements MimeMessagePreparator {
	public void prepare(MimeMessage mm) throws Exception {
		//�����ʼ�������
		mm.setRecipient(Message.RecipientType.TO, new InternetAddress(
				"987294835@qq.com"));
		//�����ʼ�������
		mm.setFrom(new InternetAddress("13502563409@163.com"));
		//�����ʼ�������
		mm.setSubject("�����ʼ�����");
		//�ʼ����ݶ���
		Multipart mp = new MimeMultipart();
		//�ʼ��������һ���ʼ����ݶ�����԰�������ʼ��������
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setText("�����ʼ�������");
		mp.addBodyPart(mbp);
		//���ø����ļ�
		String[] files = new String[] {
			"src/beans.xml","src/net/togogo/test/MailTest.java"};
		//�������ļ��ӵ��ʼ����ݶ�����
		for (String f : files) {
			MimeBodyPart mbpFile = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(f);
			mbpFile.setDataHandler(new DataHandler(fds));
			mbpFile.setFileName(fds.getName());
			mp.addBodyPart(mbpFile);
		}
		mm.setContent(mp);
		mm.setSentDate(new Date());
		System.out.println("�ʼ����ͳɹ�...");
	}

}
