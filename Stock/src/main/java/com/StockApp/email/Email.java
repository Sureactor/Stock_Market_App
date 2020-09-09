 package com.StockApp.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class Email {

	@Value("${gmail.username}")
	private String username;
	@Value("${gmail.password}")
	private String password;
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailAttribute email) throws AddressException, MessagingException {
		System.out.println("++++++++++"+username+"   "+password+"+++++++");
		send(email);
		return "Email sent Successfully";
	}
	
	public void send(EmailAttribute email) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.auth",true);
		props.put("mail.smtp.starttls.enable",true);
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
		SmtpAuthenticator authentication = new SmtpAuthenticator();
		javax.mail.Message msg = new MimeMessage(Session
		                    .getDefaultInstance(props, authentication));
//		Session session = Session.getInstance(props,
//				new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthenticattion() {
//				return new PasswordAuthentication(username,password);	
//			}
//		});
//		
//		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username,false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("suredirector1998@gmail.com"));
		msg.setSubject(email.getSubject());
		msg.setContent(email.getBody(),"text/html");
		msg.setSentDate(new Date());
		
		
//		MimeBodyPart messageBodyPart = new MimeBodyPart();
//		messageBodyPart.setContent("email body content","text/html");
//			
//		Multipart multipart = new MimeMultipart();
//		multipart.addBodyPart(messageBodyPart);
//		MimeBodyPart attachPort = new MimeBodyPart();
//		attachPor.attachFile
		Transport.send(msg);
	}
}

class SmtpAuthenticator extends Authenticator {
public SmtpAuthenticator() {

    super();
}

@Override
public PasswordAuthentication getPasswordAuthentication() {
 String username = "demomama1998@gmail.com";
 String password = "demomapla";
    if ((username != null) && (username.length() > 0) && (password != null) 
      && (password.length   () > 0)) {

        return new PasswordAuthentication(username, password);
    }

    return null;
}
}
