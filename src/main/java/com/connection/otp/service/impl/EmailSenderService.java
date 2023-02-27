package com.connection.otp.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.connection.otp.model.common.EmailSenderModel;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
@Component
public class EmailSenderService {

	@Autowired
	private JavaMailSender javamailsender;
	
	public void sendOTPtoEmail(EmailSenderModel emailsenddto) throws MessagingException {
		
		MimeMessage mimeMessage=javamailsender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        
       mimeMessageHelper.setFrom("kaushaltwinki@gmail.com");
        mimeMessageHelper.setTo(emailsenddto.getToEmail());
        mimeMessageHelper.setText(emailsenddto.getBody());
        mimeMessageHelper.setSubject(emailsenddto.getSubject());
        
        javamailsender.send(mimeMessage);
		
	}
}
