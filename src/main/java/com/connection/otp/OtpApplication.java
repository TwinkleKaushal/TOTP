package com.connection.otp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.connection.otp.configuration.EmailModel;
import com.twilio.Twilio;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OtpApplication {
	
	@Autowired
	private EmailModel twilioconfig;
	
	
	
	@PostConstruct
	public void initTwilioConfig(){
		Twilio.init(twilioconfig.getAccount_sid(),twilioconfig.getAuth_token());
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(OtpApplication.class, args);
	}

}
