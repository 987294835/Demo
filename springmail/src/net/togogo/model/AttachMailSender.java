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
		//设置邮件接收者
		mm.setRecipient(Message.RecipientType.TO, new InternetAddress(
				"987294835@qq.com"));
		//设置邮件发送者
		mm.setFrom(new InternetAddress("13502563409@163.com"));
		//设置邮件的主题
		mm.setSubject("测试邮件附件");
		//邮件内容对象
		Multipart mp = new MimeMultipart();
		//邮件主体对象，一个邮件内容对象可以包含多个邮件主体对象
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setText("发送邮件带附件");
		mp.addBodyPart(mbp);
		//设置附件文件
		String[] files = new String[] {
			"src/beans.xml","src/net/togogo/test/MailTest.java"};
		//将附件文件加到邮件内容对象中
		for (String f : files) {
			MimeBodyPart mbpFile = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(f);
			mbpFile.setDataHandler(new DataHandler(fds));
			mbpFile.setFileName(fds.getName());
			mp.addBodyPart(mbpFile);
		}
		mm.setContent(mp);
		mm.setSentDate(new Date());
		System.out.println("邮件发送成功...");
	}

}
