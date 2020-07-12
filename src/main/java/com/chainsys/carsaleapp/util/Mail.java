package com.chainsys.carsaleapp.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class Mail {
	
	public void send(String to, String subject, String body)throws IOException {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		 String username = "dontreply1233@gmail.com"; // GMail user name (just the part before "@gmail.com")
			String password = "carresaleapp"; // GMail password

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.ssl.trust","smtp.gmail.com");
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username,password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sentsuccessfully");

		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}
