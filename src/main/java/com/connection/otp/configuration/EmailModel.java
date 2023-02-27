package com.connection.otp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class EmailModel {
	
	private String account_sid;
	private String auth_token;
	private String trial_number;
	

}
