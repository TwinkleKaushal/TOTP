package com.connection.otp.model;

import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpModel {
	
	@Email(message = "Please enter valid mail id")
	public String email;
	private long traceId;
	private String statusCode;
	private String message;
	private String secretKey;
	private String otp;
	
	 
	
	
	

	
	
	
		
}
