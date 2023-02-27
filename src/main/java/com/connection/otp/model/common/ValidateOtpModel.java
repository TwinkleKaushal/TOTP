package com.connection.otp.model.common;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateOtpModel {
	
	@Size(max=6,message = "Please enter 6 digit OTP")
	public String otp;
	private String statuscode;
	private String message;
	
}
