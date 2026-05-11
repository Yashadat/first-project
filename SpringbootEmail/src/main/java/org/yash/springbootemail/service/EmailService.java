package org.yash.springbootemail.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailService {
   
	 @Autowired
	 private JavaMailSender mailsender;
	 @Value("${spring.mail.username}")
	 private String fromEmail;
	 
	 
	 public void SendHtmlemail() { 
		 
		  MimeMessage mimemessage = mailsender.createMimeMessage();
	 
	       try { 
	    	
	    	    MimeMessageHelper helper= new  MimeMessageHelper(mimemessage,true, "UTF-8"); 
	    	    helper.setFrom(fromEmail);
	    	    helper.setTo("yashadat6@gmail.com");
	    	    helper.setSubject("----Welcome to Spring Boot Application----"); 
	    	    helper.setText(" Spring Boot provides built-in support for sending emails using the JavaMail API through the Simple Mail Transfer Protocol (SMTP) server ");

	    	    FileSystemResource resource =
	    	            new FileSystemResource(
	    	                    new File("C:/Users/Baban/Desktop/Spring Boot.png")
	    	            );

	    	    // Add attachment
	    	    helper.addAttachment("Spring Boot.png", resource);
	    	    
	    	    mailsender.send(mimemessage);
	    	    
	 
	    	    
	       }
	       catch(MessagingException e)
	       {
	    	   throw new RuntimeException(" Failed to Email" , e);
	       }
	       
	       System.out.println("");
	 }
	 

}
