package com.connection.otp.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSenderModel {
	
	private String toEmail;
	private String body;
	private String subject;
	

}
