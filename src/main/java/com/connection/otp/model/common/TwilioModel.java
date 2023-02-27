package com.connection.otp.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwilioModel {
	
	private String phoneNumber; //destination
	private String oneTimePassword;

}
